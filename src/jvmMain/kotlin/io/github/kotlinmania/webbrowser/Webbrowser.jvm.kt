// port-lint: source lib.rs
// JVM implementation using java.awt.Desktop and ProcessBuilder
package io.github.kotlinmania.webbrowser

import java.awt.Desktop
import java.net.URI

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    val urlStr = target.url

    if (options.dryRun) {
        return
    }

    when (browser) {
        Browser.Default -> {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI(urlStr))
            } else {
                throw WebBrowserException("Desktop browse not supported")
            }
        }
        else -> {
            // For specific browsers on JVM, try Desktop.browse as fallback
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI(urlStr))
            } else {
                throw WebBrowserException("browser not supported on this platform: $browser")
            }
        }
    }
}
