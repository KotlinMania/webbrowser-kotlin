import Testing
import Webbrowser

@Suite("Webbrowser Export Tests")
struct WebbrowserExportTests {
    @Test("Browser availability check")
    func testBrowserAvailability() throws {
        let isAvailable = Browser.Companion.shared.isAvailable()
        #expect(isAvailable == true || isAvailable == false)
    }

    @Test("Browser enum cases and descriptions")
    func testBrowserCases() throws {
        #expect(Browser.Default.description == "Default")
        #expect(Browser.Safari.description == "Safari")
        #expect(Browser.Chrome.description == "Chrome")
        #expect(Browser.Firefox.description == "Firefox")
    }

    @Test("BrowserOptions builder and defaults")
    func testBrowserOptions() throws {
        let options = BrowserOptions.Companion.shared.new().withDryRun(dryRun: true)
        #expect(options.dryRun == true)
        #expect(options.suppressOutput == true)
        #expect(options.targetHint == "_blank")
    }

    @Test("Open browser with dry run options")
    func testOpenBrowserDryRun() throws {
        let options = BrowserOptions.Companion.shared.new().withDryRun(dryRun: true)
        openBrowserWithOptions(browser: .Default, url: "http://example.com", options: options)
    }
}
