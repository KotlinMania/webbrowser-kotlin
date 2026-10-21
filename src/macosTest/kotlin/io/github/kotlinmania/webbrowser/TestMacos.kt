// port-lint: tests tests/test_macos.rs
package io.github.kotlinmania.webbrowser

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

private const val TEST_PLATFORM: String = "macos"

class TestMacos {
    @Test
    fun testOpenDefault() {
        checkBrowser(Browser.Default, TEST_PLATFORM)
    }

    @Test
    fun testOpenSafari() {
        checkBrowser(Browser.Safari, TEST_PLATFORM)
    }

    @Test
    fun testOpenChrome() {
        checkBrowser(Browser.Chrome, TEST_PLATFORM)
    }

    @Test
    fun testExistenceDefault() {
        assertTrue(Browser.isAvailable(), "should have found a browser")
    }

    @Test
    fun testExistenceSafari() {
        assertTrue(Browser.Safari.exists(), "should have found Safari")
    }

    @Test
    fun testNonExistenceWebpositive() {
        assertFalse(Browser.WebPositive.exists(), "should not have found WebPositive")
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
