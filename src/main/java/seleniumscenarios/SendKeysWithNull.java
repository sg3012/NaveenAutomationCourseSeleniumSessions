package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysWithNull {

	// (INTERVIEW)
	// This class explains how we can enter a
	// 'null' value using sendKeys() function in
	// Selenium and how we will handle it,
	// how we will enter blank string and handle it.

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart" + 
		"/index.php?route=account/register");

		By firstName = By.id("input-firstname");
		
		// Passing a String null:
		// driver.findElement(firstName).sendKeys("null"); // This will enter null 
		// as a string value in the text field just fine.
		
		// Passing actual null value:
        // driver.findElement(firstName).sendKeys(null); //IllegalArgumentException
        // Keys to send should be a not null CharSequence
        // So to prevent this exeption we will restrict
        // the Generic doSendKeys() utility function
        // created to not allow the null values (See ElementUtil.java)
           
        // Passing blank string value:
        // driver.findElement(firstName).sendKeys(""); // It will enter
        // nothing in the text field (Blank String) but it will not 
        // throw any exception also. So, we should not prevent this.
           
        // Passing blank space string value:
        // driver.findElement(firstName).sendKeys(" "); // It will enter
        // blank space in the text field but it will not 
        // throw any exception also. So, we should not prevent this.
		
		// Passing numeric value:
        // driver.findElement(firstName).sendKeys(123);// Compilation
        // error, not applicable for the argument int.  
		
		// Passing String numeric value:
		// driver.findElement(firstName).sendKeys("123"); // It
		// will enter the string numeric value  
		
		// (INTERVIEW QUESTION - IMPORTANT)
		// The parameter of sendKeys() method is CharacterSequence
		// but it still takes String, StringBuilder, StringBuffer is an argument ? Why?
		// Ans: It is because the CharacterSequence is an interface in JAVA
		// which is the parent interface of String, StringBuilder, StringBuffer classes.
		// So, we can pass all of the 3 classes' type of variable in the 
		// sendKeys() method.
		
		String str = "Test";
		StringBuilder sb = new StringBuilder("Automation");
		StringBuffer sf = new StringBuffer("Selenium");
		
		// We can pass the String, StringBuilder, StringBuffer
	    // type of parameter to sendKeys() method in the following ways:
		
		// Passing using plus concatenation operator-
		// driver.findElement(firstName).sendKeys(str+sb+sf);
		
		// Passing using plus concatenation operator and blank space
		// as a separator-
		// driver.findElement(firstName).sendKeys(str+" "+sb+" "+sf);
		
		// Passing the class type variables separately one by one:
		// driver.findElement(firstName).sendKeys(str);
		// driver.findElement(firstName).sendKeys(sb);
		// driver.findElement(firstName).sendKeys(sf);
		
		// Passing the class type variables separated by comma:
		driver.findElement(firstName).sendKeys(str, sb, sf);
	}
	
	// (INTERVIEW) What will happen if we try to pass null
	// as the parameter of sendKeys() function?
    // Ans: We will get illegalArgumentException. And to handle that
	// we need to restrict the generic sendkeys() utility function
	// to take the null values.

}
