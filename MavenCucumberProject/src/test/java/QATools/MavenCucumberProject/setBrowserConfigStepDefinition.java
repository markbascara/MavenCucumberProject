package QATools.MavenCucumberProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class setBrowserConfigStepDefinition {

	protected static String browser;
	protected static WebDriver driver;

	public static WebDriver getDriver() {

		browser = "Chrome";
		//browser = "Firefox";
		
		if (browser.contains("Chrome")) {
			// Settings for Chrome Browser
			System.setProperty("webdriver.chrome.driver",
					"/Users/MarkBascara/eclipse-workspace/SeleniumTest/lib/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browser.contains("Firefox")) {
			// Settings for Firefox Browser
			System.setProperty("webdriver.gecko.driver",
					"/Users/MarkBascara/eclipse-workspace/SeleniumTest/lib/geckodriver/geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "/Program Files/Mozilla Firefox/firefox.exe");
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
}
