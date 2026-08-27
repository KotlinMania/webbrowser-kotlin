// port-lint: source common.rs
package io.github.kotlinmania.webbrowser

/**
 * Parses [line] to find tokens (including quoted strings), and invokes [op] on each token.
 */
public fun forEachToken(
    line: String,
    op: (String) -> Unit,
) {
    var start: Int? = null
    var inQuotes = false
    var idx = 0
    for (ch in line) {
        idx += 1
        when (ch) {
            '"' -> {
                val startIdx = start
                if (startIdx != null) {
                    op(line.substring(startIdx, idx - 1))
                    start = null
                    inQuotes = false
                } else {
                    start = idx
                    inQuotes = true
                }
            }
            ' ' -> {
                if (!inQuotes) {
                    val startIdx = start
                    if (startIdx != null) {
                        op(line.substring(startIdx, idx - 1))
                        start = null
                    }
                }
            }
            else -> {
                if (start == null) {
                    start = idx - 1
                }
            }
        }
    }
    val startIdx = start
    if (startIdx != null) {
        op(line.substring(startIdx, idx))
    }
}
