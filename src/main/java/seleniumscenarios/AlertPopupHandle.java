package seleniumscenarios;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {
	
	// This class explains about 
	// How to handle very simple JS Alert pop-ups, prompt pop-ups and
	// confirmation pop-ups using Selenium?
	
	// Alerts/Simple alerts are also called Browser pop-ups or JS pop-ups
	
	// We cannot locate the alerts using traditional
	// way of using either findElement or findElements
	// and do various user actions
	
	// (IMPORTANT INTERVIEW) How many types of JS pop-ups are there ?
	// There are 3 types of JS pop-ups:
	// 1. Alert or simple alert pop-up
	// 2. Prompt pop-up
	// 3. Confirmation pop-up
	
	
	// There are only 2 buttons that can appear on a JS alert pop-up, Cancel and Ok.
	// We cannot configure an alert to have buttons named something else
	// like Yes and No etc.
	
	// We can configure a prompt to have ONLY one text field.
	// We cannot have more than one text fields on a prompt.
	// If we have, then its not a prompt it is an Authentication
	// pop-up in most cases.
	
	// Clicking ok on an alert meaning accepting an alert whereas
	// clicking cancel meaning to dismiss an alert. We can also
	// dismiss an alert by pressing esc key on the keyboard.
	
	// To accept or click on OK on ANY of the 3 types of pop-ups
	// we call accept() method whereas to dismiss or click on CANCEL on ANY 
	// of the 3 types of pop-ups we call dismiss() method.
	
	// [NOTE]: When we call accept() or dismiss() methods for any
	// any of the 3 JS pop-ups the accept() will not click
	// on ok button displayed on the pop-up (depending on which pop-up it is).
	// Similarly dismiss() method will not click
	// on cancel button displayed on the pop-up (depending on which pop-up it is) it
	// just dismisses the pop-up by simulating pressing esc button on the keyboard.
	// Because when a JS po-up is displayed on a page and we click the esc key on
	// the keyboard manually the pop-up gets disappeared.
	
	// ALERTS are used on a web-page when user has performed an action
	// on a page and it is successfully done like after file upload
	// we get a success message in the form of a Alert
	
	// PROMPTS are used when we want an input to be entered 
	// in the prompt from the user and use that value later.
	
	// CONFIRM POP-UPS are used when we want a confirmation
	// from the user on the action he is going to perform
	// like deleting a record from a the user profile etc.
	
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// HANDLE SIMPLE ALERT POP-UP:
//		// 1. Click on the button that generates the alert
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click(); // If we 
//		// comment this line and try to interact with the alert then also
//		// we will get NOALERTPRESENT EXCEPTION because the alert is still
//		// not generated and we are trying interact with it.
//		Thread.sleep(2000);
//		
//		// 2. Switching to the alert using switchto method and perform user actions
//		Alert alert = driver.switchTo().alert();
//		
//		// 3. Capture alert text and display it
//		String alertText = alert.getText();
//		System.out.println(alertText);	
//		
//		// 4. accept the alert (simulating click on ok button on the alert):
//		alert.accept();
		
		//alert.dismiss(); // Will get NOALERTPRESENT EXCEPTION because
		// we have already accepted the alert and it is gone from
		// the page. But we are still trying to interact with the alert
		// and dismiss it even though it is not displayed any more
		// on the page.
		
		// HANDLE CONFIRM POP-UP:
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		String alertText = alert.getText();
//		System.out.println(alertText);
//		
//		// Accept the confirm pop-up:
//		alert.accept();
		
		
		// HANDLE PROMPT POP-UP:
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		Thread.sleep(2000);
		
		// (IMPORTANT) We will enter text on
		// a prompt using SENDKEYS() method
		// of Alert interface ONLY like this:
		alert.sendKeys("Testing Selenium");
		alert.accept();
		
		// Capture the actual text entered on prompt and print on the console:
		String promptActInputtxt = driver.findElement(By.id("result")).getText();
		
		String promptActOutputTxt = promptActInputtxt.split(":")[1].trim(); // We have trimmed
		// the text of string at index 1 to remove the space in the beginning which has been
		// introduced as part of splitting the actual input text on the Prompt
		
		System.out.println(promptActOutputTxt); // Testing Selenium
		
		// (IMPORTANT): When you enter a value
		// in the text field on a prompt
		// using sendKeys() method 
		// of Alert interface it will NOT
		// BE DISPLAYED on the UI but
		// selenium enters the value in BACKGROUND.
		// This is the DEFAULT behaviour of selenium
		// w.r.t entering values on prompts
		// until whatever is the latest version of selenium
		// available in the market at the time of writing this code.	
	}

}
