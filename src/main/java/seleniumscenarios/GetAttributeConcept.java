package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {
	
	// This class explains how we can fetch any attribute's value
	// like class, name, id, href etc. from the HTML code of
	// any web element. 

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart"
				+ "/index.php?route=account/register");
		By forgotPwd = By.linkText("Forgotten Password");
		
		By firstName = By.id("input-firstname");
		
		By logoImage = By.className("img-responsive");
		
		// fetch the href attribute value for forgot password link
//		String forgotpwd_href = driver.findElement(forgotPwd)
//				.getAttribute("href");
//		System.out.println(forgotpwd_href); // https://naveenautomationlabs.com/
//		                                    //    opencart/index.php?route=account/forgotten
//		
//		// fetch the placeholder attribute value for first name field
//		String fN_placeHolder = driver.findElement(firstName)
//				.getAttribute("placeholder");
//		System.out.println(fN_placeHolder); // First Name
//		
//		// fetch the title, SRC and alt attribute values for an image
//		WebElement logo_ele = driver.findElement(logoImage);
//		String logo_title = logo_ele.getAttribute("title");
//		String logo_src = logo_ele.getAttribute("src");
//		String logo_alt = logo_ele.getAttribute("alt");
//		System.out.println(logo_title); // naveenopencart
//		System.out.println(logo_src); // https://naveenautomationlabs.com/opencart
//		                              //   /image/catalog/opencart-logo.png
//		System.out.println(logo_alt); // naveenopencart

		String srcVal = getElementAttribute(logoImage, "src");
		System.out.println(srcVal); // https://naveenautomationlabs.com
		                            //   /opencart/image/catalog/opencart-logo.png
		
		getElementAttribute(logoImage, "title");
		getElementAttribute(logoImage, "alt");
		
		String fn_placeholder_value = getElementAttribute(firstName, "placeholder");
		System.out.println(fn_placeholder_value); // First Name
		
		String forgotpwd_href =getElementAttribute(forgotPwd, "href");
		System.out.println(forgotpwd_href); // https://naveenautomationlabs.com/opencart
		                                    //    /index.php?route=account/forgotten

	}
	
	public static String getElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
