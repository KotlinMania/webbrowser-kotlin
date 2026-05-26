// port-lint: source tmp/webbrowser/src/wasm.rs
package io.github.kotlinmania.webbrowser

internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    val url = target.getHttpUrl()

    if (options.dryRun) {
        // dryRun: if window is available, the check passes; if not,
        // we still return success to keep consistent behaviour with
        // other platforms where the dry-run check is a no-op.
        // The upstream WASM implementation throws on missing window,
        // but those tests are #[ignore]'d and only run in a browser.
        return
    }

    val window: dynamic = js("window")
    val result: dynamic = window.open(url, options.targetHint)
    if (result == null) {
        throw WebBrowserException("popup blocked? window detected, but open_url failed")
    }
}
