// port-lint: source wasm.rs
// Implements wasmJs browser opening via JS interop when
// Kotlin/Wasm's JS interop APIs stabilize.
package io.github.kotlinmania.webbrowser

internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    if (options.dryRun) return
    throw WebBrowserException(
        "browser opening not yet implemented for wasmJs target; " +
            "use JS target for browser support",
    )
}
