// port-lint: tests tests/test_android.rs
package io.github.kotlinmania.webbrowser

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

private const val TEST_PLATFORM: String = "android"

class TestAndroid {
    @Test
    fun testAndroid() {
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
}
