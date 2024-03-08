package seleniumscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaseStudyCloseVsQuit {
	
	// This class explains the difference between close()
	// and quit() methods of selenium using the concept of session IDs

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// CASE 1 : Quit()

//		WebDriver driver = new ChromeDriver();  // Session Id - 123 (for e.g.)
//
//		driver.get("https://www.google.com"); // Session Id - 123 (for e.g.)
//
//		String title = driver.getTitle(); // Session Id - 123 (for e.g.)
//
//		System.out.println("Actual Title: " + title); // Google
//
//		System.out.println(driver.getCurrentUrl()); // Session Id - 123 (for e.g.)
//
//		driver.quit(); // Session Id - 123 (for e.g.)
//		
//		// After calling quit method, session ID - null (because the browser is closed)
////
////		System.out.println(driver.getTitle()); // NoSuchSessionException - session IS is null
//		
//		// So, if we want to fetch the title again after quitting the browser
//		// then we have to reinitialize it and fetch the title again like
//		// this:
//		driver = new ChromeDriver(); // Session ID will be different from the one 
//		// before calling quit() method (Let's say, 456)
//		driver.get("https://www.google.com"); // Session ID - 456
//		title = driver.getTitle(); // Session ID - 456
//		System.out.println("Act Title: "+title);

//		CASE 2 : close()
		
		WebDriver driver1 = new ChromeDriver();  // Session Id - 123 (for e.g.)

		driver1.get("https://www.google.com"); // Session Id - 123 (for e.g.)

		String title1 = driver1.getTitle(); // Session Id - 123 (for e.g.)

		System.out.println("Actual Title: " + title1); // Google

		System.out.println(driver1.getCurrentUrl()); // Session Id - 123 (for e.g.)

		driver1.close(); // Session Id - 123 (for e.g.)
		
		// After calling close method, session ID will be the same
//
//		System.out.println(driver1.getTitle()); // NoSuchSessionException - session IS is Invalid (In
//		 //case of calling close() method)
		
		// So, if we want to fetch the title again after closing the browser
		// then we have to reinitialize it and fetch the title again like
		// this:
		driver1 = new ChromeDriver(); // Session ID will be different from the one 
		// before calling close() method (Let's say, 456)
		driver1.get("https://www.google.com"); // Session ID - 456
		title1 = driver1.getTitle(); // Session ID - 456
		System.out.println("Act Title: "+title1);
		
		
		// DIFFERENCES BETWEEN CLOSE AND QUIT METHOD:
		
		// 1. When we call quit method the session ID for the browser instance
		// becomes null and calling any WebDriver method using the 
		// old WebDriver instance will throw 
		// "NoSuchSession exception - session Id is null".
		// Whereas after calling close method the session ID for the browser instance
		// remains same (old one) and calling any WebDriver method using the 
		// old WebDriver instance will throw 
		// "NoSuchSession exception - session Id is Invalid".
		
		
	}

}
