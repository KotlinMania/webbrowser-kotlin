package io.github.kotlinmania.webbrowser

/**
 * Opens the specified URL or file on the system's default browser.
 *
 * Guaranteed to be non-blocking for GUI-based browsers and blocking for text-based browsers.
 * Output is suppressed by default for GUI-based browsers.
 *
 * @param url The URL or local file path to open.
 * @throws WebBrowserException if the browser cannot be invoked or url is invalid.
 */
fun open(url: String) {
    openBrowser(Browser.Default, url)
}

/**
 * Opens the specified URL on the specific browser (if available) requested.
 *
 * Return semantics are the same as for [open].
 *
 * @param browser The specific browser to use.
 * @param url The URL or local file path to open.
 * @throws WebBrowserException if the browser cannot be invoked or url is invalid.
 */
fun openBrowser(browser: Browser, url: String) {
    openBrowserWithOptions(browser, url, BrowserOptions())
}

/**
 * Opens the specified URL on the specific browser (if available) requested, while overriding the default options.
 *
 * Return semantics are the same as for [open].
 *
 * @param browser The specific browser to use.
 * @param url The URL or local file path to open.
 * @param options Custom [BrowserOptions] controlling dry-run mode, suppression, and window hints.
 * @throws WebBrowserException if the browser cannot be invoked or url is invalid.
 */
fun openBrowserWithOptions(browser: Browser, url: String, options: BrowserOptions) {
    val target = TargetType.fromUrl(url)
    openBrowserInternal(browser, target, options)
}

@Throws(WebBrowserException::class)
internal expect fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
)
