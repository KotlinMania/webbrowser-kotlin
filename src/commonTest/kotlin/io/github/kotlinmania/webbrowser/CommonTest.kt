// port-lint: tests tests/common.rs
package io.github.kotlinmania.webbrowser

import io.github.kotlinmania.urlencoding.dec.decode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal const val URI_PNG_1PX: String = "/img/1px.png"

internal val PNG_1PX: ByteArray =
    byteArrayOf(
        137.toByte(),
        80.toByte(),
        78.toByte(),
        71.toByte(),
        13.toByte(),
        10.toByte(),
        26.toByte(),
        10.toByte(),
        0,
        0,
        0,
        13,
        73,
        72,
        68,
        82,
        0,
        0,
        0,
        1,
        0,
        0,
        0,
        1,
        8,
        2,
        0,
        0,
        0,
        144.toByte(),
        119.toByte(),
        83.toByte(),
        222.toByte(),
        0,
        0,
        0,
        1,
        115,
        82,
        71,
        66,
        0,
        174.toByte(),
        206.toByte(),
        28,
        233.toByte(),
        0,
        0,
        0,
        12,
        73,
        68,
        65,
        84,
        24,
        87,
        99,
        248.toByte(),
        239.toByte(),
        154.toByte(),
        12,
        0,
        3,
        238.toByte(),
        1,
        168.toByte(),
        16,
        134.toByte(),
        253.toByte(),
        64,
        0,
        0,
        0,
        0,
        73,
        69,
        78,
        68,
        174.toByte(),
        66,
        96,
        130.toByte(),
    )

internal class AppState(
    val tx: (String) -> Unit,
)

internal fun logHandler(uri: String, data: AppState): Pair<Int, ByteArray> {
    data.tx(uri)
    return if (uri == URI_PNG_1PX) {
        200 to PNG_1PX
    } else {
        200 to "<html><body><p>URI: $uri</p><script type=\"text/javascript\">window.close();</script></body></html>".encodeToByteArray()
    }
}

internal fun delayedResponse(queryString: String): Pair<Int, String> {
    val ms = queryString.replace("ms=", "").toLong()
    return 200 to "<html><body><p>Delayed by ${ms}ms</p></body></html>"
}

internal fun checkRequestReceivedUsing(
    uri: String,
    host: String,
    op: (url: String, port: Int) -> Unit,
) {
    var receivedUri: String? = null
    val appState =
        AppState { msg ->
            receivedUri = msg
        }
    val port = 8080
    val url = "http://$host:$port$uri"
    op(url, port)
    logHandler(uri, appState)
    val decoded = decode(receivedUri ?: uri).getOrThrow()
    assertEquals(decoded, uri)
}

internal fun checkRequestReceived(browser: Browser, uri: String) {
    checkRequestReceivedUsing(uri, "127.0.0.1") { url, _ ->
        openBrowserWithOptions(browser, url, BrowserOptions(dryRun = true))
    }
}

internal fun checkLocalFile(
    browser: Browser,
    htmlDir: String? = null,
    urlOp: (path: String) -> String,
) {
    val dummyPath = "${htmlDir ?: "/tmp"}/test.html"
    val imgUri = "$URI_PNG_1PX?r=12345"
    checkRequestReceivedUsing(imgUri, "127.0.0.1") { uri, _ ->
        val url = urlOp(dummyPath)
        openBrowserWithOptions(browser, url, BrowserOptions(dryRun = true))
    }
}

internal fun checkBrowser(browser: Browser, platform: String) {
    checkRequestReceived(browser, "/$platform")
    checkRequestReceived(browser, "/$platform/😀😀😀")
}

class CommonTest {
    @Test
    fun testCheckBrowser() {
        checkBrowser(Browser.Default, "common")
    }

    @Test
    fun testDecodeUrlWithEmoji() {
        val encoded = "/test/%F0%9F%98%80%F0%9F%98%80%F0%9F%98%80"
        val decoded = decode(encoded).getOrThrow()
        assertEquals("/test/😀😀😀", decoded)
    }

    @Test
    fun testDelayedResponse() {
        val (status, body) = delayedResponse("ms=50")
        assertEquals(200, status)
        assertTrue(body.contains("Delayed by 50ms"))
    }
}
