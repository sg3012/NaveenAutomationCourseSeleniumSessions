package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class HandleWebTableUsingRelativeLocators {
	
	// This class will automate the following scenario:
	// Go to page: https://selectorshub.com/xpath-practice-page/
	// Locate the web table below
	// Find Joe Root element row on the table and click
	// on the left check box for the row, find the text of
	// all the right elements of JOE ROOT

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://selectorshub.com/xpath-practice-page/");
		 
		 Thread.sleep(5000);
		 
		 // Find the element JOE ROOT on the web table:
		 
		 WebElement ele = driver.findElement(By.linkText("Joe.Root"));
		 
		 // Click check box exactly to the LEFT of Joe Root
		 
		 driver.findElement(with(By.id("ohrmList_chkSelectRecord_21")).toLeftOf(ele)).click();
		 
		 // Find text of element exactly to the RIGHT of Joe Root
		 
		 String rightRoleTxt = driver.findElement(with(By.tagName("td")).toRightOf(ele)).getText();
		 System.out.println(rightRoleTxt);
		 
		 // Find text of the element exactly BELOW Joe Root
		 String belowUserNameTxt = driver.findElement(with(By.tagName("td")).below(ele)).getText();
		 System.out.println(belowUserNameTxt);
		 
		 // Find text of the element exactly ABOVE of Joe Root
		 String abovUserNameTxt = driver.findElement(with(By.tagName("td")).above(ele)).getText();
		 System.out.println(abovUserNameTxt);

	}

}
