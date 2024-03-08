package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {
	
	// This class shows how we can automate
	// the steps for login a user on the Login
	// page of any web app.

	public static void main(String[] args) {

		// Create object of BrowserUtil class to launch the browser
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.enterUrl("https://naveenautomationlabs.com/opencart"
				+ "/index.php?route=account/login");
		System.out.println(brUtil.getPageTitle());
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		// By locators of login form:
		By email_id = By.id("input-email");
		By pass_id = By.id("input-password");
		eleUtil.doSendKeys(email_id, "naveen@gmail.com");
		eleUtil.doSendKeys(pass_id, "test@123");
		
		brUtil.quitBrowser();
	}

}
