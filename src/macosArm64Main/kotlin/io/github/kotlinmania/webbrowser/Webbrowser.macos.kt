// port-lint: source macos.rs
package io.github.kotlinmania.webbrowser

import platform.AppKit.NSWorkspace
import platform.Foundation.NSURL

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    val nsUrl = NSURL.URLWithString(target.url) ?: throw WebBrowserException("failed to create NSURL")

    when (browser) {
        Browser.Default,
        Browser.Safari,
        Browser.Firefox,
        Browser.Chrome,
        Browser.Opera,
        -> {
            if (options.dryRun) return
            NSWorkspace.sharedWorkspace.openURL(nsUrl)
        }
        Browser.InternetExplorer,
        Browser.WebPositive,
        -> {
            throw WebBrowserException("browser not supported on macOS: $browser")
        }
    }
}
