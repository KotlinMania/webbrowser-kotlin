// port-lint: tests webbrowser/src/lib.rs
package io.github.kotlinmania.webbrowser

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class BrowserTest {
    @Test
    fun browserFromString() {
        assertEquals(Browser.Default, Browser.fromString("default"))
        assertEquals(Browser.Firefox, Browser.fromString("firefox"))
        assertEquals(Browser.Chrome, Browser.fromString("chrome"))
        assertEquals(Browser.Safari, Browser.fromString("safari"))
        assertEquals(Browser.Opera, Browser.fromString("opera"))
        assertEquals(Browser.InternetExplorer, Browser.fromString("internet explorer"))
        assertEquals(Browser.InternetExplorer, Browser.fromString("ie"))
        assertEquals(Browser.WebPositive, Browser.fromString("webpositive"))
    }

    @Test
    fun browserFromStringCaseInsensitive() {
        assertEquals(Browser.Default, Browser.fromString("Default"))
        assertEquals(Browser.Firefox, Browser.fromString("FIREFOX"))
        assertEquals(Browser.Chrome, Browser.fromString("Chrome"))
    }

    @Test
    fun browserFromStringInvalid() {
        assertFailsWith<ParseBrowserException> {
            Browser.fromString("nonexistent")
        }
        assertFailsWith<ParseBrowserException> {
            Browser.fromString("")
        }
    }

    @Test
    fun browserOptionsDefaults() {
        val opts = BrowserOptions()
        assertEquals(true, opts.suppressOutput)
        assertEquals("_blank", opts.targetHint)
        assertEquals(false, opts.dryRun)
    }

    @Test
    fun browserOptionsCustom() {
        val opts =
            BrowserOptions(
                suppressOutput = false,
                targetHint = "_self",
                dryRun = true,
            )
        assertEquals(false, opts.suppressOutput)
        assertEquals("_self", opts.targetHint)
        assertEquals(true, opts.dryRun)
    }

    @Test
    fun targetTypeHttp() {
        val target = TargetType.fromUrl("http://github.com")
        assertTrue(target.isHttp())
        assertEquals("http://github.com", target.getHttpUrl())
    }

    @Test
    fun targetTypeHttps() {
        val target = TargetType.fromUrl("https://github.com")
        assertTrue(target.isHttp())
    }

    @Test
    fun targetTypeNonHttpThrows() {
        val target = TargetType.fromUrl("file:///etc/passwd")
        assertFailsWith<WebBrowserException> {
            target.getHttpUrl()
        }
    }

    @Test
    fun openBrowserWithOptionsDryRun() {
        openBrowserWithOptions(Browser.Default, "http://example.com", BrowserOptions(dryRun = true))
    }

    @Test
    fun openDryRun() {
        openBrowserWithOptions(Browser.Default, "http://github.com", BrowserOptions(dryRun = true))
    }

    @Test
    fun openBrowserDryRun() {
        openBrowserWithOptions(Browser.Safari, "http://github.com", BrowserOptions(dryRun = true))
    }
}
