package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login/beta");

		// xpath : Address of the element in the HTML DOM
		// 2 Types of xpath:
		// Absolute xpath : Complete path of the desired element starting from the root node in the HTML DOM.
		// Relative xpath : Path relative to the required element. It is constructed using some of 
		// the properties of the element which are unique less likely to fail in future. These are created
		// using HTML attributes of the element, xpath functions etc.
		
		// Basic formula for creating xpath: 
		
		// Xpath creation with single attribute: //htmltag[@attributename1 = 'attributevalue']
		
		//input[@name='username'] - Username field
		//button[@type='submit'] - Login button
		//input[@id='input-firstname'] - First name input
		
		//input[@placeholder='Username']
		
		// Xpath creation with more than one attribute: //htmltag[@attr1 = 'attributevalue' and @attr2 = 'attributevalue']
		
		//input[@name = 'username' and @placeholder = 'Username']
		//input[@name = 'username' and @placeholder = 'Username' and @class='oxd-input oxd-input--active']
		
		// Xpath creation with multiple attributes but no values-
		//htmltag[@attr1 and @attr2 and @attr3 and @attr4 and so on...without using attribute values]
		
		//input[@class and @name and @placeholder]
		//input[@class='form-control private-form__control login-email']
		
		
		// Whenever you are using xpath with classname to find an element
		// we have to pass all the class names for that element but when
		// we are using classname function of Selenium then we can pass
		// any one of the classes for that element (But the class name should be
		// unique only for that element ).
		
//		By e1 = By.xpath("//input[@class='form-control private-form__control login-email']"); // valid locator
//		By e2 = By.className("login-email"); // valid locator, any of the classes can be used.
		By e3 = By.className("form-control private-form__control login-email"); // not valid locator
		// because with classname function we can only provide single class name as the parameter
		// JVM will throw "InvalidSelectorException : Compound class names" not permitted
		By e4 = By.xpath("//input[contains(@class, 'login-email')]"); // valid, we can use any
		// of the classes with contains function
		By e5 = By.xpath("//input[@class='login-email']"); // Invalid
		// we MUST use all of the classes if we are using class
		// attribute in the xpath.
		
		// (IMPORTANT):
		// SO, IF WE ARE USING class AS ATTRIBUTE in the xpath then we MUST provide
		// all of the class names for that web element BUT if we are using className
	    // function then we MUST use any ONE of the class names for that element as classname
		// function takes only one class name.
		
//		driver.findElement(e1).sendKeys("test@gmail.com");
//		driver.findElement(e2).sendKeys("test@gmail.com");
		driver.findElement(e3).sendKeys("test@gmail.com"); // control will no come to this line
		// and JVM will throw InvalidSelectorException at the line where
		// e3 locator is declared itself.
		
		// CONTAINS():
		// syntax : htmltag[contains(@attrname, 'attrvalue')]
		//input[contains(@data-test-id, 'email-input')] - email field
		//input[contains(@data-test-id, 'field')] - email field
		//input[contains(@class, 'email')]
		//input[contains(@class, 'login-email')]
		
		// USE CASES WHERE WE WILL USE CONTAINS IN XPATH
		// where attribute values are long
		// when some part of attribute values are dynamic but some part of it is constant.
		
		
		// CONTAINS with attr1 and attr2 WITHOUT CONTAINS():
		// syntax : htmltag[contains(@attr1_name, 'attr1_value') and @attr2_name = 'attr2_value']
		//input[contains(@data-test-id, 'email-input') and @type = 'email']
		//input[contains(@data-test-id, 'email-input') and @type = 'email' and @id='username']
		
		// TEXT() IN XPATH:
		// Syntax : htmltag[text()='attrvalue')]
		//h1[text()='Register Account']
		//span[text()='Trusted by 60,000+ businesses of all sizes']
		
		// Note: We are going to use text function in the cases where
		// the elements don't have any attribute associated with them
		// They just have a plain text written in the form of <p> tag
		// or text directly written on them etc. or we cannot use the
		// attributes associated because they don't give any uniqueness
		// to the element.
		
		
		// Contains() + text() combination:
		// Syntax : //htmltag[contains(text(),'<text-value>')]
		//span[contains(text(),'60,000+ businesses of all sizes')]
		
		// Note: We use contains + text combination where we want to locate
		// an element with some of it's text (partial text) because it has a long
		// text written on it.
		
		//text() + attribute combination:
		// Syntax: //htmltag[text()='value' and @attributename='value']
		//a[text()='Login' and @class='list-group-item']
		
		// text() with contains, attribute with contains and attr without contains:
		// Syntax: //htmltag[contains(text(), 'value') and contains(@attr1, 'attrvalue') and @attr2 = 'value']
		//a[contains(text(), 'Address') and contains(@href, 'route=account/address') and @class = 'list-group-item']
		
		
		// NOTE: We can only use text() function in xpath if there are NO BLANK SPACES
		// before and after the element's text which we are trying to locate.
		// Otherwise, we can't use text function. If we have blank spaces
		// we will use contains + text combination to locate the element
		// because contains() also captures the blank spaces
		
		// Index/position and CAPTURE GROUPS in Xpath:
		
		// 1. The concept of indexing is used in xpath creation where
		// there are more than 1 elements for an xpath expression.
		
		// 2. To find a single element for such xpaths we will first create the 
		// xpath, then we will store that xpath in a  capture group using
		// Parenthesis to get the collection of similar kind of elements represented
		// by that xpath, then we will apply the index on that capture group
		// to find an element at a particular position in square brackets. So, if an element
		// is at 4th position we will apply index 4 on the capture group.
		
		// 3. Capture groups in xpaths are a kind of expression which depict
		// a collection of similar kind of elements shown bu that xpath. The capture
		// groups are represented by parenthesis ().
		
		// 4. The indices in xpaths always start with 1 and then 2, 3, 4 and so on, unlike
		// JAVA where indices start with 0.
		
		// Following is the SYNTAX to create xpaths using Capture groups and indices combination:
		
		// SYNTAX : (// htmltag[@attr = 'value'])[<index-value>]
		// (//input[@class='form-control'])[1]
		
		By.xpath("(//input[@class='form-control'])[1]");
		
		// If we don't want to provide the hardcoded index value directly
		// then we can also use the position function like this:
		
		// SYNTAX : (// htmltag[@attr = 'value'])[position() = <index-value>]
		// (//input[@class='form-control'])[position=1]
		
		// But both approaches of passing index value are risk based as we are using
		// index to find the element.
		
		// So, if we don't want to pass the index value on a capture group directly
		// then we could use a method called last() to point to the last element
		// in that capture group like this:
		
		// SYNTAX: (// htmltag[@attr = 'value'])[last()]
		// (//input[@class='form-control'])[last()] - this xpath will point to the last element in
		// the capture group.
		
		// Similarly, if we want to point the elements apart from the last position
		// then we will subtract that position value from the last() function
		// at which the element is located. So, if element is at 1 position
		// above the last element we will subtract 1 from last() function and so on.
		
		// Here is the SYNTAX to point to the elements apart from the last one:
		
		// SYNTAX : (// htmltag[@attr = 'value'])[last() - <ref-position-at-which
		// -the desired-element-is-located-from-last-element>]
		
		// (//input[@class='form-control'])[last()-1] // -->  point to the second last element 
		// (//input[@class='form-control'])[last()-5] // --> point to the first element
		
		// or, we can also the following xpath to point to the first element
		// (//input[@class='form-control'])[last()-(last()-1)] // point to the first element
		// and this xpath will work in most of the cases.
		
		
		
		// (INTERVIEW - IMPORTANT)
		// How will you check that the "HELP" link
		// is available in the footer, in last column
		// and at the last position on the 
		// AMAZON.IN Home page?
		
		// Ans: We will make use of Capture groups with xpath to locate the desired element like this:
		
		// 1. First point to the last div in which the required help element is available 
		// using capture groups like this:
		// (//div[@class='navFooterLinkCol navAccessibility'])[last()]
		
		// 2. Then point to all the links in the div like this:
		// (//div[@class='navFooterLinkCol navAccessibility'])[last()]//a
		
		//3. The collect all the links in a another capture group like this:
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)
		
		// 4. Then point to the last element of this capture group
		// using last() function which will be the "help" link:
		
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()] --> For help link
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()] --> For link before Help link
		
		// PARENT TO CHILD IN XPATH:
		// single slash (/) : for DIRECT child --> SYNTAX : //parent/child
		// double slash (//) : for DIRECT + INDIRECT child --> SYNTAX : //parent//child
		
		// Creating xpaths using DIRECT child elements:
		//select[@id='Form_getForm_Country']/option
		
		// Creating xpaths using INDIRECT child elements:
		//div[@class='footer-main']//a
		//form//input[@id='username']
		
		// CHILD TO PARENT IN XPATH:
		
		// TO REACH THE DIRECT PARENT:
		// 1. 2 DOT notation (..) - to reach to the IMMEDIATE parent
		// SYNTAX : //child/..
		
		// (INTERVIEW QUESTION : How will you start from a particular
		// element in the DOM and reach to to the topmost
		// element TRAVERSING BACKWARDS?
		
		// Ans: We will keep using 2 dot notation starting from any element
		// until we reach the topmost element in the DOM.
		// E.g. : //input[@id='username']/../../../../../../../../../../../../../../../../..
		// Above xpath to start from the email address field of the login form 
		// on this page : https://app.hubspot.com/login/beta and reach to the top element
		// i.e., html tag for Document start.
		
		// 2. 'PARENT' xpath axes method - Again to reach the IMMEDIATE parent
		// SYNTAX : //child/parent::<htmltagname> 
		// E.g. : //input[@id='username']//parent::div --> start from the email address field of the login form 
		// on this page : https://app.hubspot.com/login/beta and reach to the
		// immediate parent div
		
		// NOTE: We generally use approach 2 to reach to the immediate parent element
		// as xpath is more readable in this approach.
		
		// TO REACH THE INDIRECT + DIRECT PARENT (GRAND PARENT, GREAT GRAND PARENT etc.)
		//1. using 'ANCESTOR' AXES Method - To reach any indirect parent
		// SYNTAX : //child//ancestor::<htmltagname>
		// E.g. : //input[@id='username']//ancestor::form --> start from the email address 
		// field of the login form on this page : https://app.hubspot.com/login/beta and reach to the
		// ancestor parent <form> under which this emaild address field is created.
		
		// E.g: //option[contains(text(),'Country')]//parent::select
		// To reach to the parent select tag and ensure that the default
		// value selected in the country drop-down is always 'Country'
		// on the page : https://www.orangehrm.com/en/30-day-free-trial
		
		// E.g. : //option[contains(text(),'Country')]
		//parent::select//ancestor::form//parent::div//..
		
		// To reach from the country drop-down on 
		// https://www.orangehrm.com/en/30-day-free-trial page to
		// it's immediate parent form, then to it's immediate parent div, 
		// then to it's immediate parent div.
		
		// NOTE: When we are traversing in BACKWARD direction (DOWN TO TOP)
		// in the DOM to reach the parent (direct + indirect) elements using XPATHS
		// use single slash for immediate parent.
				
		// Advantages of xpaths:
		
		// We can use any HTML attribute to create and find the element using xpath, if
		// id, class, name attributes are not available.
		
		// 
	}

}
