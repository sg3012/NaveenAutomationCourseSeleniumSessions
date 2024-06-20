package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingWaitConcept {

	// This class explains the concept of POLLING TIME with waits in Selenium

	// Polling: It means keep on trying / looking for the web element
	// to be available on a web page after certain time interval.
	// For e.g. if polling time is defined as 2 secs and total timeout
	// is 10 secs then selenium will go the desired element after every
	// 2 seconds and check if the element is available or not. Means,
	// it will perform maximum of 5 attempts within 10 seconds to find the element.

	// [INTERVIEW IMPORTANT] : What is the Default polling time
	// for WebDriver wait in Selenium ?
	// Ans:If we don't give any polling time or interval time during
	// fluent wait then the DEFAULT POLLING TIME in selenium
	// is 500 ms (0.5 secs)	

	static WebDriver driver;

	public static void main(String[] args) {

//		Total timeout = 10 secs
//		Polling time = 2 secs

		// At 0th sec -> element not available
		// At 2nd sec -> element not available
		// At 4th sec -> element not available
		// At 6th sec -> element not available
		// So, maximum 5 attempts will be there...

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email = By.id("input-email1");

		// Creating webdriver wait without polling time:
		// Polling time is the 2nd parameter in the WebDriverWait constructor.

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // In this case
//		// the default polling time selenium will use is 500 ms.
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("testing");

		// Creating webdriver wait with polling time of 2 seconds:
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2)); // In this case
//		// the polling time selenium will use is 2 secs.
//
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("testing");

		waitForElementVisible(email, 10, 2);
	}

	/**
	 * Generic function to wait for an element based on if its visible on the page
	 * or not. It will wait till the waiting timeout and keep on trying to locate
	 * the element after the time interval given as pollingTime. Visible on page
	 * means the element is not only displayed on the page but also have a height
	 * and width should be greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return WebElement to be located
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
