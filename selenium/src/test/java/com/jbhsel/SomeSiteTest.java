package com.jbhsel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);
		caps.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"src\\test\\resources\\com\\jbhsel\\phantomjs.exe"
		);
		driver = new PhantomJSDriver(caps);
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

	@Test
	public void githubTest() throws IOException {
		driver.get("https://github.com/Avarice111");
		WebElement e;
		//strona glowna
		e = driver.findElement(By.partialLinkText("Repositories"));
		assertTrue(!e.getAttribute("aria-selected").contains("true"));
		//wybranie zakladki
		e.click();
		e = driver.findElement(By.partialLinkText("Repositories"));
		assertTrue(e.getAttribute("aria-selected").contains("true"));

		driver.get("https://github.com/Avarice111/roletyTAU/blob/master/RoletyTAU/src/main/java/com/rolety/domain/Rolety.java");
		e = driver.findElement(By.cssSelector("div.file > div.blob-wrapper.data.type-java > table > tbody > tr:nth-child(5)"));
		assertEquals(true, e.getText().contains("Rolety"));
		File screenshot =
				((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("rolety_class.png"));
	}
}
