# port-lint Proposed Changes

**Generated:** 2026-08-25
**Source:** tmp/webbrowser/src
**Target:** src/commonMain/kotlin/io/github/kotlinmania/webbrowser

These are review proposals only. They are emitted when a Rust -> Kotlin pair matches only after fallback normalization, so the existing `port-lint` header is not an exact provenance match.

| Target file | Current header | Proposed header | Source path | Reason |
|-------------|----------------|-----------------|-------------|--------|
| `src/commonMain/kotlin/io/github/kotlinmania/webbrowser/Browser.kt` | `// port-lint: source tmp/webbrowser/src/lib.rs` | `// port-lint: source lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'tmp/webbrowser/src/lib.rs' vs expected 'lib.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/webbrowser/BrowserOptions.kt` | `// port-lint: source tmp/webbrowser/src/lib.rs` | `// port-lint: source lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'tmp/webbrowser/src/lib.rs' vs expected 'lib.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/webbrowser/TargetType.kt` | `// port-lint: source tmp/webbrowser/src/lib.rs` | `// port-lint: source lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'tmp/webbrowser/src/lib.rs' vs expected 'lib.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/webbrowser/WebBrowserException.kt` | `// port-lint: source tmp/webbrowser/src/lib.rs` | `// port-lint: source lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'tmp/webbrowser/src/lib.rs' vs expected 'lib.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/webbrowser/Webbrowser.kt` | `// port-lint: source tmp/webbrowser/src/lib.rs` | `// port-lint: source lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'tmp/webbrowser/src/lib.rs' vs expected 'lib.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/webbrowser/BrowserTest.kt` | `// port-lint: tests tmp/webbrowser/src/lib.rs` | `// port-lint: tests lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:tmp/webbrowser/src/lib.rs' vs expected 'lib.rs'` |
