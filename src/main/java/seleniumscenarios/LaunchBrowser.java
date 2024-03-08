package seleniumscenarios;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
	
	// This class shows how do we open a Browser and automate different 
	// steps in a test case and validate if the 
	// actual result is matching with the expected result or not.

	public static void main(String[] args) {
		
		// Launch browser-chrome
		 ChromeDriver driver = new ChromeDriver(); // if we write only this line
		// a blank chrome browser will be launched with no URL
		// entered in the address bar.
		
		// Launch browser - Firefox
//		FirefoxDriver driver = new FirefoxDriver();
		
		// Launch browser - Edge
//		EdgeDriver driver = new EdgeDriver();
		
		// Enter URL in the address bar for launching desired application 
		// (Say, Google.com)
		driver.get("https://www.google.com");
		
		// (IMPORTANT - INTERVIEW QUESTION) What will happen if I 
		// don't give the protocol like http or https in the 
		// URL string (like "www.google.com" ) 
		// passed in get method ? Will it 
		// launch the URL or not?
		// Ans : It will just open a blank browser and doesn't open the URL
		// and gives InValidArgumentException.
		
		// (INTERVIEW QUESTION) What will happen if I give the protocol
		// like http or https but miss www in the URL string passed
		// (like "https://google.com") in get method?
		// Ans : It will open the browser and launch the URL correctly.
		// It will take care of www internally.
		
		
		// fetch the title of the launched page and display:
		String title = driver.getTitle();
		System.out.println("Actual Title: "+title);
		
		System.out.println(driver.getCurrentUrl());
		
		// Validate the title is correct or not: act vs expected result | Checkpoint | Validation Point
		if(title.equals("Google")) {
			System.out.println("Correct title");
		}
		else
		{
			System.out.println("Incorrect title");
		}
		
		// close the browser
		driver.quit();
		
		
		// The above all code is also called AUTOMATION TESTING
		// which is a combination of automation steps + checkpoint (act vs expected result).
		
		// NOTE: Writing Validations of actual vs expected results is very important when
		// we write the automation scripts and DON'T forget to write those.
		
		// (INTERVIEW) What happens when remote automation is not allowed in 
		// Safari browser? 
		// When remote automation is disabled for safari browser then we will get
		// SessionNotCreatedException. We have to go to develop option in safari >
		// then check "Allow Remote Automation" option to be able to run
		// automated scripts in Safari.
	
	}

}
