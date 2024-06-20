package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementAndClick {

	// This class explains how do we configure explicit wait
	// for clickable elements and then click
	// on them once they are visible

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		Thread.sleep(4000);
		driver.findElement(By.name("username")).sendKeys("shubhamqa");
		driver.findElement(By.name("password")).sendKeys("Test@12345");

		By loginBtnBylocator = By.xpath("//input[@value='Login']");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		WebElement loginBtnEle = wait.until(ExpectedConditions.elementToBeClickable(loginBtnBylocator)); // Here
//		// until method will return the web element to be clicked.

//		loginBtnEle.click();
		
		clickElementWhenReady(loginBtnBylocator, 10);

	}

	/**
	 * Generic method to wait for an element to be visible as well as enabled on a web page
	 * and then click on it once it is visible and click-able.
	 * @param locator
	 * @param timeOut
	 * @return Nothing
	 */
	public static void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

}
