package seleniumassignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoFetchScoreOfBatsmen {

	// This class explains how we will
	// get the score details of a batsmen
	// like number of runs, number of balls,
	// number of 4s and 6s etc. EXCEPT
	// wicket taker name.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/england-in-india-2023-24-1389386/india-vs-england-4th-test-1389402/full-scorecard");

		Thread.sleep(4000);
		
		System.out.println(getScoreDetails("Zak Crawley"));
		System.out.println(getScoreDetails("Ben Duckett"));

	}

	// Generic function to return the score details
	// for a batsman on any cricket score updating application,
	// EXCEPT wicket taker name.
	public static List<String> getScoreDetails(String batsmanName) {
			
			System.out.println("Batsman name:"+batsmanName);
			
			List<WebElement> batsmanScroreList = 
					driver
					.findElements(By.xpath("//span[text()='England']"
					+ "//following-sibling::span[text()='1st Innings']"
					+ "//ancestor::div[contains(@class,'translucent-hover')]"
					+ "//following-sibling::div//table//span[text()='"+batsmanName+"']"
					+ "//ancestor::td//following-sibling::td[contains(@class,'ds-text-right')]")); 
			
			List<String> scoreTextList =  new ArrayList<String>();
			
			for(int i = 0; i<batsmanScroreList.size(); i++) {
				String scoreText = batsmanScroreList.get(i).getText();
				scoreTextList.add(scoreText);
			}
			
			return scoreTextList;
		}

}
