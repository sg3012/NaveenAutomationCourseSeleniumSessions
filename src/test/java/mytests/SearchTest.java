package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
	
	// This class how to write the automated tests
	// for a product search functionality on a web app
	// using different search keywords in the form test data
	// from Data Provider. 
	// At last we have to validate how many products
	// are there after every search.
	
	@DataProvider(name = "searchData") // We can also give some custom names
	// to our dataprovider like this and use the same name
	// in @Test when calling the dataprovider there.
	// So, if we have given a custom name to our data provider
	// then we can have 2 choices of names to be used in @Test, the custom name
	// or the method name under @DataProvider
	
	// @DataProvider
	public Object[][] searchTestData() {
		return new Object[][] {
			{"macbook",3}, // The numbers in the second
			// column of the array here indicate how many
			// products are expected to be returned after
			// every product search i.e., expected number of
			// products
			{"imac",1},
			{"samsung",2},
			{"canon",1},
			{"naveen",0}
		};
	}

	@Test(dataProvider = "searchData")
	public void searchTest(String searchKeyword, int expSearchCount){
		
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(searchKeyword);
		
		driver.findElement(By.cssSelector("div#search button")).click();
		
		String actHeaderTxt = driver.findElement(By.cssSelector("div#content h1")).getText();
		
		Assert.assertTrue(actHeaderTxt.contains(searchKeyword));
		
		int actSearchCount = driver.findElements(By.cssSelector("div.product-layout")).size();
		
		System.out.println(searchKeyword + " count ===>" + actSearchCount);

		Assert.assertEquals(actSearchCount,expSearchCount);
		
		// NOTE[IMPORTANT]: If the 
		// number of columns in the returned Object array
		// from the Data provider is GREATER THAN the number
		// of parameters in the method under Test annotation using
		// that data provider then we will get MethodMatcherException:
		// Data provider mismatch. So, make sure
		// the number of parameters in the test method
		// should always be equal to the number of columns
		// returned from Data Provider
	}

}
