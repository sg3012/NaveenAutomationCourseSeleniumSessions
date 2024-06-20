package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelectTag {
	
	// This class explains how to handle
	// the drp-downs without select tags
	
	

	public static void main(String[] args) throws InterruptedException {

		// IMPORTANT: How to freeze the element when it is defined using BLUR property?
		// If you are not able to freeze
		// the page / element for inspection and locate
		// it using F8 key on the keyboard, then use the following
		// method to freeze the element:
		
		// --> Open browser dev tools and switch to elements section
		
		// --> Go to the right side pane under elements section
		// and switch to Event Listeners tab
		
		// If you see a row named "Blur", expand it
		
		// Now go to the element you want to inspect (drop-down in this case)
		
		// Remove the sub-property/row under row "Blur" by clicking remove button
		
		// Go to the element again and try to inspect. You will now be able
		// to inspect it as it will not disappear on any keyboard event.
		
	     WebDriver driver = new ChromeDriver();
	     driver.get("https://demoqa.com/select-menu");
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//div[text()='Select Option']")).click();
	     
	     Thread.sleep(1500);
	     
	     List<WebElement> optionsEleList = driver.findElements(By.
	    		 xpath("//div[contains(@id,'react-select-2-option')]"));
	     
	     System.out.println(optionsEleList.size());
	     
	     for(WebElement ele : optionsEleList) {
	    	 String optionTxt = ele.getText();
	    	 System.out.println(optionTxt);
	    	 if(optionTxt.contains("Group 1, option 2")) {
	    		 ele.click();
	    		 break;
	    	 }
	     }
	}

}
