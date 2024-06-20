package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {

	// This class explains how to implement
	// wait strategy for non-web elements like
	// Frames / Iframes on a web page.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		Thread.sleep(4000);
		driver.findElement(By.name("username")).sendKeys("shubhamqa");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By frameLocator = By.name("mainpanel");

		// The method frameToBeAvailableAndSwitchToIt will check if
		// the frame is available using its By locator and switch
		// to it if found AUTOMATICALLY. We don't need to write
		// switch to statement manually.
		// In this case the until method will return WebDriver only after
		// consuming the frameToBeAvailableAndSwitchToIt method as parameter
		// because after switching to the frame we have nothing else
		// to return apart from the driver. As driver is the point
		// where we will start our next course of actions.
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		// waitForFrameByLocator(frameLocator, 10);
		waitForFrameByFrameNameorId("mainpanel", 10);
		driver.findElement(By.linkText("CONTACTS")).click();
	}

	// We will not return the webdriver from below methods
	// because until method will return the same driver
	// we are already using in our code
	/**
	 * Generic method to wait for a frame element using its By locator value. This
	 * method also switches automatically to the frame if found
	 * 
	 * @param frameLocator
	 * @param timeOut
	 * @return nothing
	 */
	public static void waitForFrameByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	/**
	 * Generic method to wait for a frame element using its integer index value.
	 * This method also switches automatically to the frame if found
	 * 
	 * @param frameIndex
	 * @param timeOut
	 * @return nothing
	 */
	public static void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	/**
	 * Generic method to wait for a frame element using its string name or id value.
	 * This method also switches automatically to the frame if found
	 * 
	 * @param FrameNameorId
	 * @param timeOut
	 * @return nothing
	 */
	public static void waitForFrameByFrameNameorId(String frameNameorId, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameorId));
	}

	/**
	 * Generic method to wait for a frame element using its WebElement value.
	 * This method also switches automatically to the frame if found
	 * 
	 * @param frameElement
	 * @param timeOut
	 * @return nothing
	 */
	public static void waitForFrameByFrameElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

}
