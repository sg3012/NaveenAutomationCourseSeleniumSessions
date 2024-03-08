package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumscenarios.BrowserUtil;
import seleniumscenarios.ElementUtil;

public class RegisterTestUsingCSSLocator {
	// This class shows how we can automate
	// the steps for filling a registration form on the Registration page
	// page of any web app using CSSSelector locator in HTML.

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("Chrome");
		brUtil.enterUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		// By locator using CSS Selectors
		By firstName_css = By.cssSelector("#input-firstname");
		By telephone_css = By.cssSelector("#input-telephone");
		By continueBtn_css = By.cssSelector("#content > form > div "
				+ "> div > input.btn.btn-primary");
		
		eleUtil.doSendKeys(firstName_css, "Shubham");
		eleUtil.doSendKeys(telephone_css, "9999898998");
		eleUtil.doClick(continueBtn_css);

	}

}
