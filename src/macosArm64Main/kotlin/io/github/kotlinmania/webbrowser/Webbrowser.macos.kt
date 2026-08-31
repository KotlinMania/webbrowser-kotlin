// port-lint: source webbrowser/src/macos.rs
package io.github.kotlinmania.webbrowser

import platform.AppKit.NSWorkspace
import platform.Foundation.NSURL

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    if (options.dryRun) {
        return
    }

    val urlStr = target.url
    val nsUrl = NSURL.URLWithString(urlStr) ?: throw WebBrowserException("failed to create NSURL")

    when (browser) {
        Browser.Default -> {
            NSWorkspace.sharedWorkspace.openURL(nsUrl)
        }
        Browser.Safari -> {
            NSWorkspace.sharedWorkspace.openURL(nsUrl)
        }
        Browser.Firefox -> {
            NSWorkspace.sharedWorkspace.openURL(nsUrl)
        }
        Browser.Chrome -> {
            NSWorkspace.sharedWorkspace.openURL(nsUrl)
        }
        Browser.Opera -> {
            NSWorkspace.sharedWorkspace.openURL(nsUrl)
        }
        else -> throw WebBrowserException("browser not supported on macOS: $browser")
    }
}
