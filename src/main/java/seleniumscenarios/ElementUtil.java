package seleniumscenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import customexception.FrameWorkException;

public class ElementUtil {

	// This class provided some generic functions
	// to interact (perform user actions) on the
	// elements displayed on a web page like click,
	// sendKeys, drag and drop etc.

	private WebDriver driver;
	private Actions act;

	public ElementUtil(WebDriver driver) { // created constructor of this class
											// to supply the driver value
											// to the methods created below
		this.driver = driver;
		this.act = new Actions(driver);
	}

	// Generic function to find an element
	public WebElement getElement(By locator) {
		WebElement element = null;

		// Try-catch block to check if an element
		// is found by supplied locator or not.
		// If not the function will throw exception
		// else it will return required element.
		try {
			element = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("getting element exception...plz check your locator");
			e.printStackTrace();
			try {
				// Wait for the element for few seconds
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			// try for the element again
			element = driver.findElement(locator);
		}

		return element;
	}

	// Generic function to input string in any plain text fields
	public void doSendKeys(By locator, String keys) {
		// call the getElement function here
		// to stop the repetitive to calls to it
		// in the actual automation script.

		if (keys == null) {
			System.out.println("Value cannot be null while using sendKeys method");
			throw new FrameWorkException("VALUECANNOTBENULL");
		}
		getElement(locator).sendKeys(keys);
	}

	// Generic function to click on any webelement
	public void doClick(By locator) {
		getElement(locator).click();
	}

	// Generic function to fetch the text on a web element
	public String doElementGetText(By locator) {
		String eleText = getElement(locator).getText();
		System.out.println("Element text is ====> " + eleText);
		return eleText;
	}

	// Generic method to create web element using Link's text
	public WebElement getLinkElementByText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	// Generic method to check whether an element is displayed on a web page or not
	public boolean checkElementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	// Generic method to fetch and HTML element's attribute value
	public String getElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	// Generic function to check if a Web Element is disabled or not:
	public boolean checkElementIsDisabled(By locator) {
		String disabledValue = getElement(locator).getAttribute("disabled");
		if (disabledValue.equals("true")) {
			return true;
		}
		return false;
	}

	// Generic function to get a collection of web elements
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// Generic function to fetch count of a collection of elements
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	// Generic function to get a List of the text displayed on a list of web
	// elements (FOR SIMILAR KIND OF ELEMENTS ONLY)
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	// Generic function to get a List of any attribute value displayed for a list of
	// web
	// elements (FOR SIMILAR KIND OF ELEMENTS ONLY)
	public List<String> getElementsAttrList(By locator, String attr) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attr);
			if (!attrVal.isEmpty()) {
				eleAttrList.add(attrVal);
			}
		}
		return eleAttrList;
	}

	// Generic method to find all links on a page and click on the Desired Link
	public void clickOnLink(By locator, String linkText) {
		List<WebElement> linksList = getElements(locator);

		System.out.println("Total number of links:" + linksList.size());

		for (WebElement e : linksList) {

			String text = e.getText();

			System.out.println(text);

			if (text.equals(linkText)) {

				e.click();

				break; // this break is applied here because
						// once the Marathi link on the page is clicked,
						// the page will be refreshed and
						// selenium will not be able to find other link elements
						// and gives StaleElementReferenceException
			}
		}

	}

	// Generic function to search in any search box and click
	// on the desired link from the Suggestions list that is displayed
	public void doSearchAndClick(By searchlocator, By searchSuggLocator, String searchKeyword, String suggToClick)
			throws InterruptedException {
		doSendKeys(searchSuggLocator, searchKeyword);

		Thread.sleep(4000); // ALWAYS put wait after entering the search keyword
		// whenever you are automating
		// a search box and you have to click from the suggestions list.
		// But the suggestions are coming after a few seconds.

		List<WebElement> suggestionsList = getElements(searchSuggLocator);

		System.out.println(suggestionsList.size());

		for (WebElement e : suggestionsList) {
			String suggestionText = e.getText();
			System.out.println(suggestionText);
			if (suggestionText.contains(suggToClick)) {
				e.click();
				break;
			}
		}
	}

	// ************************* Drop Down Utils **************************//

	// Generic custom function to select a value from select drop-down using index
	// of the element
	public void doSelectDropdownByIndex(By locator, int index) {
		if (index < 0) {
			System.out.println("Pls pass the right (+ve) index");
			return; // only writing return in any code block and return type void
					// means the same in JAVA. Simply writing return means return nothing
					// i.e, void and come out of the function body
		}

		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	// Generic custom function to select a value from select drop-down using visible
	// text of the element
	public void doSelectDropdownByVisibleText(By locator, String visibleText) {
		if (visibleText == null) {
			System.out.println("Pls pass the right visible text and it cannot be null");
		}

		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	// Generic custom function to select a value from select drop-down using value
	// attribute of the element
	public void doSelectDropdownByValue(By locator, String valueAttr) {
		if (valueAttr == null) {
			System.out.println("Pls pass the right value of value attribute. It cannot be null");
		}

		Select select = new Select(getElement(locator));
		select.selectByValue(valueAttr);
	}

	// Generic function to get the count of values from a drop-down
	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	// Generic function to get all the actual values from a drop-down in a list
	public List<String> getDropdownTextList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsElementList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e : optionsElementList) {
			String optionValue = e.getText();
			System.out.println(optionValue);
			optionsTextList.add(optionValue);
		}
		return optionsTextList;
	}

	// Generic method to click any value in a drop-down but
	// WITHOUT using any select class methods
	public void doClickDropDownValue(By locator, String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

	// Generic method to click any value in a drop-down but
	// WITHOUT using the select class at all
	public void doClickDropDownValueUsingLocator(By locator, String dropDownValue) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

	// ************************** Actions Utils ***************************//

	// Generic method to right click on an item , open a context menu
	// and click on any of the menu items
	public void clickOnRightClickMenuItem(By contextMenuLocator, String menuItemValue) {
		act.contextClick(getElement(contextMenuLocator)).perform();
		By menuItemLocator = By.xpath("//*[text()='" + menuItemValue + "']");
		// We are using * instead of htmltag
		// in this xpath because * in xpath
		// means an element with any type
		// of html tag but with certain
		// properties
		// So, here this xpath interprets all the elements that having a text
		// irrespective of
		// the htmltag.
		doClick(menuItemLocator);
	}

	// Generic method to handle exactly 2 level menus like header navigation
	// and perform actions like click, mouse hover the sub-menu links etc.
	public void multiLevelMenuHandling(By level1MenuLocator, By level2MenuLocator) throws InterruptedException {
		act.moveToElement(getElement(level1MenuLocator)).perform();
		Thread.sleep(1500);
		doClick(level2MenuLocator);
	}

	// Generic method to handle exactly 4 level menus like header navigation
	// and perform actions like click, mouse hover the sub-menu links etc.
	public void multiLevelMenuHandling(By level1Locator, String level2, String level3, String level4)
			throws InterruptedException {
		getElement(level1Locator).click();
		Thread.sleep(1500);
		act.moveToElement(getLinkElementByText(level2)).perform();
		Thread.sleep(1500);
		act.moveToElement(getLinkElementByText(level3)).perform();
		Thread.sleep(1500);
		getLinkElementByText(level4).click();
	}

	// Generic method to handle exactly 3 level menus like header navigation
	// and perform actions like click, mouse hover the sub-menu links etc.
	public void multiLevelMenuHandling(By level1Locator, String level2, String level3) throws InterruptedException {
		getElement(level1Locator).click();
		Thread.sleep(1500);
		act.moveToElement(getLinkElementByText(level2)).perform();
		Thread.sleep(1500);
		getLinkElementByText(level3).click();
	}
}
