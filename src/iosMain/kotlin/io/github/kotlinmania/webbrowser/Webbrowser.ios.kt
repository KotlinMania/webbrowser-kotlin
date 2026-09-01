// port-lint: source ios.rs
package io.github.kotlinmania.webbrowser

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    val url = target.getHttpUrl()

    if (options.dryRun) {
        return
    }

    val nsUrl = NSURL.URLWithString(url) ?: throw WebBrowserException("failed to create NSURL")
    val app = UIApplication.sharedApplication
    app.openURL(nsUrl)
}
