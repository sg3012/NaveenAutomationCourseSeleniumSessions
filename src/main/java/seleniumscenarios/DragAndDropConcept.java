package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	// This class explains how we can
	// move to a particular element > Drag it > 
	// Drop it to the desired location on
	// a web page using Selenium

	// This could be achieved using ACTIONS class
	// in Selenium

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		Thread.sleep(2000);
		
		WebElement sourceEle = driver.findElement(By.xpath("//div[@id='dropContent']//div[@id='box4']"));
		
		WebElement targetEle = driver.findElement(By.xpath("//div[@id='countries']//div[text()='Denmark']"));
		
		Actions act = new Actions(driver);
		
		// Use methods clickandhold, movetoelement, release to perform desired action
//		act.clickAndHold(sourceEle).
//				moveToElement(targetEle).
//					release().
//						build().
//						 	perform(); // valid, it will drag and drop
		
//		act.
//			clickAndHold(sourceEle).
//				moveToElement(targetEle).
//						release().perform(); // valid, it will drag and drop
		
		// We can also use direct DragAndDrop method as shown below for the same purpose:
		act.dragAndDrop(sourceEle, targetEle).build().perform();
		
		// (INTERVIEW QUESTION) : Without using DragandDrop function,
		// what all composite actions do I need to perform to execute
		// drag and drop action?
		// Ans: Following will be the composite actions:
		// clickandhold
		// movetoelement
		// release
		// build
		// perform
		
		
		// NOTE: We can only Drag and a WEB ELEMENT TO
		// another WEB ELEMENT using SELENIUM. We cannot Drag and Drop a FILE
		// from local SYSTEM to another Web page's WEB ELEMENT
		// using Selenium, it is not supported.
	}

}
