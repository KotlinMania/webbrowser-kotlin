// port-lint: tests tests/test_unix.rs
package io.github.kotlinmania.webbrowser

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

private const val TEST_PLATFORM: String = "unix"

class TestUnix {
    @Test
    fun testOpenDefault() {
        checkBrowser(Browser.Default, TEST_PLATFORM)
    }

    @Test
    fun testExistenceDefault() {
        assertTrue(Browser.isAvailable(), "should have found a browser")
    }

    @Test
    fun testNonExistenceSafari() {
        assertFalse(Browser.Safari.exists(), "should not have found Safari")
    }

    @Test
    fun testLocalFileAbsPath() {
        checkLocalFile(Browser.Default) { path ->
            path
        }
    }

    @Test
    fun testLocalFileRelPath() {
        checkLocalFile(Browser.Default) { path ->
            path.removePrefix("/")
        }
    }

    @Test
    fun testLocalFileUri() {
        checkLocalFile(Browser.Default) { path ->
            "file://$path"
        }
    }

    @Test
    fun testHardenedMode() {
        assertFailsWith<WebBrowserException> {
            TargetType.fromUrl("file:///etc/passwd").getHttpUrl()
        }
    }
}
