package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumscenarios.JavaScriptUtil;

public class FlashElementsOnAWebPage {

	
	// This class explains about how to automate highlighting or 
	// flashing of a web element on a web page with different colors.
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Thread.sleep(2000);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		WebElement firstNameEle = driver.findElement(By.id("input-firstname"));
		WebElement lastNameEle = driver.findElement(By.id("input-lastname"));
		WebElement emailEle = driver.findElement(By.id("input-email"));
		WebElement telephoneEle = driver.findElement(By.id("input-telephone"));
		WebElement pwdEle = driver.findElement(By.id("input-password"));
		WebElement confrmPwdEle = driver.findElement(By.id("input-confirm"));
		
		jsUtil.flash(firstNameEle);
		firstNameEle.sendKeys("Selenium");
		
		jsUtil.flash(lastNameEle);
		lastNameEle.sendKeys("Automation");
		
		jsUtil.flash(emailEle);
		emailEle.sendKeys("test@automation.com");
		
		jsUtil.flash(telephoneEle);
		telephoneEle.sendKeys("1234567890");
		
		jsUtil.flash(pwdEle);
		pwdEle.sendKeys("test@12345");
		
		jsUtil.flash(confrmPwdEle);
		confrmPwdEle.sendKeys("test@12345");
	}

}
