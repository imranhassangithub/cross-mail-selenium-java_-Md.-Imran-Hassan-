package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class GMailTest extends TestCase {
	private WebDriver driver;
	private Properties properties = new Properties();

	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//imran//Desktop//CrossOver Tests//Selenium Projects//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		properties.load(new FileReader(new File("test.properties")));
	}

	@Test
	public void testSendEmail() throws Exception {
		driver.get("https://mail.google.com/");
		WebElement userElement = driver.findElement(By.id("identifierId"));
		userElement.sendKeys(properties.getProperty("username"));

		driver.findElement(By.id("identifierNext")).click();

		Thread.sleep(1000);

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(properties.getProperty("password"));
		driver.findElement(By.id("passwordNext")).click();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")));

		WebElement composeElement = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
		composeElement.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.name("to")));

		// Type on To
		driver.findElement(By.name("to")).clear();
		driver.findElement(By.name("to"))
				.sendKeys(String.format("%s@gmail.com", properties.getProperty("username")) + Keys.ENTER);

		GmailPageObjects gmailpageobject = new GmailPageObjects(driver);

		gmailpageobject.enterEmailSubject("Test Gmail");
		gmailpageobject.enterEmailBody("Gmail Test");

		driver.findElement(By.xpath("//*[@role='button' and text()='Send']")).click();

	}

}
