package interviews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLowestPriceTest {

	// PROBLEM STATEMENT:
	// Go to flipkart site >> search iphone
	// >> find all the iphones in the search results list
	// >> find the iphone(s) with the lowest price
	// >> print the prices and names of all the products on console
	
	//                   OR
	
	// >> click all the products with lowest price

	// Symbol TO BE REMOVED : ₹ and comma

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
        // Find the list of all the prices for all the products in search results 
		List<WebElement> productPriceListOfEle = driver.findElements(
				By.xpath("//div//div[contains(@data-tkid,'.SEARCH')]" + "//div[contains(text(),'₹')][1]"));
		System.out.println("Number of search results:"+productPriceListOfEle.size());
        
		// List to store the indices for all the products mapped to lowest
		// price in the search results
		List<Integer> productIndicesList = new ArrayList<Integer>();
		
		// Find the list of standard names for all the products in search results 
		List<WebElement> productNamesList  = driver.findElements(
				By.xpath("//div[contains(@data-tkid,'.SEARCH')]//div[contains(text(),'Apple iPhone')]"));
		
		// Remove the symbols ₹ and , from the String price at index 0
		String stringPrice = productPriceListOfEle.get(0).getText().replaceAll("[₹,]", "");
					
		// Convert the price at index 0 in Integer format
		int intPrice = Integer.parseInt(stringPrice);

		// Initially declared lowest price as 0
		int lowestPrice = intPrice;

		for (int i = 0; i < productPriceListOfEle.size(); i++) {
			
			// Remove the symbols ₹ and , from the String prices
			stringPrice = productPriceListOfEle.get(i).getText().replaceAll("[₹,]", "");
			
			// Convert all the prices in Integer format
		    intPrice = Integer.parseInt(stringPrice);
			
	
		    // First check to check if current index price is less than
		    // lowest price, swap it with the lowest price it it is
		    // and insert the lowest price index in the list
			if (lowestPrice > intPrice) {
				lowestPrice = intPrice;
				productIndicesList.clear();
				productIndicesList.add(i);
			}
			
			// Second check to validate if current index price is equal to
		    // lowest price, insert the same price index again in the list (IN CASE OF MULTIPLE 
			// PRODUCTS MAPPED TO THE LOWEST PRICE)
			else if(lowestPrice == intPrice) {
				productIndicesList.add(i);
			}
		}
		
		System.out.println("Lowest price: " + lowestPrice);
		System.out.println("Lowest price list: " + productIndicesList);
		
		// Insert the lowest price index list and click or 
		// print the names and the prices of those elements
		// on the console
		for(int index : productIndicesList) {
			System.out.println(productPriceListOfEle.get(index).getText());
			System.out.println(productNamesList.get(index).getText());
			
//			productPriceListOfEle.get(index).click();
//			driver.navigate().back();
		}

	}
}
