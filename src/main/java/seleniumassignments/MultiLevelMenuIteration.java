package seleniumassignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiLevelMenuIteration {

	// This class explains how to iterate all the menu/sub menu
	// items in a multilevel menu on any web app
	// like an ecommerce web site Bigbasket, Flipkart etc.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(3000);

		WebElement level1MenuLink = driver.findElement(By.xpath("//div[contains(@class,'content-start')]"
				+ "//div[contains(@class,'CategoryMenu___StyledBackdrop')]" + "//button[contains(@id,'menu-button')]"));
		Actions act = new Actions(driver);
		act.moveToElement(level1MenuLink).click().perform();
		Thread.sleep(1500);

		WebElement level2MenuLink = driver
				.findElement(By.xpath("//div[contains(@class,'content-start')]" + "//a[text()='Fruits & Vegetables']"));
		act.moveToElement(level2MenuLink).perform();

		List<WebElement> level3MenuEleList = driver.findElements(By.xpath("//div[contains(@class,'content-start')]"
				+ "//div[contains(@class,'CategoryMenu')]//a[text()='Fruits & Vegetables']"
				+ "//ancestor::ul//following-sibling::ul[1]//a"));

		List<WebElement> level4MenuEleList = driver.findElements(By.xpath("//div[contains(@class,'content-start')]"
				+ "//div[contains(@class,'CategoryMenu')]//a[text()='Fruits & Vegetables']"
				+ "//ancestor::ul//following-sibling::ul[2]//a"));

		for (int i = 0; i < level3MenuEleList.size(); i++) {
//			  	System.out.println(e1.getText()); 
			level3MenuEleList = driver.findElements(By.xpath("//div[contains(@class,'content-start')]"
					+ "//div[contains(@class,'CategoryMenu')]//a[text()='Fruits & Vegetables']"
					+ "//ancestor::ul//following-sibling::ul[1]//a"));
			System.out.println("i: "+i);
			act.moveToElement(level3MenuEleList.get(i)).perform();
			System.out.println("Level 3 menu size:" + level3MenuEleList.size());
			Thread.sleep(4000);
			for (int j = 0; j < level4MenuEleList.size(); j++) {
				level4MenuEleList = driver.findElements(By.xpath("//div[contains(@class,'content-start')]"
						+ "//div[contains(@class,'CategoryMenu')]//a[text()='Fruits & Vegetables']"
						+ "//ancestor::ul//following-sibling::ul[2]//a"));
				System.out.println("Level 4 menu size:" + level4MenuEleList.size());
				System.out.println("J:"+j);
				act.click(level4MenuEleList.get(j)).perform();
				Thread.sleep(4000);
				System.out.println("Clicked "+driver.getCurrentUrl());
				
				
				if(j<level4MenuEleList.size()-1) {
				act.moveToElement(level1MenuLink).click().perform();
				act.moveToElement(level2MenuLink).perform();
				act.moveToElement(level3MenuEleList.get(i)).perform();
				Thread.sleep(4000);
				}
			}
			
				act.moveToElement(level1MenuLink).click().perform();
				act.moveToElement(level2MenuLink).perform();
		}

	}

}
