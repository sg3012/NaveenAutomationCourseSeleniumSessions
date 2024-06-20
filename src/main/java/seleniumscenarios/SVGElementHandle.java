package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementHandle {
	// This class explains how to interact with the SVG elements
	// on a web page and perform some user actions on them.
	
	// SVG elements are mostly used to create images on a web page.
	
	// We couldn't interact with the SVG elements using traditional/
	// usual xpaths
	
	// For inspecting the PARENT SVG element we will use local-name()
	// function and for inspecting all the CHILD elements (DIRECT or INDIRECT)
	// under the parent we will use name() function.
	
	// We couldn't use CssSELECTOR locator to locate SVG elements because
	// they don't support CSSSelector
	
	// All child nodes (direct + Indirect) under an SVG tag will also be considered 
	// SVG type nodes whether it's g tag or title tag or p tag or a tag or path tag etc.
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//(VERY-IMPORTANT) Below is the SYNTAX for inspecting SVG elements:
		
		// FOR INSPECTING ONLY ONE ELEMENT WITH NO CHILD ELEMENTS
		//*[local-name()='svg'] (We have to write the exact syntax, REMEMBER THIS)
		
		// FOR INSPECTING CHILD ELEMENTS (DIRECT/INDIRECT)
		
		//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']
		
		// PARENT - //*[local-name()='svg' and @id='map-svg']
		
		// CHILD - //*[name()='g' and @id='regions']//*[name()='path']
		
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");

		Thread.sleep(6000);
		
		
		driver.switchTo().frame(driver
				.findElement(By
						.xpath("//iframe[contains(@id,'map-instance')]")));
		
		List<WebElement> statesEleList = 
				driver.findElements
				(By.xpath("//*[local-name()='svg' and @id='map-svg']"
						+ "//*[name()='g' and @id='regions']//*[name()='path']"));
		
		System.out.println(statesEleList.size()); // Print count of all the states in US
		                                          // O/P: 51
		
		// To each and every state name by using the DOM without 
		// Actions class
//		for(WebElement e1 : statesEleList) {
//			System.out.println(e1.getAttribute("name"));
//		}
		
		
		// To print each and every state name by hovering mouse
		// over the element using Actions class
		Actions act = new Actions(driver);
		for(WebElement e2 : statesEleList) {
			act.moveToElement(e2).build().perform();
			Thread.sleep(500);
		    String text = e2.getAttribute("name");
		    System.out.println(text);
		    if(text.equals("Maryland")) {
		    	e2.click();
		    	break;
		    }
		}
		
		// SYNTAX FOR CREATING SVG XPATH USING FOLLOWING SIBLING
		
		//*[local-name()='svg' and @id='map-svg']
		//*[name()='g' and @id='regions']/*[name()='g' and @id='alabama']//following-sibling::*[name()='g']
		
		// SYNTAX FOR CREATING SVG XPATH USING PREDEDING SIBLING
		
		//*[local-name()='svg' and @id='map-svg']
		//*[name()='g' and @id='regions']/*[name()='g' and @id='alaska']//preceding-sibling::*[name()='g']
	}

}
