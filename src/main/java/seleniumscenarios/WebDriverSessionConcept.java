package seleniumscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSessionConcept {

	// This class explains the concept of session creation whenever
	// we launch a browser using webdriver in Selenium

	public static void main(String[] args) {

		// Whenever we launch a Browser using Selenium
		// it will create and maintain a session ID
		// for that browser instance until the browser is closed
		// using quit() method. The session ID will be the same
		// for all user actions we perform on the same browser
		// until the browser is closed.

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		String title = driver.getTitle();
		
		System.out.println("Actual Title: " + title); // Google
		
		System.out.println(driver.getCurrentUrl());
		
		if (title.equals("Google")) {
			
			System.out.println("Correct title"); // Correct title
			
		} else {
			
			System.out.println("Incorrect title");
			
		}
		
		driver.quit();
		
		System.out.println(driver.getTitle()); // NoSuchSessionException - session is null
		// because after quitting the browser instance the driver
		// was holding the session ID for, the sessionID for the WebDriver
		// instance becomes null and there is no browser opened at all.
	}

}
