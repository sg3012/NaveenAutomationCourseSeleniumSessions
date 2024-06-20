package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframesHandle {

	// This class explains how do we handle and interact with the elements in
	// Nested Iframes on a web page using Selenium

	// Nested Iframes: When we have Iframes inside Iframes then we call all these inner
	// Iframes as nested Iframes. 

	// In this class we will see how we interact with the elements
	// present in each of the nested Iframes including the outermost
	// Iframe

	// Now, if there are some elements inside the inner Iframes/Nested frames and
	// we have already switched to the outermost/parent Iframe then we
	// cannot interact with the elements using findelement/findelements
	// method directly, in the inner Iframes. We have to switch to the inner
	// Iframes first before interacting with the elements inside them.
	// So, it means you cannot interact with the elements in the Inner frames
	// without switching to the parent frame enclosing them and then to the respective
	// inner frame, just by assuming that innerframe elements are indirectly part of
	// the outermost frame.
	
	// DIFFERENCE BETWEEN DEFAULT CONTENT AND PARENT FRAME METHOD
	// ParentFrame method will take the control to the immediate -1
	// level enclosing frame, there is no enclosing frame then parentframe
	// will take the control to the main doc (outside area of all the frame) whereas defaultcontent
	// will always take the control to the main doc (outside area of all the frames)
	// irrespective of whether you are in an inner frame or the outermost frame.
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://selectorshub.com/iframe-scenario/");

		Thread.sleep(2000);
		
		// FORWARD TRAVERSING:

		// Switching to the outermost/ancestor Iframe:
		driver.switchTo().frame("pact1");

		// Locate an input element inside the outermost frame and enter a value:
		driver.findElement(By.id("inp_val")).sendKeys("First Crush");

		// Switching to the 1st Iframe (1st inner frame) inside the outermost frame:
		driver.switchTo().frame("pact2");

		// Locate an input element inside the 1st inner Iframe and enter a value:
		driver.findElement(By.id("jex")).sendKeys("Current Crush");

		// Switching to the 1st Iframe (2nd inner frame) inside the 1st inner frame:
		driver.switchTo().frame("pact3");

		// Locate an input element inside the 2nd inner Iframe and enter a value:
		driver.findElement(By.id("glaf")).sendKeys("Destiny");
		
		
//		driver.switchTo().frame("pact1"); // NOSUCHELEMENT EXCEPTION
//		// because BACKWARD TRAVERSING on the frames is NOT
//		// SUPPORTED BY frame() method we can ONLY switch
//		// to the FORWARD FRAMES
//
//		driver.findElement(By.id("inp_val")).sendKeys("BACK TO First Crush");
		
		// If we want to traverse from one inner frame to another inner frame
		// skipping one or more frame(s) in between in forward direction for e.g. from 1st innerframe to 3rd
		// innerframe directly then also we will get NOSUCHELEMENT EXCEPTION
		
		
		// BACKWARD TRAVERSING:
		
		// Now, if we want to switch to the outermost/ancestor frame
		// then we have to follow the following steps using 
		// parentFrame() method
		
		// PARENTFRAME METHOD: The method is used to switch back to the
		// immediate -1 level enclosing frame from the current
		// inner frame. If there is no other frame enclosing the current frame
		// then driver control will come on the page area outside the frame
		// i.e, the MAIN PAGE. This method was introduced in Selenium 4.x
		
//		// Step 1 --> Switch back to the 1st inner frame and update the value in the input field
//		// inside it:
//		driver.switchTo().parentFrame();
//		driver.findElement(By.id("jex")).sendKeys("Crush 2 - updated");
//		
//		// Step 2 --> Switch back to the outermost frame and update the value in the input field
//		// inside it:
//		driver.switchTo().parentFrame();
//		driver.findElement(By.id("inp_val")).sendKeys("First Crush - updated");
		
//		driver.switchTo().parentFrame(); // at this line
//		// driver control will come out
//		// of the outermost frame i.e., area outside
//		// it which is MAIN PAGE
//		
//		String formHeaderTxt = driver.findElement(By.tagName("h3")).getText();
//		System.out.println(formHeaderTxt);

//		driver.switchTo().defaultContent(); // So, if
//		// driver is at the outermost frame then defaultContent
//		// will take the control to the MAIN page. As we switched back
//		// to the first frame using parentFrame method so we are at the outermost frame
//		String formHeaderTxt = driver.findElement(By.tagName("h3")).getText();
//        System.out.println(formHeaderTxt);
        
        
        driver.switchTo().defaultContent(); // So, if
		// driver is at some innerframe inside the outermost frame (2nd innerframe in this case) 
        // then also the defaultContent will take the control to the MAIN DOC i.e., the outermost frame.
        String formHeaderTxt = driver.findElement(By.tagName("h3")).getText();
        System.out.println(formHeaderTxt);
	}

}
