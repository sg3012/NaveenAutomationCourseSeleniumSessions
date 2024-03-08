package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchElementExceptionConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart"
				+ "/index.php?route=account/register");
		
		By forgotPwd = By.linkText("Forgotten Password11");
		
//		 driver.findElement(forgotPwd).click(); // org.openqa.selenium.NoSuchElementException
//		 
//		 System.out.println(driver.getTitle());
		
		// (INTERVIEW) What will happen if we try to find an element
		// with wrong locator or what will happen if selenium
		// can't find an element with the supplied locator ?
		//Ans: Selenium will give org.openqa.selenium.NoSuchElementException
		
		// Do we really need to fix exception in this case?
		// Ans: No. Because the exception is coming because the locator itself
		// is wrong. So we need to fix the locator to fix the exception. (see below):
		
		try {
			driver.findElement(forgotPwd).click(); // Again NoSuchElementException
		}
		catch(Exception e) {
			System.out.println("getting element exception...plz check your locator");
			e.printStackTrace();
		}
		
		System.out.println(driver.getTitle()); // This will return the title. But it will
		                                       // not solve our purpose of clicking the element.
	}

}
