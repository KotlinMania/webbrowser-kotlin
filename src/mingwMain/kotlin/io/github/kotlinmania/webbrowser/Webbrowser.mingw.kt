// port-lint: source windows.rs
// Fallback implementation for MinGW native targets (mingwX64).
// Full AssocQueryStringW/process execution support requires cinterop
// with Win32 APIs and is not yet wired.
package io.github.kotlinmania.webbrowser

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    if (options.dryRun) return
    throw WebBrowserException(
        "browser opening not yet implemented for MinGW native; " +
            "use JVM target for Desktop.browse support",
    )
}
