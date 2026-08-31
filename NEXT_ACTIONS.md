# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 8/8 (100.0%)
- **Function parity:** 18/65 matched (target 43) — 27.7%
- **Class/type parity:** 3/13 matched (target 6) — 23.1%
- **Combined symbol parity:** 21/78 matched (target 49) — 26.9%
- **Average inline-code cosine:** 0.25 (function body across 4 matched files)
- **Average documentation cosine:** 0.34 (doc text across 4 matched files)
- **Cheat-zeroed Files:** 4
- **Critical Issues:** 8 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. unix

- **Target:** `webbrowser.Webbrowser.linux [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 242510.0
- **Functions:** 1/24 matched (target 1)
- **Missing functions:** `open_browser_default`, `try_with_browser_env`, `is_wsl`, `is_flatpak`, `guess_desktop_env`, `try_wsl`, `try_flatpak`, `try_haiku`, `try_xdg`, `open_using_xdg_config`, `get_xdg_dirs`, `is_text_browser`, `for_matching_path`, `get_temp_path`, `test_xdg_open_local_file`, `get_wsl_win_config`, `get_wsl_windows_browser_ps`, `get_wsl_windows_browser_cmd`, `parse_wsl_cmdline`, `wsl_get_filepath_from_url`, `wsl_path_win2lin`, `wsl_path_lin2win`, `get_wsl_distro_name`
- **Types:** 0/1 matched (target 0)
- **Missing types:** `WindowsConfig`
- **Tests:** 0/2 matched

### 2. lib

- **Target:** `webbrowser.Browser`
- **Similarity:** 0.29
- **Dependents:** 0
- **Priority Score:** 152907.1
- **Functions:** 11/22 matched (target 31)
- **Missing functions:** `fmt`, `description`, `from_str`, `default`, `from_file_path`, `deref`, `try_from`, `test_open_firefox`, `test_open_chrome`, `test_open_safari`, `test_open_webpositive`
- **Types:** 3/7 matched (target 6)
- **Missing types:** `ParseBrowserError`, `Err`, `Target`, `Error`
- **Tests:** 0/4 matched

### 3. macos

- **Target:** `webbrowser.Webbrowser.macos`
- **Similarity:** 0.06
- **Dependents:** 0
- **Priority Score:** 91009.4
- **Functions:** 1/6 matched (target 1)
- **Missing functions:** `create_cf_url`, `from`, `fmt`, `open_non_existing_browser`, `test_existence`
- **Types:** 0/4 matched (target 0)
- **Missing types:** `OSStatus`, `LSError`, `LSRolesMask`, `LSLaunchURLSpec`
- **Tests:** 0/2 matched

### 4. ios

- **Target:** `webbrowser.Webbrowser.ios`
- **Similarity:** 0.20
- **Dependents:** 0
- **Priority Score:** 30408.0
- **Functions:** 1/3 matched
- **Missing functions:** `sharedApplication`, `open_url`
- **Types:** 0/1 matched (target 0)
- **Missing types:** `FakeBlock`
- **Lint issues:** 1

### 5. windows

- **Target:** `webbrowser.Webbrowser.mingw [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 20310.0
- **Functions:** 1/3 matched (target 1)
- **Missing functions:** `ensure_cmd_quotes`, `get_browser_cmd`
- **Types:** 0/0 matched
- **Missing types:** _none_

### 6. android

- **Target:** `webbrowser.Webbrowser.android [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 20310.0
- **Functions:** 1/3 matched (target 2)
- **Missing functions:** `open_browser_default`, `try_for_termux`
- **Types:** 0/0 matched
- **Missing types:** _none_

### 7. wasm

- **Target:** `webbrowser.Webbrowser.js [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 10210.0
- **Functions:** 1/2 matched (target 3)
- **Missing functions:** `wasm_console_log`
- **Types:** 0/0 matched
- **Missing types:** _none_

### 8. common

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

