// port-lint: source webbrowser/src/lib.rs
@file:OptIn(kotlin.experimental.ExperimentalObjCRefinement::class)

package io.github.kotlinmania.webbrowser

import kotlin.native.HiddenFromObjC

/**
 * Exception thrown when a browser operation fails.
 *
 * Hidden from Swift Export to avoid the auto-generated Throwable.getStackTrace()
 * Array bridge that triggers unchecked-cast warnings under -Werror.
 */
@HiddenFromObjC
class WebBrowserException(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause)
