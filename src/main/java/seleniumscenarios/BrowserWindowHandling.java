package seleniumscenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling {
	
	// This class explains how to handle new browser window
	// pop-ups or just window pop-ups using Selenium
	// like switching to a new window pop-up and do some operations on it.
	// FOR ONLY ONE PARENT AND ONE CHILD WINDOW
	
	// The below solution is applicable only when
	// there is a property called TARGET = __BLANK
	// in the HTML DOM of the element(s) after
	// clicking which the window(s) are opening.
	
	// Whether a window pop-up opens in a NEW TAB of the SAME BROWSER
	// or a SEPARATE NEW WINDOW itself, handling of the in both the
	// cases will remain same in Selenium. Meaning, there will not
	// be any change in the steps of handling the windows.
	
	// Whenever you open a new window pop-up using selenium
	// the control remains on the parent (the window from
	// which the new window pop-up was opened).
	
	// When the driver control is on the child/further window
	// and we close the child window the control is lost.
	// We have to switch the driver back to the parent window
	// or whatever is the previous window to perform further user actions on
	// them.
	
	// Whenever the driver is on any window and you want to close only that window,
	// then use close() method instead of quit() method.
	
	// Close method will close only the window in focus but quit method
	// will close all the opened windows.
	
	// (INTERVIEW) What is the meaning of target = "__blank" in the HTML code of
	// a hyperlink element?
	// Ans: The property ensures that the link MUST open in a new tab/window.
	// So, whenever the target = "__blank" is written it means the link
	// will open in a new tab/window.
	
	// GENERALLY, for if only 2 windows are opened one of them being main
	// window and other one is the child window and we store their handles/IDS
	// in a Set using GetWindowHandles method the 1st handle is always of
	// the parent/main window and the 2nd handle is of the child/further window

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver(); // blank browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // parent / very first window
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click(); // window2 OR tab2
		
		
		// Use window() method to switch to whatever window you want
		
		// Method 1: SWICTHING TO WINDOW USING WINDOW ID OR HANDLE
		
		// Get all opened windows' IDs
		Set<String> handles = driver.getWindowHandles();
		
		// (INTERVIEW-IMPORTANT) What is the difference between the GETWINDOWHANDLES and GETWINDOWHANDLE? 
		// Ans: - GetwindowHandles will return the IDs of all the windows opened till now whereas
		// Getwindowhandle will return the ID of the window which is in focus right now.
		
		// - Getwindowhandles will return a Set of string IDs of windows whereas Getwindowhandle will return a
		// string ID of the window
		
		// We generally use GetWindowHandles when there are multiple windows opened (Parent and child windows, even
		// if there are only 2 windows opened)
		// but we use GetWindowHandle only when there is one window opened.
		
		// (INTERVIEW) Why Selenium guys have returned Set of String in GetWindowHandles?
		// Ans: Because we want every window handle/ID to be UNIQUE and set only holds the unique
		// values.
		
		// Now, iterate the set using iterator.
		// NOTE: We will always use iterator to traverse non-order based collections
		
		Iterator<String> it =  handles.iterator(); // iterator will return an Object of type Iterator
		                    // that contains String elements i.e., Iterator<String>
	    String parentWindowID = it.next();
	    System.out.println("Parent window ID: "+parentWindowID);
	    String childWindowID = it.next();
	    System.out.println("Child window ID: "+childWindowID);
	    
	    // Switch to windows:
	    driver.switchTo().window(childWindowID);
	    System.out.println("Child window URL: "+driver.getCurrentUrl());
	    
	    // close the child window:
	    driver.close(); // At this point the driver is lost
	    
	    Thread.sleep(1500);
	    
	    // switch to parent window again:
	    driver.switchTo().window(parentWindowID);
	    System.out.println("Parent window URL: "+driver.getCurrentUrl());
	    
	    driver.quit();
	    
	    // (INTERVIEW): What happens when we try to interact with the parent window
	    // directly when the driver is on the child window and user closes the
	    // child window using close method ?
	    
	    // Ans: If we try to fetch a parent/previous window URL after closing a child window
	    // without actually switching to the previous window then we
	    // will get NoSuchWindowException : target window already closed.		
//	    driver.switchTo().window(null);
	}

}
