# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 2/15 (13.3%)
- **Function parity:** 1/84 matched (target 1) — 1.2%
- **Class/type parity:** 0/7 matched — 0.0%
- **Combined symbol parity:** 1/91 matched (target 1) — 1.1%
- **Average inline-code cosine:** 0.46 (function body across 1 matched files)
- **Average documentation cosine:** 0.82 (doc text across 1 matched files)
- **Cheat-zeroed Files:** 0
- **Critical Issues:** 2 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. webbrowser.common

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

## Reexport / Wiring Modules

These files match `reexport_modules` patterns in `.ast_distance_config.json`. They are filtered out of
normal priority and missing-file ladders because they are wiring
modules, not direct logic ports. Consult them for call-site routing;
do not treat them as the next implementation target by default.

### Matched

| Source | Target | Path |
|--------|--------|------|
| `webbrowser.lib` | `webbrowser.Browser` | `webbrowser/src/lib` |

