package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumscenarios.ElementUtil;

public class ClickOnParticularLink {

	// This class explains on how to click on a 
	// particular link present in a specific section
	// on https://naveenautomationlabs.com/opencart/index.php?route=account/register PAGE
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		ElementUtil eleUtil = new ElementUtil(driver);
		By linksRightColumn = By.xpath("//aside[@id='column-right']//a");
		eleUtil.clickOnLink(linksRightColumn, "Forgotten Password");
	}

}
