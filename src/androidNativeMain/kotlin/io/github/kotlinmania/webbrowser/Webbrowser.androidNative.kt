// port-lint: source android.rs
// Fallback implementation for Android Native NDK targets.
// Full JNI-based browser opening via ndk_context-equivalent is not yet wired.
package io.github.kotlinmania.webbrowser

@Throws(WebBrowserException::class)
internal actual fun openBrowserInternal(
    browser: Browser,
    target: TargetType,
    options: BrowserOptions,
) {
    if (options.dryRun) return
    throw WebBrowserException(
        "browser opening not yet implemented for Android Native; " +
            "use the Android KMP library target for Intent-based support",
    )
}
