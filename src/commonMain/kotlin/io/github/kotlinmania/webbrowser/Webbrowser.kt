// port-lint: source tmp/webbrowser/src/lib.rs
package io.github.kotlinmania.webbrowser

fun open(url: String) {
    openBrowser(Browser.Default, url)
}

fun openBrowser(browser: Browser, url: String) {
    openBrowserWithOptions(browser, url, BrowserOptions())
}

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
