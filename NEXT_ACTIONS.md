# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 2/15 (13.3%)
- **Function parity:** 12/106 matched (target 31) — 11.3%
- **Class/type parity:** 3/14 matched (target 6) — 21.4%
- **Combined symbol parity:** 15/120 matched (target 37) — 12.5%
- **Average inline-code cosine:** 0.46 (function body across 1 matched files)
- **Average documentation cosine:** 0.82 (doc text across 1 matched files)
- **Cheat-zeroed Files:** 1
- **Critical Issues:** 2 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. webbrowser.lib

- **Target:** `webbrowser.Browser [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 152910.0
- **Functions:** 11/22 matched (target 30)
- **Missing functions:** `fmt`, `description`, `from_str`, `default`, `from_file_path`, `deref`, `try_from`, `test_open_firefox`, `test_open_chrome`, `test_open_safari`, `test_open_webpositive`
- **Types:** 3/7 matched (target 6)
- **Missing types:** `ParseBrowserError`, `Err`, `Target`, `Error`
- **Tests:** 0/4 matched

### 2. webbrowser.common

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

