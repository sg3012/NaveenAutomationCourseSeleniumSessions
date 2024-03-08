package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumscenarios.BrowserUtil;
import seleniumscenarios.ElementUtil;

public class RegisterTestUsingIDLocator {
	// This class shows how we can automate
	// the steps for filling a registration form on the Registration page
	// page of any web app using ID locator in HTML.

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.enterUrl("https://naveenautomationlabs.com/opencart"
				+ "/index.php?route=account/register");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		// By locators using IDs
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");     
		By email =  By.id("input-email");  
		By phone = By.id("input-telephone"); 
		By password =  By.id("input-password"); 
		By confirmPassword = By.id("input-confirm");
		
		eleUtil.doSendKeys(firstName, "Shubham");
		eleUtil.doSendKeys(lastName, "Gupta");
		eleUtil.doSendKeys(email, "shubham@gmail.com");
		eleUtil.doSendKeys(phone, "9876543210");
		eleUtil.doSendKeys(password, "Test@123");
		eleUtil.doSendKeys(confirmPassword, "Test@123");


	}

}
