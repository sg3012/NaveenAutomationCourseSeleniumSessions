package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameConcept {

	// This class explains how to handle Frames
	// and automate the elements inside them using Selenium.
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("shubhamqa");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		driver.switchTo().defaultContent();
	}

}
