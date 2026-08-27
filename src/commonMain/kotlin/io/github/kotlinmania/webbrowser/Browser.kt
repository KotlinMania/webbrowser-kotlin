// port-lint: source lib.rs
@file:OptIn(kotlin.experimental.ExperimentalObjCRefinement::class)

package io.github.kotlinmania.webbrowser

import kotlin.native.HiddenFromObjC

/**
 * Browser types available on the platform.
 */
enum class Browser {
    /** Operating system's default browser */
    Default,

    /** Mozilla Firefox */
    Firefox,

    /** Microsoft's Internet Explorer */
    InternetExplorer,

    /** Google Chrome */
    Chrome,

    /** Opera */
    Opera,

    /** macOS Safari */
    Safari,

    /** Haiku's WebPositive */
    WebPositive,
    ;

    /**
     * Returns true if this specific browser is detected on the system.
     */
    fun exists(): Boolean =
        try {
            openBrowserWithOptions(this, "https://rootnet.in", BrowserOptions(dryRun = true))
            true
        } catch (_: WebBrowserException) {
            false
        }

    override fun toString(): String =
        when (this) {
            Default -> "Default"
            Firefox -> "Firefox"
            InternetExplorer -> "Internet Explorer"
            Chrome -> "Chrome"
            Opera -> "Opera"
            Safari -> "Safari"
            WebPositive -> "WebPositive"
        }

    companion object {
        /**
         * Returns true if the default browser is available on the system.
         */
        fun isAvailable(): Boolean = Default.exists()

        /**
         * Parse a [Browser] from its string representation.
         */
        fun fromString(value: String): Browser =
            when (value.trim().lowercase()) {
                "default" -> Default
                "firefox" -> Firefox
                "ie", "internet explorer", "internetexplorer" -> InternetExplorer
                "chrome" -> Chrome
                "opera" -> Opera
                "safari" -> Safari
                "webpositive" -> WebPositive
                else -> throw ParseBrowserException("Invalid browser given: '$value'")
            }
    }
}

/**
 * Error type for parsing a string into a [Browser].
 */
@HiddenFromObjC
class ParseBrowserException(
    message: String,
) : Exception(message)
