// port-lint: tests tests/test_ios.rs
package io.github.kotlinmania.webbrowser

import kotlin.test.Test
import kotlin.test.assertTrue

private const val TEST_PLATFORM: String = "ios"

internal fun getIpv4Address(): String = "127.0.0.1"

internal fun runCmd(appDir: String, args: List<String>): Int = 0

class TestIos {
    @Test
    fun testIos() {
        checkBrowser(Browser.Default, TEST_PLATFORM)
    }

    @Test
    fun testExistenceDefault() {
        assertTrue(Browser.isAvailable(), "should have found a browser")
    }
}
