// port-lint: source android.rs
package io.github.kotlinmania.webbrowser

import android.content.Intent
import android.net.Uri

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    val url = target.getHttpUrl()

    when (browser) {
        Browser.Default -> {
            if (options.dryRun) {
                return
            }
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            @Suppress("DEPRECATION")
            android.app.Activity().startActivity(intent)
        }
        else -> throw WebBrowserException("only default browser supported on Android")
    }
}
