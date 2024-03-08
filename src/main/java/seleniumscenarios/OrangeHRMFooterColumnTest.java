package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMFooterColumnTest {

	// This class answers the following INTERVIEW QUESTION (IMPORTANT):
	// How will you verify that 'Careers' link is available
	// under the 'About Us' sub-section only on the footer
	// section on Orange HRM sign up page?
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		Thread.sleep(3000);
		
		System.out.println(getFooterHeaderText("Careers"));
		System.out.println(getFooterHeaderText("News"));
		System.out.println(getFooterHeaderText("Executive"));
		System.out.println(getFooterHeaderText("Privacy Policy"));
		System.out.println(getFooterHeaderText("Partners"));
		
		//E.g.: //a[contains(text(),'Careers')]//ancestor::ul/parent::div[@class='footer-main']/h5 --> 
		// 3 sub paths under this xpath to reach the desired element
		
		// E.g.: //a[contains(text(),'Careers')]//parent::li//parent::ul//parent::div[@class='footer-main']/h5 -->
		// 4 sub paths under this xpath to reach the desired element
		
		// CREATING XPATHS USING SIBLING CONCEPT:
		
		// 1. XPATH USING PRECEDING SIBLING: 
		// E.g.://a[contains(text(),'Careers')]//ancestor::ul//preceding-sibling::h5 -->
		// 2 sub paths under this xpath to reach the desired element
		
		// E.g.: //a[text()='Joe.Root']//parent::td//preceding-sibling::td/input[@type='checkbox'] -->
		// xpath to select the Joe Root checkbox on the web table displayed on : 
		// https://selectorshub.com/xpath-practice-page/ PAGE.
		// 3 sub-paths for this xpath.
		
	}
	
	public static String getFooterHeaderText(String footerText) {
		// Locator for the desired element:
				By careersFtrLink = By.xpath("//a[contains(text(),'"
						+footerText
						+"')]//ancestor::div[@class='footer-main']/h5"); // 2 sub paths under 
				// this xpath to reach the desired element
				
				String aboutUsSectionFtrTxt= driver
								.findElement(careersFtrLink)
										.getText();
				return aboutUsSectionFtrTxt;
	}
	
//	SAMPLE XPATHS:
	// E.g.: //a[text()='Joe.Root']//ancestor::tr//input[@type='checkbox'] -->
	// xpath to select the Joe Root row's checkbox on the web table displayed on : 
	// https://selectorshub.com/xpath-practice-page/ PAGE.
	// 2 sub-paths for this xpath. (WITHOUT USING SIBLING CONCEPT)
}

