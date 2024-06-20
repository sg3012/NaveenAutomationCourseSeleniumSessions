package seleniumscenarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {
	
	// This class explains how do we apply implicit wait
	// mechanism in our automation scripts.
	
	// We generally apply implicit and its also recommended
	// to apply the implicit wait just after the driver initialization.
	
	// Implicit wait is also called GLOBAL WAIT. Meaning, if
	// you locate and create any webelement after applying this wait
	// the wait duration will be applicable to every findelement statement
	// post the wait initialization.
	
	// So, if we have applied implicit wait of 10 seconds then script will wait
	// for 10 seconds for every element which doesn't appear immediately after page load,
	// at every findelement statement. 

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // This 
		// implicitlyWait(Long time, TimeUnit timeUnit) is part of selenium 3.x which
		// is now deprecated in selenium 4.x. So, its not recommended to use
		// this version any more. Use the following version instead with
		// the Duration class type reference variable as parameter
		
		// Let's say on some app login page is fast, below 
		// is the implicit timeout of 10 seconds for login page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Login page element 1 (e1):
		driver.findElement(By.name("username")).sendKeys("admin");
		
		// Let's say we have 4 more elements on login page as below:
		// e2 // timeout/implicit wait of 10 secs, irrespective whether element appears before or after 10 secs.
		// e3 // timeout/implicit wait of 10 secs, irrespective whether element appears before or after 10 secs.
		// e4 // timeout/implicit wait of 10 secs, irrespective whether element appears before or after 10 secs.
		// e100 // timeout/implicit wait of 10 secs, irrespective whether element appears before or after 10 secs.
		
		
		// For homepage the wait time will still be of 10 secs only and not 20 secs.
		// So, as the elements are loading in time more than the implicit wait
		// then we will get nosuchelementexception.
		// So, before landing to the home page we will override/change
		// the wait time to, say 20 secs like below:
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// HOME PAGE
		// On the same app, home page is a bit slow and elements are loading in 20 secs.
		// Let's say following are the elements on the home page
		// he1 - 20 secs
		// he2 - 20 secs
		// he10
		// logout
		
		// After logout coming back to login page. But 
		// as timeout/wait time is changed to 20 secs
		// the latest updated value of 
		// implicit wait time will be taken into consideration now i.e., 20 secs.
		
		// But on login page we want 10 secs wait. So, we will again override the wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// LOGIN PAGE:
		// e2 - 10 sec
	    // e3 - 10 sec
	    // e4 - 10 sec
		// e100 - 10 sec
		
		// Now, if we come to Registration page it takes no time (0 wait) to load elements.
		// So we will have to change the implicit wait on Reg page to 0 (like below) which is called
		// NULLIFICATION OF WAIT.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		// So, if we require different wait times for different elements on different
		// pages then we will have to overwrite the implicit wait every time, which is not
		// GOOD PRACTICE. 
		
	    
		// What we should do is wait for only those elements
		// which are not appearing instantly i.e, have some wait time.
		// We could achieve this goal by using EXPLICIT WAIT technique.
		
		// SO if username requires 10 secs we will apply 10 secs,
		// if pwd requires 5 secs we will apply 5 secs, if 
		// login requires 20 secs we will apply that, if
		// there is some element which requires 0 wait
		// then we will apply 0 for that.
		
		// [INTERVIEW] Let's say the implicit wait time is defined as 
		// 10 seconds on a page and an element is getting loaded in
		// 5 seconds. Now, within the 5 seconds of wait time
		// other elements are also get loaded along with the delayed element.
		// So, the wait time for other elements will be 0 as implicit wait
		// will be ignored as it is dynamic wait. Then what is the issue
		// with Implicit wait in our code if it is ignored if element(s)
		// are already there on the page ?
		
		// Ans: The issue is whether the wait is ignored or not
		// every element creation statement i.e, findelement statement
		// written after defined implicit wait is going to check 
		// what is the wait time for an element
		// we are going to find, if we have used implicit wait 
		// in our code. In short, if implicit wait is defined then
		// every findelement statement is going to check what is the wait
		// time irrespective of wait is ignored or not. So, we have to save that
		// checking time.
		
		// ANOTHER PROBLEM WITH IMPLICIT WAIT is that it doesn't
		// work for NON-WEB ELEMENTS like title, URL, alerts etc.
		// Let's say on an ecommerce an alert is coming for purchasing an
		// item after 5 seconds. So we cannot wait for the alert
		// to come using IMPLICIT WAIT as alerts are not supported.
		// So we have to use EXPLICIT WAIT IN THAT CASE.
		
		
		
		
		
	}

}
