package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketMultiLevelMenuHandle{
	
	// This class shows how to handle multi-level
	// menus on any web app like mouse hover, click
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Steps to pause the DOM:
		// Open dev tools.
		
		// Go to the webelement you want to inspect or create the corresponding scenario to generate
		// it
		
		// Go to sources tab in the dev tool.
		
		// Press fn + f8 and inspect the element now
		
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'content-start')]"
				+ "//div[contains(@class,'CategoryMenu___StyledBackdrop')]"
				+ "//button[contains(@id,'menu-button')]")).click();
		
	}

}
