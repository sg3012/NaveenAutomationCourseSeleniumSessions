package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdownWithSelectClass {

	// This class explains how we can select values in
	// multi-select drop-down (a drop-down
	// in which use can select multiple values
	// at the same time).

	// Multi-select drop-downs are always created with the help
	// of <Select> tag

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		Thread.sleep(3000);
		WebElement dropDownEle = driver.findElement(By.xpath("//select[@multiple]"));
		
		Select select = new Select(dropDownEle);
		
		// Check if it is multi-select drop-down
		// or not using isMultiple() method of select class
		// and select multiple values if TRUE
		if(select.isMultiple()) {
			System.out.println("Multi selection is possible");
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("Greater flamingo");
			select.selectByVisibleText("James's flamingo");
		}
		
		Thread.sleep(1500);
		
		// HOW TO DESELECT SPECIFIC VALUE(S) IN DROP-DOWN?
		// Ans: Using various version of DESELECT() method
		// in the Select class
		
		select.deselectByVisibleText("Greater flamingo");
		
		// HOW TO DESELECT ALL THE VALUES AT ONCE?
		// Ans: Using DESELECTALL() method
		
		select.deselectAll();
		
	}

}
