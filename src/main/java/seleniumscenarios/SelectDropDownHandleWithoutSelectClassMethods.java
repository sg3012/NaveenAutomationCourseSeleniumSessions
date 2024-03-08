package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandleWithoutSelectClassMethods {

	// (INTERVIEW QUESTION - IMPORTANT)
	// This class explains how to handle
	// the drop-downs in Selenium
	// that have a <select> HTML tag
	// But WITHOUT using select class internal
	// methods. We can use select class just to locate the drop-down
	// and get all the options inside it

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Thread.sleep(4000);

		By countryDropdown = By.id("Form_getForm_Country");
		
		doClickDropDownValue(countryDropdown, "Brazil");

		Thread.sleep(2000);
		
		doClickDropDownValue(countryDropdown, "India");
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// Generic method to click any value in a drop-down but
	// WITHOUT using any select class internal methods
	public static void doClickDropDownValue(By locator,String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

}
