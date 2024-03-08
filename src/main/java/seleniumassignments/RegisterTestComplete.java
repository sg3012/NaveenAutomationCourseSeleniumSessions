package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumscenarios.BrowserUtil;
import seleniumscenarios.ElementUtil;

public class RegisterTestComplete {

	// This class shows how to automate the steps
	// of filling a registration form completely
	// and check whether the account is created for the
	// user or not.
	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.
		enterUrl("https://naveenautomationlabs.com"
				+ "/opencart/index.php?route=account/register");
		
		// By locators for Registration form
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");     
		By email =  By.id("input-email");  
		By phone = By.id("input-telephone"); 
		By password =  By.id("input-password"); 
		By confirmPassword = By.id("input-confirm");
		By continueBtn = By.xpath("//input[@value='Continue']");
		By privacyPolicyCheckBox = By.name("agree");
		By accountCreatedText = By.tagName("h1");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Shubham");
		eleUtil.doSendKeys(lastName, "Test Automation");
		eleUtil.doSendKeys(email, "testsg+2@gmail.com");
		eleUtil.doSendKeys(phone, "9998889998");
		eleUtil.doSendKeys(password, "Test@12345");
		eleUtil.doSendKeys(confirmPassword, "Test@12345");
		eleUtil.doClick(privacyPolicyCheckBox);
		eleUtil.doClick(continueBtn);
		
		String actualAccountCreationMsg = eleUtil.getElement(accountCreatedText).getText();
		
		if(actualAccountCreationMsg.equals("Your Account Has Been Created!")) {
			System.out.println("TEST PASS");
		}
		else {
			System.out.println("TEST FAIL!");
		}
		
		Thread.sleep(1000);
		
		brUtil.quitBrowser();
		
	}

}
