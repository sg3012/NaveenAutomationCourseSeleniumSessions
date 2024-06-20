package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {
	
	// This class explains how to handle Frames
	// and automate the elements inside them using Selenium.
	
	// By default when we launch a web page
	// the driver is on the page and can interact with
	// the elements directly present on the page.
	// To interact with elements that are present inside a frame
	// we need to take/switch the driver into the frame and start
	// interacting with the elements.

	// If you are sure that your locator is correct then MAKE IT A HABIT
	// of checking if the element is inside a frame or not.
	
	// We can switch to and handle frames:
	// --> Using FRAME INDEX
	// --> Using FRAME NAME
	// --> Using FRAME ID
	// --> Using FRAME AS WEBELEMENT
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		// String headerText = driver.findElement(By.tagName("h2")).getText();
		// NoSuchElement exception at this line because if we try to locate an element
		// which inside a frame directly, then driver is not able to find it.
		// System.out.println(headerText);
		
		// USING FRAME INDEX
		
//		driver.switchTo().frame(2);
//		String headerText = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(headerText);
		
		// USING FRAME NAME OR ID
		
		// But what if the developer adds more frame before or after
		// the desired frame in the DOM ? Then using frame Index to handle frames
		// is not a good idea. Then we will use frame Names OR IDs like below:
		
//		driver.switchTo().frame("main");
//		String headerText1 = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(headerText1);
		
		// USING FRAME WEBELEMENT
		
		// If I don't want to use frame NAME OR ID also OR NAME AND ID ATTRIBUTES ARE ALSO NOT AVAIALABLE 
		// then we could use frame as WebElement and switch to it and handle elements inside it.
		
		WebElement frame = driver.findElement(By.xpath("//frame[@src='top.html']"));
		driver.switchTo().frame(frame);
		String headerText2 = driver.findElement(By.tagName("h2")).getText();
		System.out.println(headerText2);
		
		// IMPORTANT(INTERVIEW): Once you have switched to a frame
		// will you be able to handle the elements outside
		// the frame or main page directly ?
		
		// Ans: NO, once we have switched to a frame and our work is done
		// inside it then we MUST switch the driver control back
		// to the main page or outside the frame by using 
		// DEFAULTCONTENT() method (as shown below)
		
		driver.switchTo().defaultContent();
	}

}
