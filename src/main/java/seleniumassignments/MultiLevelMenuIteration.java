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
				+ "//div[contains(@class,'CategoryMenu___StyledBackdrop')]"
				+ "//button[contains(@id,'menu-button')]"));
		Actions act = new Actions(driver);
		act.moveToElement(level1MenuLink).click().perform();
		Thread.sleep(1500);

		WebElement level2MenuLink = driver.findElement(By.xpath("//div[contains(@class,'content-start')]"
				+ "//a[text()='Fruits & Vegetables']"));
		act.moveToElement(level2MenuLink).perform();
		
		List<WebElement> level3MenuEleList = driver.findElements(By.linkText(""));
		
		List<WebElement> level4MenuEleList = driver.findElements(By.linkText(""));

		for (WebElement e1 : level3MenuEleList) {
			act.moveToElement(e1).perform();
				for (WebElement e2 : level4MenuEleList) {
					act.moveToElement(e2).click().perform();
				}
			}
	}

}
