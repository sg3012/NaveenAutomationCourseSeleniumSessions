package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartSVGSearchIcon {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.name("q")).sendKeys("POCO X6");
		
		Actions act = new Actions(driver);
		
		act
		.moveToElement(driver
				.findElement(By.xpath("//button[contains(@aria-label,'Search for Products')]"
						+ "//*[local-name()='svg']"))).click().build().perform();
		
	}

}
