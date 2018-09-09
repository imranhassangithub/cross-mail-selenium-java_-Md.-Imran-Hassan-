package com.crossover.e2e;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPageObjects {

	@FindBy(how = How.XPATH, xpath = "//span[@class='bog']")
	List<WebElement> emailThreads;

	@FindBy(how = How.XPATH, xpath = "//span[@class='gb_bb gbii']")
	WebElement profileLogo;

	@FindBy(how = How.XPATH, xpath = "//span[@class='yP']")
	List<WebElement> emailname;

	private WebDriver driver;

	public GmailPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickEmailName(String emailName) {
		waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailname.size(); i++) {

			if (emailname.get(i).getText().contains(emailName)) {
				emailname.get(i).click();
				System.out.println("email name clicked");
				break;
			}
		}
	}

	public void clickEmailSubject(String emailSubject) {
		waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailThreads.size(); i++) {

			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("email Subject clicked");
				break;
			}
		}
	}

	public void clickEmailBody(String emailBody) {
		waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailThreads.size(); i++) {

			if (emailThreads.get(i).getText().contains(emailBody)) {
				emailThreads.get(i).click();
				System.out.println("email Body clicked");
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
