package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.log.model.ViolationSetting.Name;

public class DifferentLocators {
	
	// This class explains different locators (apart from ID)
	// in Selenium to locate web elements on a web page.
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		// How many locators are there in Selenium ?
		// Ans: 8 locators. Following are the ones:
		// 1. ID - IDs should always be unique for every element on a web page according to
		// the W3C guidelines. But there are some cases where devs may have created
		// repeated IDs for different elements (which is not recommended).
		// ele1 -- naveen
		// ele2 -- selenium
		// driver.findElement(By.id("naveen")).sendKeys("naveen@gmail.com");
		
		// 2. Name - Not always unique, it may be duplicate. But it is unique in most of the cases.
		// ele1 -- naveen
		// ele2 -- naveen
		// ele3 -- naveen
		// driver.findElement(By.name("naveen")).sendKeys("naveen@gmail.com");
		
		// 3. Class Name - Most of the times it is duplicate only. 
		// May be unique in some cases. 
		// driver.findElement(By.className("form-control")).sendKeys("naveen");
		
		// 4. Xpath - It is not an HTML attribute. It is basically address of an element in the DOM.
		// Full form is XML path.
//		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("naveen");
//		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("automation");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@123");
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
//		By fn_xpath = By.xpath("//*[@id=\"input-firstname\"]");
//		By ln_xpath = By.xpath("//*[@id=\"input-lastname\"]");
//		By password_xpath = By.xpath("//*[@id=\"input-password\"]");
//		By privacyPolicy_name = By.name("agree");
//		By continue_xpath = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
//		
//		doSendKeys(fn_xpath, "Shubham");
//		doSendKeys(ln_xpath, "Selenium");
//		doSendKeys(password_xpath, "Test@123");
//		doClick(privacyPolicy_name);
//		doClick(continue_xpath);
		
		// 5. CSS SELECTOR:
		// It is not an attribute, instead it is kind of an attribute
//		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Shubham@gmail.com");
//		driver.findElement(By.cssSelector("#input-telephone")).sendKeys("9998888989");
//		driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary")).click();
		
		// 6. LinkText:
		// It is used only for links on a web page that have anchor (<a>) tag, 
		// using their text
		// REMEMBER : It can ONLY be used for the links created using </a> tag
		// for other link tags it will NOT work.
		// Link text locators may be duplicate
		
//		driver.findElement(By.linkText("login page")).click();
//		By loginPageLink = By.linkText("login page");
//		doClick(loginPageLink);
		
		//7. Partial Link Text:
		// It is used only for links on a web page that have anchor (<a>) tag, 
		// using some part of their text
		// This method or locator is not recommended to use because
		// if there are multiple links with the same partial text it may or may not click
		// the intended element.
		// It is used on a page where there is a link having a very long text, which is
		// a rare case. 
		// So, partial link text is used rarely in real time projects.
//		driver.findElement(By.partialLinkText("Forgot")).click();
		
		//8. TAG NAME:
		// Tag name means HTML tag name.
		// This locator is used where there are some web elements for which
		// only HTML tag is defined with some text and the tag is UNIQUE also
		// like Heading of a page with <h1> tag.
		String header = driver.findElement(By.tagName("h1")).getText();
		System.out.println(header);
		
		
		// NOTE: When there are multiple web elements with the same attribute value in the DOM
		// Selenium will interact with whatever is the first element occurred while traversing
		// the DOM. Earlier, Selenium used to give the error "Multiple elements found with the same name"
		// for the such cases but it has changed the functionality now from couple of years.
		
		
		// (INTERVIEW) : Between xpath and Id what will you prefer?
		// Ans : If IDs are unique and considerable then we will go with the IDs. So, the preference
		// is the ID
		
		// (INTERVIEW) : Between Id, name and class what will you prefer?
	    // Ans : If IDs are unique and considerable then we will go with the IDs. So, the preference
	   // is the ID. If not then we will go with the name. But if name is also not unique then we will
	   // go with the class name. If all of the 3 are not considerable then we will go with the xpath.
		
//		LOCATOR PREFERENCE:
//		ID > NAME > CLASS > XPATH
		
		// (INTERVIEW IMPORTANT) : Between xpath and CSS selector which one would you prefer ? Which is better ?
		// ANS : Both are very good locator choices and have their unique properties. There are some
		// cases where xpath is better and in some cases css is better. So, it depends on the USE CASE
		// which locator to use. There should not be any comparison between these 2 locators.
		
		// (INTERVIEW) : Between link text and partial link text which one would you prefer?
		// Ans: Link text as it works on the complete text. So, the chances of failure
		// are less as compare to Partial link text.
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

}
