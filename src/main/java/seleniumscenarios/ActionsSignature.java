package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsSignature {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://signature-generator.com/draw-signature/");
		
		WebElement canvas = driver.findElement(By.id("signature-pad"));
		
		Actions act = new Actions(driver);
		
		Action signature = act.click(canvas)
				.moveToElement(canvas, 30, 10) // this movetoelement version will allow the mouse to move
				                             // certain units/offsets along the x and y axes
				.clickAndHold(canvas)
				.moveToElement(canvas, -200, -50)
				.moveByOffset(50, -50) // moveByOffset method is similar to moveToElement(element, int x-offset, int y-offset)
				// and moves the mouse pointer along x and y axes on the desired element. The only difference is that it assumes
				// that the mouse is already moved to the desired element to perform actions on and ONLY moves the pointer NOT
				// take mouse to the element
				.moveByOffset(50, -50)
				.moveByOffset(3, 3)
				.release(canvas)
				.build(); // calling only build method in a multi-action
		        // chain like this in the end will return an ACTION
		        // class (present in Selenium Library) object.
		
		signature.perform();
		
		// If the off-set value moves the mouse pointer
		// out of the bounds of the target element
		// then we get MoveTargetOutOfBoundsException
		// So, better to give lower off-set values.
		

	}

}
