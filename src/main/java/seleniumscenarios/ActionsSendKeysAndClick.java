package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysAndClick {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailID = By.id("input-email");
		By password = By.id("input-password");
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(emailID), "test@gmail.com").perform();
		act.sendKeys(driver.findElement(password), "test@12345").perform();
		
		
		
		
		

	}

}
