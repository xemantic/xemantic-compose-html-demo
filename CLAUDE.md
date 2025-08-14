# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Kotlin multiplatform project template from Xemantic, designed to bootstrap new multiplatform library projects. The project uses Gradle with Kotlin DSL and supports multiple targets including JVM, JS, WASM, and various native platforms.

## Development Commands

### Build and Test
- `./gradlew build` - Build the entire project
- `./gradlew test` - Run all tests
- `./gradlew check` - Run all verification tasks (tests, lint, etc.)
- `./gradlew clean` - Clean all build artifacts

### Specific Platform Testing
- `./gradlew jvmTest` - Run JVM tests only
- `./gradlew jsTest` - Run JavaScript tests only
- `./gradlew wasmJsTest` - Run WASM-JS tests only

Note: Some simulator tests are disabled by default (`tvosSimulatorArm64Test`, `watchosSimulatorArm64Test`) as they require XCode components.

### Dependency Management
- `./gradlew dependencyUpdates` - Check for dependency updates using the versions plugin
- All dependencies are managed in `gradle/libs.versions.toml`

### Documentation
- `./gradlew dokkaGeneratePublicationHtml` - Generate API documentation using Dokka

### Publishing
- `./gradlew publishToMavenLocal` - Publish to local Maven repository
- `./gradlew jreleaserDeploy` - Deploy to Maven Central (requires proper credentials)

## Architecture

### Multiplatform Structure
- `src/commonMain/kotlin/` - Common Kotlin code shared across all platforms
- `src/commonTest/kotlin/` - Common test code
- Platform-specific source sets are configured but not used in this template

### Key Components
- **HelloWorld.kt**: Template main code with `Foo` object and `main()` function
- **HelloWorldTest.kt**: Example test using xemantic-kotlin-test library with power-assert
- **build.gradle.kts**: Main build configuration with all platform targets and publishing setup

### Testing Framework
Uses xemantic-kotlin-test library with power-assert plugin for enhanced assertions:
```kotlin
Foo should {
    have(BAR == "buzz")
}
```

### Build Configuration
- Kotlin compilation targets: JVM (17), JS, WASM (JS/WASI), and comprehensive native targets
- Explicit API mode enabled for library projects
- Progressive mode and context-sensitive resolution enabled
- Binary compatibility validation configured
- JReleaser configured for automated publishing to Maven Central

## Template Customization

This is a template project with several TODOs that need to be addressed:
- Update project name in `settings.gradle.kts`
- Change package name from `com.xemantic.template.kotlin.multiplatform`  
- Update group in `build.gradle.kts` from `com.xemantic.template`
- Replace template code in `HelloWorld.kt` and `HelloWorldTest.kt`
- Update project description and metadata in `build.gradle.kts`
- Follow the `CHECKLIST.md` for complete setup

## Dependencies

Key dependencies managed in `gradle/libs.versions.toml`:
- Kotlin 2.2.0 with multiplatform support
- xemantic-kotlin-test for testing
- Various Gradle plugins for building, documentation, and publishing