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
    val osName = System.getProperty("os.name")?.lowercase() ?: ""
    val isMac = osName.contains("mac")
    val isWindows = osName.contains("win")

    when (browser) {
        Browser.Default -> {
            if (options.dryRun) return
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI(urlStr))
            } else {
                throw WebBrowserException("Desktop browse not supported")
            }
        }
        Browser.Safari -> {
            if (!isMac) {
                throw WebBrowserException("Safari is only supported on macOS")
            }
            if (options.dryRun) return
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI(urlStr))
            } else {
                throw WebBrowserException("Desktop browse not supported")
            }
        }
        Browser.InternetExplorer -> {
            if (!isWindows) {
                throw WebBrowserException("Internet Explorer is only supported on Windows")
            }
            if (options.dryRun) return
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI(urlStr))
            } else {
                throw WebBrowserException("Desktop browse not supported")
            }
        }
        Browser.WebPositive -> {
            if (!osName.contains("haiku")) {
                throw WebBrowserException("WebPositive is only supported on Haiku")
            }
            if (options.dryRun) return
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI(urlStr))
            } else {
                throw WebBrowserException("Desktop browse not supported")
            }
        }
        Browser.Firefox,
        Browser.Chrome,
        Browser.Opera,
        -> {
            if (options.dryRun) return
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI(urlStr))
            } else {
                throw WebBrowserException("browser not supported on this platform: $browser")
            }
        }
    }
}
