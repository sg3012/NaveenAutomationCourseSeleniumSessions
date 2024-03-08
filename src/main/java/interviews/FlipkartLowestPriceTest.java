package interviews;

public class FlipkartLowestPriceTest {
	
	// PROBLEM STATEMENT:
	// Go to flipkart site >> search iphone
	// >> find all the iphones in the search results list
	// >> find the iphone with the lowest price
	// >> print the price on the console

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// XPATH FOR NOW:
		//span[contains(text(),'results for')]
		//ancestor::div//following-sibling::div
		//div[@data-id]//a[contains(@href,'apple-iphone')]
		//following-sibling::div//div[contains(text(),'₹')][1]
		
		
		// IMPROVED XPATH:
		//div//div[contains(@data-tkid,'.SEARCH')]
		//div[contains(text(),'₹')][1]
	}

}
