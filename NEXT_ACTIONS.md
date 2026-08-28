# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 2/8 (25.0%)
- **Function parity:** 12/67 matched (target 31) — 17.9%
- **Class/type parity:** 3/13 matched (target 6) — 23.1%
- **Combined symbol parity:** 15/80 matched (target 37) — 18.8%
- **Average inline-code cosine:** 0.37 (function body across 2 matched files)
- **Average documentation cosine:** 0.69 (doc text across 2 matched files)
- **Cheat-zeroed Files:** 0
- **Critical Issues:** 2 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. lib

- **Target:** `webbrowser.Browser`
- **Similarity:** 0.29
- **Dependents:** 0
- **Priority Score:** 152907.1
- **Functions:** 11/22 matched (target 30)
- **Missing functions:** `fmt`, `description`, `from_str`, `default`, `from_file_path`, `deref`, `try_from`, `test_open_firefox`, `test_open_chrome`, `test_open_safari`, `test_open_webpositive`
- **Types:** 3/7 matched (target 6)
- **Missing types:** `ParseBrowserError`, `Err`, `Target`, `Error`
- **Tests:** 0/4 matched

### 2. common

- **Target:** `webbrowser.Common`
- **Similarity:** 0.46
- **Dependents:** 0
- **Priority Score:** 10205.4
- **Functions:** 1/2 matched (target 1)
- **Missing functions:** `run_command`
- **Types:** 0/0 matched
- **Missing types:** _none_

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

