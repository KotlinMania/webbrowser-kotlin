// port-lint: source wasm.rs
// WASI (WebAssembly System Interface) runs outside any browser environment,
// so there is no window.open() or browser launcher available.
package io.github.kotlinmania.webbrowser

internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    if (options.dryRun) return
    throw WebBrowserException(
        "browser opening not supported on WASI target; " +
            "use JS or JVM target for browser support",
    )
}
