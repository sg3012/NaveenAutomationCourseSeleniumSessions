package seleniumscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTest {
	
	// This class shows how to link the browserdriver.exe files
	// downloaded separately in the automation code, programmatically.

	public static void main(String[] args) {
		
		// Below code should be written using Selenium 4.5.0 or less
		
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		String title = driver.getTitle();
//		System.out.println("Actual Title: "+title);
		
		// If we run only the above code directly without linking browserdriver.exe's
		// path in the code we will get IllegalStateException to give the browser driver
		// exe file path in the code.	
		
		// This is how we would write the code to launch the browser
		// and set the path to the browserdriver.exe file using 
		// setProperty() method of System class, using Selenium version 4.5.0 or less.
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sgupta52\\My Drive D"
				+ "\\Eclipse_WorkSpace\\BrowserDrivers\\chromedriver.exe"); // code to set the chormedriver
		// executable path to launch the chrome browser
		
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sgupta52\\My Drive D"
				+ "\\Eclipse_WorkSpace\\BrowserDrivers\\geckodriver.exe"); // code to set the firefoxdriver
		// executable path to launch the firefox browser
		
//		WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sgupta52\\My Drive D"
				+ "\\Eclipse_WorkSpace\\BrowserDrivers\\msedgedriver.exe"); // code to set the edgedriver
		// executable path to launch the edge browser
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("Actual Title: "+title);
	}

}
