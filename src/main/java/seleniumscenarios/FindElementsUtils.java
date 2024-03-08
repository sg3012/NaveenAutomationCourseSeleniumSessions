package seleniumscenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUtils {
	// This class implements some generic functions
	// related to a combination of web elements

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		driver.get("https://flipkart.com");

		By links = By.tagName("a");
		By images = By.tagName("img");

		System.out.println(getElementsCount(links));
		System.out.println(getElementsCount(images));

		List<String> actEleTextList = getElementsTextList(links);

		System.out.println(actEleTextList);

		if (actEleTextList.contains("Privacy Policy")) {
			System.out.println("Privacy Policy -- PASS");
		}

		if (actEleTextList.contains("Terms & Conditions")) {
			System.out.println("Terms & Conditions -- PASS");
		}

//		List<String> actEleAttrList = getElementsAttrList(images, "src");
//		System.out.println(actEleAttrList);
	}

	// Generic function to get a collection of web elements
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// Generic function to fetch count of a collection of elements
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	// Generic function to get a List of the text displayed on a list of web
	// elements
	public static List<String> getElementsTextList(By locator) {
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
	// elements
	public static List<String> getElementsAttrList(By locator, String attr) {
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

	// (INTERVIEW-IMPORTANT) : What will happen if you pass a wrong locator
	// in the findElements() method?
	// Ans : It returns an empty list (with size = 0). It will not give any
	// exception.

}
