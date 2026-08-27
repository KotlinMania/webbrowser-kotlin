// port-lint: source webbrowser/src/lib.rs
package io.github.kotlinmania.webbrowser

/**
 * BrowserOptions to override certain default behaviour. Any option named as a `hint` is
 * not guaranteed to be honoured.
 *
 * By default, stdout/stderr of the browser process is suppressed, and the target hint is `_blank`.
 * Use the `with*` builder methods to customise.
 */
data class BrowserOptions(
    /** Determines whether stdout/stderr of the browser command is suppressed */
    val suppressOutput: Boolean = true,
    /** Hint to the browser to open the url in the corresponding target (e.g. `_blank`, `_self`) */
    val targetHint: String = "_blank",
    /** If true, do not execute the browser command, only check if it would succeed */
    val dryRun: Boolean = false,
) {
    companion object {
        /** Create a new [BrowserOptions] with defaults. */
        fun new(): BrowserOptions = BrowserOptions()
    }

    /** Set [suppressOutput] and return this (builder pattern). */
    fun withSuppressOutput(suppressOutput: Boolean): BrowserOptions =
        copy(suppressOutput = suppressOutput)

    /** Set [targetHint] and return this (builder pattern). */
    fun withTargetHint(targetHint: String): BrowserOptions =
        copy(targetHint = targetHint)

    /** Set [dryRun] and return this (builder pattern). */
    fun withDryRun(dryRun: Boolean): BrowserOptions =
        copy(dryRun = dryRun)

    override fun toString(): String =
        "BrowserOptions(suppressOutput=$suppressOutput, targetHint=$targetHint, dryRun=$dryRun)"
}
