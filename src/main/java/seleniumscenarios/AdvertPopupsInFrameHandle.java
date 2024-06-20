package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvertPopupsInFrameHandle {
	
	// This class explains how do handle pop-ups written 
	// inside a frame which come 
	// on any web site after a certain logic
	// is satisfied

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demos.jquerymobile.com/1.4.0-rc.1/popup-iframe/"); // MAIN PAGE
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@data-rel='popup' and @aria-owns='popupVideo']")).click();
		
		driver.switchTo().frame(driver.findElement(By
				.xpath("//iframe[contains(@src,'https://player.vimeo.com/video')]")));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(@class,'PlayButton_module')]")).click();
		
		
		
		
		
		
		
	}

}
