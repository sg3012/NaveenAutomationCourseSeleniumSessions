package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {

	// This class explains about how to configure our own custom wait which may
	// be similar to WebDriver wait or Fluent Wait or Implicit wait

	// [INTERVIEW-VERY IMPORTANT] How will you configure wait in your automation
	// framework without using WebDriverWait, FluentWait or ImplicitWait?
	// Ans: See the solutions implemented in function "retryingElement" below.
	// The mechanism implemented in the function is also called CONVERTING your 
	// STATIC JAVA wait into DYNAMIC wait. Because we are using Thread.sleep()
	// command in the below functions and converting that into Dynamic wait
	// mechanism by implementing our own logic on top of it.
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By email = By.id("input-email11");

		// We don't know is how much time an element is going to appear
		// on a web page. It may take 1 sec, 2 secs, 6 secs or 8 secs etc.
		// The custom wait logic is based on using loops and as we don't
		// know how much duration / iterations I have to keep
		// checking for the element we will use while loop here (see the method below).
		
		// retryingElement(email, 5).sendKeys("test@test.com");
		retryingElement(email, 5, 1000).sendKeys("test@test.com");

	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	
	// Generic method implementing Custom Fluent Wait like
	// mechanism to wait for an element and perform action
	// if found within the waiting time limit else throw exception
	// Default polling time is 500ms
	public static WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null; // Default value of an element will be null as it's
		// non-primitive type.

		int attempts = 0; // Variable to track how many attempts / retries
		// are performed while locating an element.

		while (attempts < timeOut) {
			try { // try for the element. If it is found in the first
					// attempt only then break try-catch and the loop in turn
					// else go to catch block and handle it accordingly.

				element = getElement(locator); // if element is immediately available here
				// then below line will be printed and loop will be break BUT if
				// element is not available in first attempt then this line
				// will throw NoSuchElementException. To handle that we will use try-catch
				// mechanism
				// and enclose above and below lines in try-catch blocks.
				System.out.println("Element is found...." + locator + " in attempt" + attempts);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found...." + locator + " in attempt" + attempts);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				attempts++;
			}

		}
		if (element == null) {
			System.out.println("Element is not found...." + locator + " in attempt" + attempts);
		}
		return element;
	}
	
	// Generic method implementing Custom Fluent Wait like
	// mechanism to wait for an element and perform action
	// if found within the waiting time limit else throw exception
	// User can give their own custom pollingTime in this method
	public static WebElement retryingElement(By locator, int timeOut, int pollingTime) {

		WebElement element = null; // Default value of an element will be null as it's
		// non-primitive type.

		int attempts = 0; // Variable to track how many attempts / retries
		// are performed while locating an element.

		while (attempts < timeOut) {
			try { // try for the element. If it is found in the first
					// attempt only then break try-catch and the loop in turn
					// else go to catch block and handle it accordingly.

				element = getElement(locator); // if element is immediately available here
				// then below line will be printed and loop will be break BUT if
				// element is not available in first attempt then this line
				// will throw NoSuchElementException. To handle that we will use try-catch
				// mechanism
				// and enclose above and below lines in try-catch blocks.
				System.out.println("Element is found...." + locator + " in attempt" + attempts);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found...." + locator + " in attempt" + attempts);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				attempts++;
			}

		}
		if (element == null) {
			System.out.println("Element is not found...." + locator + " in attempt" + attempts);
		}
		return element;
	}

}
