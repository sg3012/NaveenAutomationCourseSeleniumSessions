package seleniumscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthPopup {
	
	// This class explains how to handle
	// Basic Auth pop-ups on a web page
	// (like the ones you see when you 
	// configure your Wifi router/modem
	// credentials etc) 
	
	// Basic Auth pop-ups are implemented to authenticate a user
	// with correct credentials before he/she accesses a web application.

	public static void main(String[] args) {
		String username = "admin";
		String password = "admin";
		
		WebDriver driver = new ChromeDriver();
//	    driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		// Now, If we enter just the URL in the get method as shown above
		// it will show us the authentication pop-up and Selenium
		// DOES NOT have a capability to take control of the pop-up
		// and enter username and password from the UI DIRECTLY
		
		// So, How do authenticate using Basic auth then ?
		// Ans: There is a WORKAROUND (NOT PAR OF SELENIUM) i.e,
		// we can PASS the actual username and password DIRECTLY as part of the URL
		// (as shown below).
		// By doing this the auth pop-up will not be displayed and 
		// user will be logged in directly, if creds are correct.
		
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		// Here, admin and admin are the username and the password followed by @ symbol.
		// So, the syntax would be : username:password@
		
		// Using WORKAROUND Without hard-coded credentials:
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		
		// INTERVIEW QUESTION (IMPORTANT): What is Basic Auth ? How does it work internally?
		// Ans: The auth pop-ups which come when there is no login page is implemented
		// explicitly to authenticate the users are called Basic Authentication pop-ups.
		// When you supply user name and password in these pop-ups as plain
		// text it will combine both user name and password text
		// and convert them into an encoded string/text using 
		// a method called btoa() method.
		// BtoA is a JS function which takes 2 string args (as user name and password respectively)
		// in following SYNTAX:
		
		// btoa("user name:password"); ---> @#@#^NJNBJHBHJVBHBJG====--(ENCODED USSERNAME, PASSWORD STRING)
		// NOTE: The username and password should be passed as a single string (enclosed in a single pair
		// of quotes or double quotes) separated by colon.
		
		// LIMITATIONS OF THE ABOVE WORKAROUND:
		// 1. If you have @ symbol in your username and password strings
		// then you cannot use them in the URL as part of this method
		// because URL allows allows ONLY ONE @ symbol and you cannot
		// use the @ in your username or password because @ MUST be used
		// in the syntax of this workaround.
		
	}

}
