package seleniumassignments;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandling {

	// This class automated the following scenario:
	// Step 1 : Open a parent window
	// Step 2 : Click on a link to open a child window pop-up
	// Step 3: Fetch the URL of the child window pop-up and print it on the console
	// Step 4: Close the child window pop-up
	// Step 5: Switch back to the parent window
	// Step 6: Repeat step 2 to 5 until all the child windows are opened and URLs
	// are fetched
	// Step 7: Finally Switch back to the parent window again and print it's URL on
	// the console  (IMPORTANT INTERVIEW SCENARIO)

	// NOTE: Make sure the parent window MUST NOT BE CLOSED
	// in the whole process.

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); // blank browser
		driver.get("https://opensource-demo.orangehrmlive." 
					+ "com/web/index.php/auth/login"); // parent / very first window

		Thread.sleep(3000);

		String parentWindowId = driver.getWindowHandle();
		
		List<WebElement> extMediaEleList = driver
				.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']/a"));

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		for (int i = 0; i < extMediaEleList.size(); i++) {
			System.out.println("===============Iteration "+i+" ================");
			extMediaEleList.get(i).click();
		    handles = driver.getWindowHandles();
		    it = handles.iterator();
			while (it.hasNext()) {
				String windowId = it.next();
				driver.switchTo().window(windowId);
				System.out.println("Window url: " + driver.getCurrentUrl());
				Thread.sleep(1500);
				if (!windowId.equals(parentWindowId)) {
					driver.close();
				}
			}
			driver.switchTo().window(parentWindowId);
			Thread.sleep(1000);
		}
		
		System.out.println("==========================");
		System.out.println("Parent Window URL: " + driver.getCurrentUrl());
	}

}
