package com.crossover.e2e;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPageObjects {

	WebDriver driver;

	By mailSubject = By.xpath("//*[@id=\":8e\"]");
	By mailbody = By.xpath("//*[@id=\":9j\"]");

	@FindBy(how = How.XPATH, xpath = "//span[@class='bog']")
	List<WebElement> emailThreads;

	@FindBy(how = How.XPATH, xpath = "//span[@class='y2']")
	List<WebElement> emailBodyThreads;

	@FindBy(how = How.XPATH, xpath = "//span[@class='zF']")
	List<WebElement> emailnameThreads;

	@FindBy(how = How.XPATH, xpath = "//span[@class='gb_bb gbii']")
	WebElement profileLogo;

	public GmailPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailSubject(String mailsub) {
		driver.findElement(mailSubject).click();
		driver.findElement(mailSubject).sendKeys(mailsub);

		System.out.println("Email Subject Entered");
	}

	public void enterEmailBody(String Body) {

		driver.findElement(mailbody).click();
		driver.findElement(mailbody).sendKeys(Body);

		System.out.println("Email Body Entered");
	}

	public void clickEmailSubject(String emailSubject) {
		waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailThreads.size(); i++) {

			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("email Subject clicked and Verified");
				break;
			}
		}
	}

	public void clickEmailBody(String emailBody) {
		waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailBodyThreads.size(); i++) {

			if (emailBodyThreads.get(i).getText().contains(emailBody)) {
				emailBodyThreads.get(i).click();
				System.out.println("email Body clicked and Verified");
				break;
			}
		}
	}

	public void clickEmailName(String emailName) {
		waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailnameThreads.size(); i++) {

			if (emailnameThreads.get(i).getText().contains(emailName)) {
				emailnameThreads.get(i).click();
				System.out.println("email Name clicked and Verified");
				break;
			}
		}
	}

	public void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			System.out.println("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
