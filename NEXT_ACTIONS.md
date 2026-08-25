# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 1/8 (12.5%)
- **Function parity:** 11/67 matched (target 26) — 16.4%
- **Class/type parity:** 3/13 matched (target 6) — 23.1%
- **Combined symbol parity:** 14/80 matched (target 32) — 17.5%
- **Average inline-code cosine:** 0.00 (function body across 0 matched files)
- **Average documentation cosine:** 0.00 (doc text across 0 matched files)
- **Cheat-zeroed Files:** 1
- **Critical Issues:** 1 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. lib

- **Target:** `webbrowser.Browser [STUB] [PROVENANCE-FALLBACK]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 152910.0
- **Functions:** 11/22 matched (target 26)
- **Missing functions:** `fmt`, `description`, `from_str`, `default`, `from_file_path`, `deref`, `try_from`, `test_open_firefox`, `test_open_chrome`, `test_open_safari`, `test_open_webpositive`
- **Types:** 3/7 matched (target 6)
- **Missing types:** `ParseBrowserError`, `Err`, `Target`, `Error`
- **Tests:** 0/4 matched
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tmp/webbrowser/src/lib.rs` vs expected `lib.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tmp/webbrowser/src/lib.rs` vs expected `lib.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tmp/webbrowser/src/lib.rs` vs expected `lib.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tmp/webbrowser/src/lib.rs` vs expected `lib.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tmp/webbrowser/src/lib.rs` vs expected `lib.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:tmp/webbrowser/src/lib.rs` vs expected `lib.rs`
- **Proposed provenance header:** `// port-lint: source lib.rs` (current: `// port-lint: source tmp/webbrowser/src/lib.rs`)
- **Proposed provenance header:** `// port-lint: source lib.rs` (current: `// port-lint: source tmp/webbrowser/src/lib.rs`)
- **Proposed provenance header:** `// port-lint: source lib.rs` (current: `// port-lint: source tmp/webbrowser/src/lib.rs`)
- **Proposed provenance header:** `// port-lint: source lib.rs` (current: `// port-lint: source tmp/webbrowser/src/lib.rs`)
- **Proposed provenance header:** `// port-lint: source lib.rs` (current: `// port-lint: source tmp/webbrowser/src/lib.rs`)
- **Proposed provenance header:** `// port-lint: tests lib.rs` (current: `// port-lint: tests tmp/webbrowser/src/lib.rs`)
- **Lint issues:** 6

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

