// port-lint: source windows.rs
package io.github.kotlinmania.webbrowser

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    when (browser) {
        Browser.Default,
        Browser.InternetExplorer,
        -> {
            if (options.dryRun) return
            throw WebBrowserException(
                "browser opening not yet implemented for MinGW native; " +
                    "use JVM target for Desktop.browse support",
            )
        }
        else -> {
            throw WebBrowserException("only default and Internet Explorer are supported on Windows: $browser")
        }
    }
}
