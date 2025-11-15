package com.playwright;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@Disabled
@DisplayName("Playwright")
class PlaywrightTest {
	
	private String url = "http://localhost:8080/primefaces-test/data.jsf";
	
	@Test
	void chromium() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch();
			Page page = browser.newPage();
			page.navigate(url);
			
			assertEquals("Data", page.title());
		}
	}
	
	@Test
	void webkit() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.webkit().launch();
			Page page = browser.newPage();
			
			page.navigate(url);
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
			
			assertEquals("Data", page.title());
		}
	}
	
	@Test
	void firefox() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			Page page = browser.newPage();
			
			page.navigate(url);
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
			
			assertEquals("Data", page.title());
		}
	}
}