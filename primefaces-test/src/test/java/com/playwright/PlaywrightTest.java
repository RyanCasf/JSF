package com.playwright;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@DisplayName("Playwright")
class PlaywrightTest {
	
	@Test
	void chromium() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch();
			Page page = browser.newPage();
			page.navigate("http://localhost:8080/primefaces-test/data.jsf");
			
			assertEquals("Data", page.title());
		}
	}
	
	@Test
	void webkit() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.webkit().launch();
			Page page = browser.newPage();
			
			page.navigate("http://localhost:8080/primefaces-test/data.jsf");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
			
			assertEquals("Data", page.title());
		}
	}
	
	@Test
	void firefox() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			Page page = browser.newPage();
			
			page.navigate("http://localhost:8080/primefaces-test/data.jsf");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
			
			assertEquals("Data", page.title());
		}
	}
}