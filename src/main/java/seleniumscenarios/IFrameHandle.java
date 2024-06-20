package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {

	// This class explains how to handle iFrames
	// and automate the elements inside them using Selenium.

	// DIFFERENCE BETWEEN FRAME AND IFRAME:
	// iFrame follows W3 Standard but Frame doesn't
	// We can create duplicate frames in the HTML code of a page
	// and use them at other places but we couldn't create duplicate iFrames

	// Why developers create frames or iFrames on a page and place all the 
	// elements inside them?
	// Ans:
	// To provide the security to the web app.
	// To prevent unnecessary automation.

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates"
				+ "/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.id("RESULT_TextField-8")).sendKeys("TestAutomation");
		// If we try to locate an element which is inside an Iframe like in above line
		// then we will get NoSuchElement exception
		
		// HANDLE USING FRAME INDEX
		
		// HANDLE USING FRAME NAME OR ID
		
		// HANDLE USING FRAME WEBELEMENT
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("Shubham");
		driver.switchTo().defaultContent();
		
		// After switching back to the main page / area outside the boundary
		// of all the frames how we could prove that we have actually
		// come out of the frame?
		// Ans: Just interact with any element which is not inside any frame and
		// try to perform a user action on it like below:
		
		String formHeaderTxt = driver.findElement(By.id("tooltip")).getText(); // Interact
		// with the header txt element of the form just above it which is not
		// inside any frame
		
		System.out.println(formHeaderTxt); // O/P Interactive form loaded. Try filling out below.
			
		

	}
}
