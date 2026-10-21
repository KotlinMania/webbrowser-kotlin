// port-lint: source unix.rs
package io.github.kotlinmania.webbrowser

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    when (browser) {
        Browser.Safari,
        Browser.InternetExplorer,
        -> {
            throw WebBrowserException("browser not supported on unix: $browser")
        }
        else -> {
            if (options.dryRun) return
            throw WebBrowserException(
                "browser opening not yet implemented for Linux native; " +
                    "use JVM target for Desktop.browse support",
            )
        }
    }
}
