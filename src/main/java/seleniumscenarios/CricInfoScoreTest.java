package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoScoreTest {
	
	// This class explains how we will
	// get the details like Wicket taker, number of runs
	// number of overs, number of Wickets etc. for 
	// a particular player from the score card of a cricket match
	// on the ESPN CricInfo Website.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		// E.g.1 : How to fetch the details of a batsmen
		// like wicket taker and the whole score card like 
		// number of runs, number of 4s and 6s etc. from
		// the 1st Innings score card
		
		//span[text()='England']
		//following-sibling::span[text()='1st Innings']
		//ancestor::div[contains(@class,'translucent-hover')]
		//following-sibling::div//table//span[text()='Zak Crawley']
		//ancestor::td//following-sibling::td//span   --> This Xpath will generate
		
		// 2 span elements with the wicket taker text. But we will still use it
		// because the second span element is directly under the 1st one (Immediate child)
		// So, if tomorrow the devs remove the child span and we need the wicket 
		// taker text of the Span, we could still get it using the parent span's
		// text. Because the getText() method in selenium fetches the text of both
		// parent and child if we call it on just the parent element.
		
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/england-in-india-2023-24-1389386/india-vs-england-4th-test-1389402/full-scorecard");
		
		Thread.sleep(4000);
		
		System.out.println(getWicketTakerName("Zak Crawley"));
		System.out.println(getWicketTakerName("Ben Duckett"));
		

	}
	
	// Generic function to return the wicket taker name
	// for a batsman on any cricket score updating application.
	public static String getWicketTakerName(String batsmanName) {
		
		System.out.println("Batsman name:"+batsmanName);
		
		return driver
		.findElement(By.xpath("//span[text()='England']"
			+ "//following-sibling::span[text()='1st Innings']"
			+ "//ancestor::div[contains(@class,'translucent-hover')]"
			+ "//following-sibling::div//table//span[text()='"+batsmanName+"']"
			+ "//ancestor::td//following-sibling::td//span")).getText();
	}

}
