package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLangLinksHandle {

	// (INTERVIEW IMPORTANT) : How will you fetch all the
	// language links present on the Google search home page
	// and print their text and click on any one the lang link?

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		By langLinks = By.xpath("//div[@id='SIvCob']/a");
		
		clickOnLink(langLinks, "मराठी");
	}

	// Generic method to find all links on a page and click on the Desired Link
	public static void clickOnLink(By locator, String linkText) {
		List<WebElement> linksList = driver.findElements(locator);
		
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

}
