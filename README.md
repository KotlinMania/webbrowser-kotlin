# Webbrowser in Kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Fwebbrowser--kotlin-blue.svg)](https://github.com/KotlinMania/webbrowser-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/webbrowser-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/webbrowser-kotlin)
[![Build status](https://img.shields.io/github/actions/workflow/status/KotlinMania/webbrowser-kotlin/ci.yml?branch=main)](https://github.com/KotlinMania/webbrowser-kotlin/actions)

Kotlin Multiplatform line-by-line clean-room port of the Rust crate [`webbrowser`](https://crates.io/crates/webbrowser).

> **Status: scaffold — porting has not started.** This repo currently contains build infrastructure only. The upstream Rust source for the `webbrowser` crate will be cloned into `tmp/` (gitignored) when porting begins.

## About

Open a URL in the user's default browser

This port targets functional parity with the upstream Rust crate while presenting an idiomatic Kotlin Multiplatform API. Every Kotlin file is a faithful translation of an upstream Rust file and carries a `// port-lint: source <path>` header so the AST-distance tool can track provenance.

## Supported targets

- macOS arm64 / x64
- Linux x64
- Windows mingw-x64
- iOS arm64 / x64 / simulator-arm64
- JS (browser + Node.js)
- Wasm-JS (browser + Node.js)
- Android (API 24+)

## Installation

Once published:

```kotlin
dependencies {
    implementation("io.github.kotlinmania:webbrowser-kotlin:0.1.0-SNAPSHOT")
}
```

## Build

```bash
./gradlew build
./gradlew test
```

## Porting guidelines

See [CLAUDE.md](CLAUDE.md) and [AGENTS.md](AGENTS.md) for translator discipline, port-lint header convention, and Rust → Kotlin idiom mapping.

## License

Apache 2.0 — see [LICENSE](LICENSE).

Original work copyrighted by the upstream `webbrowser` authors. Kotlin port copyright (c) 2026 Sydney Renee and The Solace Project.
