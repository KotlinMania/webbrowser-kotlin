// port-lint: source unix.rs
// Fallback implementation for Linux native targets (linuxX64, linuxArm64).
// Full xdg-open/BROWSER env/DE detection support requires cinterop with
// POSIX process execution APIs and is not yet wired.
package io.github.kotlinmania.webbrowser

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    if (options.dryRun) return
    throw WebBrowserException(
        "browser opening not yet implemented for Linux native; " +
            "use JVM target for Desktop.browse support",
    )
}
