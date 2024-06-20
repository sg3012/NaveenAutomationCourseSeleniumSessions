package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcept {

	// This class explains the FLUENT WAIT
	// CONCEPT in Selenium

	// WebDriverWait (Extends) FluentWait (Implements) Wait // (until());
	                           // until(){} 
	                           // Own Methods
	// What is Fluent Wait in Selenium?
	// Ans: Fluent wait is also a type of Explicit
	// wait in Selenium having some fluent features.

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// By email = By.id("input-email"); // Correct locator, To simulate
		// desired element is found even before the waiting timeout is reached and the
		// rest
		// of the waiting time is ignored , to
		// show the actual waiting mechanism

		By email = By.id("input-email"); // Incorrect locator, To simulate
		// waiting timeout reached and the desired element is still not found, to
		// show the actual waiting mechanism

		// The Generic <T> in the FluentWait class constructor
		// FluentWait<T> means the constructor takes a
		// parameter called Type which is called as T in the constructor's
		// implementation. And we can pass
		// any custom Type like String, Integer, WebDriver etc.

		// So, as we will use FluentWait over our webdriver
		// we will give the Type T as WebDriver Type like below
		// and the parameter as WebDriver reference.

		// new FluentWait<T>(null);

//		// Creating a fluent wait:
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//									.withTimeout(Duration.ofSeconds(10)) // This method defines the total wait time
//									.pollingEvery(Duration.ofSeconds(2)) // This method defines the time interval
//									// after which selenium has to check for the element on the page again
//									.ignoring(NoSuchElementException.class) // This method defines which exception
//									// to ignore if any comes during wait and polling for the element
//									.withMessage("-----time out is done.....element is not found....."+email);	
//									// This method displays whatever message user 
//		                            // wants to display on the console once the waiting time
//									// for the element expires.
//		
//		// Waiting for the desired element over the waiting period
//		// defined in Fluent wait above
//		wait
//			.until(ExpectedConditions.visibilityOfElementLocated(email))
//				.sendKeys("testing");

		waitForElementVisibleWithFluentWait(email, 10, 1).sendKeys("testing");

	}

	/**
	 * Generic function to wait for an element using Fluent Wait mechanism based on
	 * if its visible on the page or not. It will wait till the waiting timeout and
	 * keep on trying to locate the element after the time interval given as
	 * pollingTime. Visible on page means the element is not only displayed on the
	 * page but also have a height and width should be greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return Webelement to perform some action
	 */
	public static WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
				.withMessage("-----time out is done.....element is not found....." + locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Generic function to wait for an element using Fluent Wait mechanism based on
	 * if its present in the HTML code (DOM) of a page or not, irrespective of
	 * whether its visible on the page or not.It will wait till the waiting timeout
	 * and keep on trying to locate the element after the time interval given as
	 * pollingTime.
	 * 
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return Webelement to perform some action
	 */
	public static WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("-----time out is done.....element is not found....." + locator);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * Generic method to wait for JS Alerts using Fluent Wait mechanism.
	 * It will wait till the waiting timeout and keep on trying to locate 
	 * the element after the time interval given as pollingTime. 
	 * It also creates, returns and switches to the alert automatically
	 * @param timeOut
	 * @param pollingTime
	 * @return Alert type reference to perform some action
	 */
	public static Alert waitForJsAlertWithFluentWait(int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoAlertPresentException.class)
		// Here we will ignore NoAlertPresentException instead of NoSuchElementException because
		// when Alert is not present on a page and we are locating it we will get
		// NoAlertPresentException not NoSuchElementException
				.withMessage("-----time out is done.....JS Alert is not found.....");
		return wait.until(ExpectedConditions.alertIsPresent());
	}
}
