package io.github.kotlinmania.webbrowser

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    if (options.dryRun) return
    throw WebBrowserException("browser opening not supported on watchOS")
}
