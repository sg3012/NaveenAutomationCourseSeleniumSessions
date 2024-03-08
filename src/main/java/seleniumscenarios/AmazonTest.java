package seleniumscenarios;

import org.openqa.selenium.support.ui.Wait;

public class AmazonTest {

	// This class is a driver class to test the browser
	// launching logic written in BrowserUtil.java
	public static void main(String[] args) {
		
		String browserName = "chrome";
		
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser(browserName);
		brUtil.enterUrl("https://www.amazon.com");
		
		// fetch the current page title
		String actTitle = brUtil.getPageTitle();
		System.out.println(actTitle);
		
		// Validate if the actual title is equal to expected title or not
		if(actTitle.contains("Amazon")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		// fetch the current page URL
		String actURL = brUtil.getPageURL();
		System.out.println(actURL);
		
		// Validate if the actual URL is equal to expected URL or not
		if(actURL.equals("https://www.amazon.com/")) {
			System.out.println("Correct URL");
		}
		else {
			System.out.println("Incorrect URL");
		}	
		
		brUtil.quitBrowser();

	}

}
