package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

public class GmailEmailCheckTest extends TestCase {
	private WebDriver driver;
	private Properties properties = new Properties();

	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//imran//Desktop//CrossOver Tests//Selenium Projects//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		properties.load(new FileReader(new File("test.properties")));
	}

	@Test
	public void testReadEmail() throws Exception {
		driver.get("https://mail.google.com/");
		WebElement userElement = driver.findElement(By.id("identifierId"));
		userElement.sendKeys(properties.getProperty("username"));

		driver.findElement(By.id("identifierNext")).click();

		Thread.sleep(1000);

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(properties.getProperty("password"));
		driver.findElement(By.id("passwordNext")).click();

		GmailPageObjects gmailpageobject = PageFactory.initElements(driver, GmailPageObjects.class);

		Thread.sleep(1000);

		gmailpageobject.clickEmailSubject("Test Gmail");

	}

}
