package seleniumassignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLangLinksTest {

	// (INTERVIEW IMPORTANT) : How will you fetch the href value for all the
	// language links present on the Google search home page
	// and print their text?

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		
		System.out.println("Total lang links:"+langLinks.size());
		
		for(WebElement e : langLinks) {
			String hrefValue = e.getAttribute("href");
			System.out.println(hrefValue);
		}
	}

}
