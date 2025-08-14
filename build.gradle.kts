@file:OptIn(ExperimentalWasmDsl::class, ExperimentalKotlinGradlePluginApi::class)

import com.xemantic.gradle.conventions.License
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import org.jreleaser.model.Active

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.power.assert)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlinx.binary.compatibility.validator)
    alias(libs.plugins.dokka)
    alias(libs.plugins.versions)
    `maven-publish`
    signing
    alias(libs.plugins.jreleaser)
    alias(libs.plugins.xemantic.conventions)
}

group = "com.xemantic.compose.html.demo"

xemantic {
    description = "A demo project of Jetpack Compose HTML styled with Beer CSS"
    inceptionYear = 2025
    license = License.APACHE
    developer(
        id = "morisil",
        name = "Kazik Pogoda",
        email = "morisil@xemantic.com"
    )
}

val releaseAnnouncementSubject = """🚀 ${rootProject.name} $version has been released!"""

val releaseAnnouncement = """
$releaseAnnouncementSubject

${xemantic.description}

${xemantic.releasePageUrl}
"""

val javaTarget = libs.versions.javaTarget.get()
val kotlinTarget = KotlinVersion.fromVersion(libs.versions.kotlinTarget.get())

repositories {
    mavenCentral()
    google()
}

kotlin {

    compilerOptions {
        apiVersion = kotlinTarget
        languageVersion = kotlinTarget
        freeCompilerArgs.addAll(
            "-Xcontext-parameters",
            "-Xcontext-sensitive-resolution"
        )
        extraWarnings = true
        progressiveMode = true
    }

    js {
        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
            }
        }
        binaries.executable()
    }


    sourceSets {

        jsMain {
            dependencies {
                implementation(libs.compose.html.core)
                implementation(libs.compose.runtime)
            }
        }

        jsTest {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.xemantic.kotlin.test)
            }
        }

    }

}

tasks {

}

powerAssert {
    functions = listOf(
        "com.xemantic.kotlin.test.assert",
        "com.xemantic.kotlin.test.have"
    )
}

// https://kotlinlang.org/docs/dokka-migration.html#adjust-configuration-options
dokka {
    pluginsConfiguration.html {
        footerMessage.set(xemantic.copyright)
    }
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    from(tasks.dokkaGeneratePublicationHtml)
}

publishing {
    publications {
        withType<MavenPublication> {
            artifact(javadocJar)
            xemantic.configurePom(this)
        }
    }
}

jreleaser {
    project {
        description = xemantic.description
        copyright = xemantic.copyright
        license = xemantic.license!!.spxdx
        links {
            homepage = xemantic.homepageUrl
            documentation = xemantic.documentationUrl
        }
        authors = xemantic.authorIds
    }
    deploy {
        maven {
            mavenCentral {
                create("maven-central") {
                    active = Active.ALWAYS
                    url = "https://central.sonatype.com/api/v1/publisher"
                    applyMavenCentralRules = false
                    maxRetries = 240
                    stagingRepository(xemantic.stagingDeployDir.path)
                    // workaround: https://github.com/jreleaser/jreleaser/issues/1784
                    kotlin.targets.forEach { target ->
                        if (target !is KotlinJvmTarget) {
                            val nonJarArtifactId = if (target.platformType == KotlinPlatformType.wasm) {
                                "${name}-wasm-${target.name.lowercase().substringAfter("wasm")}"
                            } else {
                                "${name}-${target.name.lowercase()}"
                            }
                            artifactOverride {
                                artifactId = nonJarArtifactId
                                jar = false
                                verifyPom = false
                                sourceJar = false
                                javadocJar = false
                            }
                        }
                    }
                }
            }
        }
    }
    release {
        github {
            skipRelease = true // we are releasing through GitHub UI
            skipTag = true
            token = "empty"
            changelog {
                enabled = false
            }
        }
    }
    checksum {
        individual = false
        artifacts = false
        files = false
    }
    announce {
        webhooks {
            create("discord") {
                active = Active.ALWAYS
                message = releaseAnnouncement
                messageProperty = "content"
                structuredMessage = true
            }
        }
        linkedin {
            active = Active.ALWAYS
            subject = releaseAnnouncementSubject
            message = releaseAnnouncement
        }
        bluesky {
            active = Active.ALWAYS
            status = releaseAnnouncement
        }
    }
}
