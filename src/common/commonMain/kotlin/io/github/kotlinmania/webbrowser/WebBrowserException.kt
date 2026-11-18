package io.github.kotlinmania.webbrowser

/**
 * Exception thrown when a browser operation fails.
 */
internal class WebBrowserException(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause)
