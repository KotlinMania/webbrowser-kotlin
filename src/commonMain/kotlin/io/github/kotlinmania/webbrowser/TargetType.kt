// port-lint: source tmp/webbrowser/src/lib.rs
package io.github.kotlinmania.webbrowser

internal class TargetType(val url: String) {
    fun isHttp(): Boolean =
        url.startsWith("http://") || url.startsWith("https://")

    fun getHttpUrl(): String {
        if (!isHttp()) {
            throw WebBrowserException("not an http url: $url")
        }
        return url
    }

    companion object {
        fun fromUrl(value: String): TargetType {
            val trimmed = value.trim()
            if (trimmed.startsWith("//")) {
                throw WebBrowserException("invalid url: $trimmed")
            }
            return TargetType(trimmed)
        }
    }
}
