package seleniumscenarios;

// We have done this static import because with method
// is a static method of RelativeLocator class and we want to
// tell the compiler that we are importing a static method in static way.

// What is the ADVANTAGE of static imports in JAVA?
// Ans: Let's say I want to use a static method (with method in this case)
// at multiple locations inside a class (let's say 20 locations) then I have
// to write CLASSNAME.METHODNAME same number of times repeatedly. To avoid this
// we do static imports so, that we could use static method names directly without
// using class name every time we want to call that method.
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorsConcept {
	
	// This class explains about the the Relative
	// locators feature that was introduced as part
	// of Selenium 4 (or Selenium 4.x onwards).
	
	// Relative locators help to locate the
	// relatives of a particular element
	// i.e, parent, siblings etc.
	
	// So, to locate the Relative elements from an element
	// we can generally go in 4 directions as shown below:
	
	                                  // Above
	//   (preceding-sibling)Left<------- ele -----> Right(following-sibling)
                                      // Below
	
	// There is one more direction which can be either of the
	// 4 directions above i.e., Near direction.
	
	// So, we will use following methods/functions
	// to locate the Relatives of a particular element in Selenium:
	// LEFT
	// RIGHT
	// ABOVE
	// BELOW
	// NEAR

	public static void main(String[] args) throws InterruptedException {

		// Go to the AQI.IN website and locate the elements
		// to the left, right, above and below of an element
		// in the web table for most polluted cities
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.linkText("Laval, Canada"));
		
		// Go to the right of ele and find the element with AQI number:
		
		// We will use the static "WITH" method in the Selenium Library
		// to achieve this task. But first we have to import with
		// method in a STATIC way (see imports section at the top of this class):
		
		// Below statement says:
		// driver find an element with tagname or html tag "p"
		// which is exactly to the right of the element "Cape Breton, Canada" i.e., "ele"
		String rightIndex = driver.findElement(with(By.tagName("p"))
				.toRightOf(ele)).getText(); 
		
		System.out.println(rightIndex); // O/P - 50 (AQI value)
		
		// Go to the left of ele and find the element Rank in the table:
		
		// Below statement says:
		// driver find an element with tagname or html tag "p"
		// which is exactly to the left of the element "Cape Breton, Canada" i.e., "ele"
	    String leftIndex = driver.findElement(with(By.tagName("p"))
	    		.toLeftOf(ele)).getText();
	    System.out.println(leftIndex); // O/P - 5
	    
	    // Go to the below of ele and find the city name element below it in the table:
	    
	    // Below statement says:
	    // driver find an element with tagname or html tag "p"
	    // which is exactly below the element "Cape Breton, Canada" i.e., "ele"
	    String belowCityName = driver.findElement(with(By.tagName("p"))
	    		.below(ele)).getText();
	    System.out.println(belowCityName); // O/P - Mont Royal, Canada
	    
	    // Go to the above of ele and find the city name element above it in the table:
	    
	    // Below statement says:
	    // driver find an element with tagname or html tag "p"
	    // which is exactly above the element "Cape Breton, Canada" i.e., "ele"
	    String aboveCityName = driver.findElement(with(By.tagName("p"))
	    		.above(ele)).getText();
	    System.out.println(aboveCityName); // O/P - Banff, Canada
		
		// Go to the base element and find any element near to it:
	    
	    // We will use near method of selenium library to achieve this.
	    // The near distance will be defined in PIXELS and be calculated
	    // using the HTML DOM of the page.
	    
	    String nearCityName = driver.findElement(with(By.tagName("p"))
	    		.near(ele)).getText();
	    System.out.println(nearCityName); // O/P - Cape Breton, Canada. Why ?
	    // Because Cape Breton, Canada is exactly written on an anchor tag
	    // inside the DOM and the nearest element of this <a> tag is it's
	    // immediate parent which is <p> tag. Now, getText() method of selenium
	    // returns the same text for the parent which is written on the CHILD,
	    // if parent tag doesn't have it's own text.
	    
	    
	    // Using Relaive locator methods with FINDELEMENTS
	    
	    // Go to the base element and find ALL the elements exactly Below it
	    
	    List<WebElement> belowCityList = driver.findElements(with(By.xpath("//div[@id='most_pollutedCitiesRank']/p"))
	    		.below(ele));
	    
	    System.out.println("-----------------------");
	    
	    // Iterate the list of city elements
	    // and print their text one by one
	    for(WebElement cityNameEle : belowCityList) {
	    	System.out.println(cityNameEle.getText());
	    }
		
	}

}
