package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {

	// This class explains about how to wait
	// for non-web elements like title, url etc.

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");

		// Wait for the title to appear:
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		boolean  isRightTitle = wait.until(ExpectedConditions.titleContains("Free CRM")); // Here
//		// until method will return boolean as we are checking some string is present or
//		// not using contains method
//		if(isRightTitle) {
//			System.out.println(driver.getTitle());
//		}

//		String title = waitForTitleContains("Free CRM12", 5);
//		System.out.println(title);

	}

	// Generic method to wait for some part of the right title to appear and return
	// it
	public static String waitForURLContains(String partOfUrl, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlContains(partOfUrl))) {
				return driver.getCurrentUrl();
			} else {
				System.out.println(partOfUrl + " URL value is not present......");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(partOfUrl + " URL value is not present......");
			return null;
		}
	}

	// Generic method to wait for whole part of the right title to appear and return
	// it
	public static String waitForURLIs(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlToBe(urlValue))) {
				return driver.getCurrentUrl();
			} else {
				System.out.println(urlValue + " URL value is not present......");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(urlValue + " URL value is not present......");
			return null;
		}
	}

	// Generic method to wait for some part of the right title to appear and return
	// it
	public static String waitForTitleContains(String partOfTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleContains(partOfTitle))) {
				return driver.getTitle();
			} else {
				System.out.println(partOfTitle + " title value is not present......");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(partOfTitle + " title value is not present......");
			return null;
		}
	}

	// Generic method to wait for whole part of the right title to appear and return
	// it
	public static String waitForTitleIs(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleIs(titleValue))) {
				return driver.getTitle();
			} else {
				System.out.println(titleValue + " title value is not present......");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(titleValue + " title value is not present......");
			return null;
		}
	}
}
