package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCssSelectorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login/beta");
		Thread.sleep(4000);
		
		// CSS SYNTAX
		
		//1.For IDs 
		// WITHOUT TAG NAME --> #<id-value> (# for IDs)
		// WITH TAG NAME --> htmltag#<id-value> (# for IDs)
		
		// E.g.1: input#input-email --> CssSelector for the 
		// email fields with id as input-email on the login form of 
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login
		// PAGE
		By.cssSelector("input#input-email");	
		
		//2.For Classes
		
		// SINGLE CLASSES IN THE HTML CODE:
		// WITHOUT TAG NAME --> .<classname> (. for classes)
		
	    // WITH TAG NAME --> htmltag.<classname> (. for classes) 
		
		// E.g.1: input.form-control --> CssSelector for the 
		// all the input fields with form-control class on the login form of 
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login
		// PAGE
		By.cssSelector("input.form-control");
		
		// MULTIPLE CLASSES IN THE HTML CODE:
		// We have classes like c1 c2 c3 c4.......cn
		// WITHOUT TAG NAME --> .c1.c2.c3......cn
		// E.g1: .form-control.private-form__control.login-email --> CssSelector
		// for the email field on the login form of
		// https://app.hubspot.com/login/beta -- PAGE
		
	    // WITH TAG NAME --> tag.c1.c2.c3.....cn
		// E.g1: input.form-control.private-form__control.login-email --> CssSelector
		// for the email field on the login form of
		// https://app.hubspot.com/login/beta -- PAGE
		
		// NOTE: 
		// We can also skip some classes if we have multiple classes for an element
		// in the HTML, in the CssSelector(see below E.g1)
		
		// We can also change the sequence of the classes as they are appearing the HTML
		// code of the element, in the CssSelector (see below E.g2)
		
		// E.g1: input.form-control.login-email (skipped the class "private-form__control")
		// E.g1: input.private-form__control.form-control.login-email (sequence changed between
		// the classes "private-form__control" and "form-control")
		
		//3. For IDs and Classes Combo
		// WITHOUT TAG NAME:
		// #id.class or .class#id
		// E.g1 : #username.login-email or .login-email#username --> CssSelector
		// for the email field on the login form of
		// https://app.hubspot.com/login/beta PAGE
		
		// E.g2 (MULTIPLE CLASSES): .form-control.private-form__control.login-email#username --> CssSelector
		// for the email field on the login form of
		// https://app.hubspot.com/login/beta PAGE
		
		// WITH TAG NAME:
		// tag#id.class or tag.class#id 
		// E.g1: input#username.form-control.private-form__control.login-email OR
		// input.form-control.private-form__control.login-email#username OR
		// input.login-email#username.form-control.private-form__control  --> CssSelector
		// for the email field on the login form of
		// https://app.hubspot.com/login/beta PAGE
		
		// 4. FOR OTHER ATTRIBUTES BUT USING ONLY SINGLE ATTRIBUTE:
		// tagname[attributename = 'value'] 
		
		// E.g1: input[placeholder='E-Mail Address'] --> CSSSelector
		// for the email field on the login page of
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// NOTE: Forward slashes are not part of the CSSSelector above. They are just
		// used for comments.
		
		// 5. FOR OTHER ATTRIBUTES BUT USING MULTIPLE ATTRIBUTES:
		// tagname[attributename_1 = 'value'][attributename_2 = 'value'].....[attributename_n = 'value']
		
		// E.g1: input[placeholder='E-Mail Address'][name='email'][type='text'] --> CSSSelector
		// for the email field on the login page of
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// E.g2(WITHOUT ACTUALLY USING THE VALUES OF ATTRIBUTES): 
		// input[placeholder][name][type] --> CSSSelector
		// for the email field on the login page of
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// E.g3 (INTERVIEW QUESTION): Find out all the elements 
		// on a webpage having the attribute ID without
		// writing a single line of selenium code ?
		
		// Ans: USING CSS - [id] -- CSSSelector to find all the elements 
		// having attribute 'id' associated with them
		// on on the login page of	
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// USING Xpath : //*[@id] -- Meaning, select all the elements
		// in the DOM which have ID attribute and any HTML tag.
		// Again on the on the login page of	
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// 6. text() - NOT AVAILABLE IN CssSelectors from CSS V3.0 onwards
		// and it's the BIGGEST LIMITATION OF Css
		// which xpaths overcome. So, in the cases where
		// no attribute for a particular element is filtering
		// the right results OR there is ONLY TEXT AVAILABLE FOR THAT ELEMENT, 
		// we can directly use text of the element
		// using XPATH but we cannot achieve the same thing through Css
		// and we may have to create more complex Css.
		
		// 7. contains in CSS:
		// Syntax - tagname[attribute*='value']  (* symbol for contains)
		
		// E.g1 : input[placeholder*='Address'] --> CSSSelector
		// for the email field on the login page of
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// 8. starts-with in CSS:
		// Syntax - tagname[attribute^='value'] (^ symbol for starts-with)
		
		// E.g1: input[placeholder^='E-Mail']  --> CSSSelector
		// for the email field on the login page of
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// We also have a similar function in Xpath for starts with:
		// Syntax: //tagname[starts-with(@attribute, 'value')]
		
		// E.g: //input[starts-with(@placeholder, 'E-Mail')]
		
		// 9. ends-with in CSS:
		// Syntax - tagname[attribute$='value'] ($ symbol for starts-with)
		
		// E.g1: input[placeholder$='Address'] --> CSSSelector
		// for the email field on the login page of
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// WE DON'T have a function named ENDS-WITH in xpath as it has been removed 
		// from xpath from all the modern Browsers
		
		//SYNTAX: //tagname[starts-with(@attribute, 'value')] -- NOT AVAILABLE IN XPATH
		
		//10. COMBINE CONTAINS, STARTS-WITH, ENDS-WITH:
		// E.g1: input[placeholder*='Address'][id^='input'][class$='control'] --> CSSSelector
		// for the email field on the login page of
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		//E.g2 (Using # for ID): input[placeholder*='Address'][class$='control']#input-email
		
		// 11. Parent to child:
		// For DIRECT CHILD-
		// E.g1: select#Form_getForm_Country > option (> bracket for immediate child) --> CSSSelector
		// for the country drop-down's option tags on the
		// https://www.orangehrm.com/en/30-day-free-trial PAGE
		
		// E.g2: form > div --> CSSSelector
		// for all the children elements under the email address field on the
		// https://app.hubspot.com/login/beta PAGE
		
		// For DIRECT + INDIRECT CHILD-
		// We use BLANK SPACES from a node in the Css Selectors to reach to
		// all the child, grand children nodes 
		// E.g1: select#Form_getForm_Country option --> CSSSelector
		// for the country drop-down on the
		// https://www.orangehrm.com/en/30-day-free-trial PAGE
		
		// E.g2: form div --> CSSSelector
		// for all the children and grand children elements under email address field on the
		// https://app.hubspot.com/login/beta PAGE
		
		// E.g3: table#resultTable td --> CSSSelector
		// for all the children and grand children elements having tag td 
		// under the node table#resultTable on
		// https://app.hubspot.com/login/beta PAGE
		
		// 12. CHILD TO PARENT/GRANDPARENT/ANCESTOR - NOT AVAILABLE IN CssSelectors 
		// This is again a LIMITATION WITH CSS that BACKWARD TRAVERSING
		// is not there
		
		// 13. PRECEDING SINBLING - NOT AVAILABLE IN CssSelectors 
		// This is again a LIMITATION WITH CSS that BACKWARD TRAVERSING
		// is not there
		
		//14. FOLLOWING SIBLING
		// SYNTAX (FOR IMMEDIATE FOLLOWING SIBLING) : 
		// tagname[@attribute = 'value'] + tagname[@attribute = 'value'] (+ used to represent
		// IMMEDIATE following sibling) 
		
		// SYNTAX (FOR ALL THE FOLLOWING SIBLINGS) : 
		// tagname[@attribute = 'value'] ~ tagname[@attribute = 'value'] (~(tilde) used to represent
		// ALL following sibling) 
		
		// E.g1 (IMMEDIATE FOLLOWING SIBLING: label[for='input-email'] + input --> CssSelector for 
		// reaching the immediate following input sibling node from the node
		// label[for='input-email'] on 
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// E.g2 (ALL THE FOLLOWING SIBLINGS): label[for='input-email'] ~ input --> CssSelector for 
		// reaching all the following input sibling nodes from the node
		// label[for='input-email'] on 
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login PAGE
		
		// 15. INDEXING CONCEPT IN CSS:
		
		// FIRST CHILD - to point to the immediate or the first child of a node
		// SYNTAX : tagname[@attr = 'val']:first-child
		
		// E.g1: select#Form_getForm_Country option:first-child --> CSSSelector
		// for the first <option> child tag node from the "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// LAST CHILD - to point to the last child of a node
		// SYNTAX : tagname[@attr = 'val']:last-child
		
		// E.g1: select#Form_getForm_Country option:last-child --> CSSSelector
		// for the last <option> child tag node from the "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// NTH-CHILD - to point to a specific child of a node apart from first and last children.
		// SYNTAX : tagname[@attr = 'val']:nth-child(<childNumber- In Integer>)
		
		// E.g1: select#Form_getForm_Country option:nth-child(5) --> CSSSelector
		// for the 5th <option> child tag node from the "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// NTH-LAST-CHILD - to point to a specific child of a node, starting from it's last child 
		// SYNTAX : tagname[@attr ='val']:nth-last-child(<childNumber- In Integer>)
				
		// E.g1: select#Form_getForm_Country option:nth-last-child(2) --> CSSSelector
		// for the 2ND LAST <option> child tag node from the "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// NTH-ODD-CHILD - to point to all the ODD child nodes of a node like 1,3,5 etc.
		// SYNTAX : tagname[@attr ='val']:nth-child(odd)
		
		// E.g1: select#Form_getForm_Country option:nth-child(odd) --> CSSSelector
		// for all the ODD <option> child tag nodes from the "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// NTH-EVEN-CHILD - to point to all the EVEN child nodes of a node like 2,4,6 etc.
		// SYNTAX : tagname[@attr ='val']:nth-child(even)
				
		// E.g1: select#Form_getForm_Country option:nth-child(even) --> CSSSelector
		// for all the EVEN <option> child tag nodes from the "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// NTH-ALL-CHILDREN - to point to all the child nodes of a node
	    // SYNTAX : tagname[@attr ='val']:nth-child(n)
		
		// E.g1: select#Form_getForm_Country option:nth-child(n) --> CSSSelector
		// for all the <option> child tag nodes from the "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// TRAVERSING CHILD NODES FROM A POSITION - to start traversing from a particular
		// child node of a node
		// SYNTAX : tagname[@attr ='val']:nth-child(n+<numberofchildtostart>)
		
		// E.g1: select#Form_getForm_Country option:nth-child(n+4) --> CSSSelector
		// to start traversing from the 4th <option> child tag node from the 
		// "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// TRAVERSING CHILD NODES IN MULTIPLES -- to traverse all child nodes of a node
		// in multiples of a number like visit every 4th child node, every 5th child node etc.
		// SYNTAX : tagname[@attr ='val']:nth-child(<multiple-number>n)
		
		// E.g1: select#Form_getForm_Country option:nth-child(4n) --> CSSSelector
		// to visit <option> child tag nodes in multiples of 4 from the 
		// "select#Form_getForm_Country option"
		// node on https://www.orangehrm.com/en/30-day-free-trial PAGE 
		
		// 16. Negation in CSS: Used to point to the elements which are not included
		// as part of current Cssselectors
		// SYNTAX: tagname[@attr='val']:not([@attr='val'])
		
	    // E.g1: input.form-control:not(.input-lg) -- CssSelector
		// for all the input elements having class form-control (search, email, password fields)
		// but not the class input-lg (password and email fields) on
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login page
		
		// If we want to use multiple not operators then we have to keep using them
		// repeatedly separated by colons(:) like - :not(<property-of-element>):not(<property-of-element>):not(<property-of-element>)
		// and so on.
		
		// 17. Comma in CSS: Used to combine a collections of elements in one CssSelector
		// in single shot
		
		// USE CASE: Let's say on a web page we want certain elements
		// to be present on the page always whenever we open that page
		// as part of quick SANITY CHECK.
		
		// ADAVANTGE of using comma is that we can collect multiple similar or different types of elements
		// on a web page in a single locator only, we don't need to create separate locators
		// for it.
		
		// E.g.1: input#username, button#loginBtn, input#remember, div.signup-link
		// CssSelector to collect email field, next button, remember check-box,
		// signup link on the https://app.hubspot.com/login/beta PAGE
		// in a SINGLE SHOT.
		
		By impElements = By.cssSelector("input#username, button#loginBtn, "
				+ "input#remember, div.signup-link"); // 4 elements, one locator
		
		if(driver.findElements(impElements).size() == 4) {
			System.out.println("Imp eles present on the page... PASS");
		}
		else {
			System.out.println("Imp eles not present on the page... FAIL");
		}
		
		// LIMITATIONS OF CssSelectors:
		
		// CssSelectors don't have TEXT() function like feature. So for the elements
		// that only have text as a unique identifier, it will be very difficult to
		// handle those elements.
		
		// CssSelectors don't have BACKWARD TRAVERSING feature available inside DOM.
		// Due to which we couldn't go from child to parent or any grand parent
		// and to preceding-sibling of a node. So, due to lack of this feature
		// it will be very difficult to handle complex Web table scenarios.
		
		// NOTE:
		// We only need to use square brackets while writing CssSelectors when use 
		// attributes other than ID and Class or if we want to write
		// Class and Id attribute names explicitly.
		// If we want to construct Css using only Ids and classes then we don't
		// need to use square brackets, just use # and . for Ids and classes
		// respectively.
		
		// XPATH VS CSS COMPARISION:
		
		
		                  //xpath       vs        css: 
		//1. syntax:      complex                 simple
		//2. text():      yes                     no
		//3. AND:         Yes                	  Yes
		//4. OR:          Yes                     Yes , comma
		//5. forwards:     Yes                    Yes
		//6. backwards:    yes                    no
		//7. forward sibling : Yes                yes
		//8. backward sibling : Yes                no
		//9. not:           Yes                   Yes
		//10. index:         Yes                   Yes
		//11. capture grp:   Yes                   no
		//12. performance:   Good                  Good
		//13. starts-with:   Yes                   Yes
		//14. contains:      Yes                   Yes
		//15. ends-with:     no                    Yes
		//16. webtable:      easy                  limited
	}

}
