package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingShadowDOMElements {
	
	// This class explains how could we handle
	// the web elements which are inside shadow-DOM
	// and interact with them
	
	// In this e.g: We want to enter values inside
	// an input element on a web page which is inside
	// an Iframe which is further inside shadow DOM.
	// So, below is the path to final element:
	
	// BROWSER >> PAGE >> SHADOW DOM >> IFRAME >> FINAL ELEMENT

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(3000);
		
		// SWITCHING TO THE IFRAME WHICH IS INSIDE SHADOW DOM
		
		// Reaching to the iframe in shadow DOM using JS command
		String script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement shadowDOMIframeEle = (WebElement)js.executeScript(script);
		
		// Switching to the frame using frame as web element
		driver.switchTo().frame(shadowDOMIframeEle);
		
		driver.findElement(By.id("glaf")).sendKeys("Entering Destiny");
		
		
		
		
		
	}

}
