// port-lint: source tmp/webbrowser/src/android.rs
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

    if (options.dryRun) {
        return
    }

    when (browser) {
        Browser.Default -> {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            // In a library context, startActivity requires the caller to provide
            // a Context. Using the application context via a static reference
            // would need initialization; for now we rely on the caller having
            // the NEW_TASK flag set and a task stack available.
            @Suppress("DEPRECATION")
            android.app.Activity().startActivity(intent)
        }
        else -> throw WebBrowserException("only default browser supported on Android")
    }
}
