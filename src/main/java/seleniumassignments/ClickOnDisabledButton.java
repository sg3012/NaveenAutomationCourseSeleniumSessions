package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnDisabledButton {
	
	// This class explains what happens when 
	// we try to click on a disabled button

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=HTMLButtonDisabled");
		driver.findElement(By.xpath("/html/body/form/div/label[4]/label/button"))
		.click();
		
		// (INTERVIEW): What will happen if we try to click a disabled button?
		// Ans: We will get NoSuchElementException.

	}

}
