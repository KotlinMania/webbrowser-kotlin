# webbrowser-kotlin in Kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Fwebbrowser--kotlin-blue.svg)](https://github.com/KotlinMania/webbrowser-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/webbrowser-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/webbrowser-kotlin)
[![Build status](https://img.shields.io/github/actions/workflow/status/KotlinMania/webbrowser-kotlin/ci.yml?branch=main)](https://github.com/KotlinMania/webbrowser-kotlin/actions)

This is a Kotlin Multiplatform line-by-line transliteration port of [`amodm/webbrowser-rs`](https://github.com/amodm/webbrowser-rs).

**Original Project:** This port is based on [`amodm/webbrowser-rs`](https://github.com/amodm/webbrowser-rs). All design credit and project intent belong to the upstream authors; this repository is a faithful port to Kotlin Multiplatform with no behavioural changes intended.

### Porting status

This is an **in-progress port**. The goal is feature parity with the upstream Rust crate while providing a native Kotlin Multiplatform API. Every Kotlin file carries a `// port-lint: source <path>` header naming its upstream Rust counterpart so the AST-distance tool can track provenance.

---

## Upstream README — `amodm/webbrowser-rs`

> The text below is reproduced and lightly edited from [`https://github.com/amodm/webbrowser-rs`](https://github.com/amodm/webbrowser-rs). It is the upstream project's own description and remains under the upstream authors' authorship; links have been rewritten to absolute upstream URLs so they continue to resolve from this repository.

## webbrowser

[![Current Crates.io Version](https://img.shields.io/crates/v/webbrowser.svg)](https://crates.io/crates/webbrowser)
[![Crates.io Downloads](https://img.shields.io/crates/d/webbrowser.svg)](https://crates.io/crates/webbrowser)
[![License](https://img.shields.io/crates/l/webbrowser.svg)](#license)

![Linux Build](https://github.com/amodm/webbrowser-rs/workflows/Linux/badge.svg?branch=main&x=1)
![Windows Build](https://github.com/amodm/webbrowser-rs/workflows/Windows/badge.svg?branch=main&x=1)
![MacOS Build](https://github.com/amodm/webbrowser-rs/workflows/MacOS/badge.svg?branch=main&x=1)
![iOS Build](https://github.com/amodm/webbrowser-rs/workflows/iOS/badge.svg?branch=main&x=1)
![Android Build](https://github.com/amodm/webbrowser-rs/workflows/Android/badge.svg?branch=main&x=1)
![WASM Build](https://github.com/amodm/webbrowser-rs/workflows/WASM/badge.svg?branch=main&x=1)

Rust library to open URLs and local files in the web browsers available on a platform, with guarantees of [Consistent Behaviour](#consistent-behaviour).

Inspired by the [webbrowser](https://docs.python.org/2/library/webbrowser.html) python library

## Documentation

- [API Reference](https://docs.rs/webbrowser)
- [Release Notes](https://github.com/amodm/webbrowser-rs/blob/HEAD/CHANGELOG.md)

## Examples

```rust
use webbrowser;

if webbrowser::open("http://github.com").is_ok() {
    // ...
}
```

## Platform Support

| Platform | Supported | Browsers | Test status |
|----------|-----------|----------|-------------|
| macos    | ✅        | default + [others](https://docs.rs/webbrowser/latest/webbrowser/enum.Browser.html) | ✅ |
| windows  | ✅        | default only | ✅ |
| linux/wsl | ✅       | default only (respects $BROWSER env var, so can be used with other browsers) | ✅ |
| android  | ✅        | default only | ✅ |
| ios/tvOS/visionOS    | ✅        | default only | ✅ |
| wasm     | ✅        | default only | ✅ |
| unix (*bsd, aix etc.) | ✅        | default only (respects $BROWSER env var, so can be used with other browsers) | Manual |

## Consistent Behaviour
`webbrowser` defines consistent behaviour on all platforms as follows:
* **Browser guarantee** - This library guarantees that the browser is opened, even for local files - the only crate to make such guarantees
at the time of this writing. Alternative libraries rely on existing system commands, which may lead to an editor being opened (instead
of the browser) for local html files, leading to an inconsistent behaviour for users.
* **Non-Blocking** for GUI based browsers (e.g. Firefox, Chrome etc.), while **Blocking** for text based browser (e.g. lynx etc.)
* **Suppressed output** by default for GUI based browsers, so that their stdout/stderr don't pollute the main program's output. This can be
overridden by `webbrowser::open_browser_with_options`.

## Crate Features
`webbrowser` optionally allows the following features to be configured:
* `hardened` - this disables handling of non-http(s) urls (e.g. `file:///`) as a hard security precaution
* `disable-wsl` - this disables WSL `file` implementation (`http` still works)
* `wasm-console` - this enables logging to wasm console (valid only on wasm platform)

## Looking to contribute?

PRs invited for

* Bugs
* Supporting non-default browser invocation on any platform

Important note (while testing):

* This library requires availability of browsers and a graphical environment during runtime
* `cargo test` will actually open the browser locally

When contributing, please note that your work will be dual licensed as MIT + Apache-2.0 (see below).

## License

`SPDX-License-Identifier: Apache-2.0 OR MIT`

Licensed under either of

* Apache License, Version 2.0, ([LICENSE-APACHE](https://github.com/amodm/webbrowser-rs/blob/HEAD/LICENSE-APACHE) or http://www.apache.org/licenses/LICENSE-2.0)
* MIT license ([LICENSE-MIT](https://github.com/amodm/webbrowser-rs/blob/HEAD/LICENSE-MIT) or http://opensource.org/licenses/MIT)

at your option.

### Contribution

Unless you explicitly state otherwise, any contribution intentionally submitted
for inclusion in the work by you, as defined in the Apache-2.0 license, shall be dual licensed as above, without any
additional terms or conditions.

---

## About this Kotlin port

### Installation

```kotlin
dependencies {
    implementation("io.github.kotlinmania:webbrowser-kotlin:0.1.0")
}
```

### Building

```bash
./gradlew build
./gradlew test
```

### Targets

- macOS arm64
- Linux x64
- Windows mingw-x64
- iOS arm64 / simulator-arm64 (Swift export + XCFramework)
- JS (browser + Node.js)
- Wasm-JS (browser + Node.js)
- Android (API 24+)

### Porting guidelines

See [AGENTS.md](AGENTS.md) and [CLAUDE.md](CLAUDE.md) for translator discipline, port-lint header convention, and Rust → Kotlin idiom mapping.

### License

This Kotlin port is distributed under the same MIT license as the upstream [`amodm/webbrowser-rs`](https://github.com/amodm/webbrowser-rs). See [LICENSE](LICENSE) (and any sibling `LICENSE-*` / `NOTICE` files mirrored from upstream) for the full text.

Original work copyrighted by the webbrowser-rs authors.  
Kotlin port: Copyright (c) 2026 Sydney Renee and The Solace Project.

### Acknowledgments

Thanks to the [`amodm/webbrowser-rs`](https://github.com/amodm/webbrowser-rs) maintainers and contributors for the original Rust implementation. This port reproduces their work in Kotlin Multiplatform; bug reports about upstream design or behavior should go to the upstream repository.
