// port-lint: tests tests/test_wasm.rs
package io.github.kotlinmania.webbrowser

import kotlin.test.Test

private const val TEST_PLATFORM: String = "wasm32"

class TestWasm {
    @Test
    fun testWasm32() {
        checkBrowser(Browser.Default, TEST_PLATFORM)
    }
}
