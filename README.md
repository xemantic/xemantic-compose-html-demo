# xemantic-compose-html-demo

A demo project of Jetpack Compose HTML styled with Beer CSS

[<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/com.xemantic.compose.html.demo/xemantic-compose-html-demo">](https://central.sonatype.com/artifact/com.xemantic.compose.html.demo/xemantic-compose-html-demo)
[<img alt="GitHub Release Date" src="https://img.shields.io/github/release-date/xemantic/xemantic-compose-html-demo">](https://github.com/xemantic/xemantic-compose-html-demo/releases)
[<img alt="license" src="https://img.shields.io/github/license/xemantic/xemantic-compose-html-demo?color=blue">](https://github.com/xemantic/xemantic-compose-html-demo/blob/main/LICENSE)

[<img alt="GitHub Actions Workflow Status" src="https://img.shields.io/github/actions/workflow/status/xemantic/xemantic-compose-html-demo/build-main.yml">](https://github.com/xemantic/xemantic-compose-html-demo/actions/workflows/build-main.yml)
[<img alt="GitHub branch check runs" src="https://img.shields.io/github/check-runs/xemantic/xemantic-compose-html-demo/main">](https://github.com/xemantic/xemantic-compose-html-demo/actions/workflows/build-main.yml)
[<img alt="GitHub commits since latest release" src="https://img.shields.io/github/commits-since/xemantic/xemantic-compose-html-demo/latest">](https://github.com/xemantic/xemantic-compose-html-demo/commits/main/)
[<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/xemantic/xemantic-compose-html-demo">](https://github.com/xemantic/xemantic-compose-html-demo/commits/main/)

[<img alt="GitHub contributors" src="https://img.shields.io/github/contributors/xemantic/xemantic-compose-html-demo">](https://github.com/xemantic/xemantic-compose-html-demo/graphs/contributors)
[<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/t/xemantic/xemantic-compose-html-demo">](https://github.com/xemantic/xemantic-compose-html-demo/commits/main/)
[<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/xemantic/xemantic-compose-html-demo">]()
[<img alt="GitHub Created At" src="https://img.shields.io/github/created-at/xemantic/xemantic-compose-html-demo">](https://github.com/xemantic/xemantic-compose-html-demo/commits)
[<img alt="kotlin version" src="https://img.shields.io/badge/dynamic/toml?url=https%3A%2F%2Fraw.githubusercontent.com%2Fxemantic%2Fxemantic-compose-html-demo%2Fmain%2Fgradle%2Flibs.versions.toml&query=versions.kotlin&label=kotlin">](https://kotlinlang.org/docs/releases.html)
[<img alt="discord users online" src="https://img.shields.io/discord/811561179280965673">](https://discord.gg/vQktqqN2Vn)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?logo=bluesky&logoColor=fff)](https://bsky.app/profile/xemantic.com)

## Why?

This project demonstrates the capabilities of Compose HTML for building modern web applications using Kotlin multiplatform technology.

## Usage

In `build.gradle.kts` add:

```kotlin
dependencies {
    implementation("com.xemantic.compose.html.demo:xemantic-compose-html-demo:0.3.0")
}
```

## Development

### Build and Test

```shell
./gradlew build
./gradlew test
```

### Update Dependencies

All gradle dependencies are managed by the [libs.versions.toml](gradle/libs.versions.toml) file.

Check for latest versions:

```shell
./gradlew dependencyUpdates
```
