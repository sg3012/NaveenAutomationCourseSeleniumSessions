package seleniumassignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownGetListOfAllAttributesWithoutSelectClass {
	// This class explains how to get the list
	// of all the attributes in a drop-down
	// that have a <select> HTML tag
	// But WITHOUT using SELECT class AT ALL

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Thread.sleep(4000);
		
		By countryDropdownAttr = By.xpath("//select[@id='Form_getForm_Country']"
				+ "/option[@value]");
		
		List<WebElement> countryDropdownAttrList = driver.
				findElements(countryDropdownAttr);
		System.out.println(countryDropdownAttrList.size());

	}

}
