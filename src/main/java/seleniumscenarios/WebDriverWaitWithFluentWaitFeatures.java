package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitWithFluentWaitFeatures {

	// WebDriverWait (Extends) FluentWait (Implements) Wait // (until());
								// until(){}
								// Own Methods
	// This class shows how we could implement WebDriver wait
	// having some Fluent Wait features

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email = By.id("input-email");

		// Creating web driver wait using Fluent Wait features

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait
//			.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchFrameException.class)
//					.withMessage("TimeOut is done...Element not found..."+email)
//						.until(ExpectedConditions.visibilityOfElementLocated(email))
//							.sendKeys("Testing");

		// We can create webdriver wait with Fluent Wait features as WebDriverWait
		// is the child class of Fluent Wait class.

		waitForElementAndEnterValue(email, 10, 2, "Testing@test.com");

	}

	// Generic method to wait for an input web element using Fluent Wait
	// Mechanism and enter value in it
	public static void waitForElementAndEnterValue(By locator, int timeOut, int pollingTime, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchFrameException.class)
				.withMessage("TimeOut is done...Element not found..." + locator)
				.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
	}

	// Generic method to wait for a web element using Fluent Wait
	// Mechanism and click on it
	public static void waitForElementAndClick(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchFrameException.class)
				.withMessage("TimeOut is done...Element not found..." + locator)
				.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}
	
	// [INTERVIEW IMPORTANT]: What is the Difference between WebDriverWait and FluentWait?
	// Ans: The technical difference between WebDriverWait and FluentWait is WebDriverWait
	// class is the child of FluentWait class. FluentWait is the implementing child class
	// of Wait interface. Now, FluentWait has implemented and overriden the until()
	// method of Wait interface along with some of its own methods like pollingEvery(),
	// ignoring(), withMessage() etc which WebDriverWait inherits from it but
	// WebDriverWait doesn't have any public method which we could use 
	// apart from some constructors. This is the difference.

}
