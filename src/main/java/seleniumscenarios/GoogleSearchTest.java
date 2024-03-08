package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	// (INTERVIEW IMPORTANT) : How will you enter any
	// keyword in the Google search box and then
	// click a particular value from the suggestions list ?

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		By searchBox = By.name("q");
		By suggestions = By.xpath("//ul[@role='listbox']"
				+ "//div[@role='presentation' and @class='wM6W7d']/span");
		doSearchAndClick(searchBox,suggestions,"Naveen Automation Labs" , "playwright");
	}

	public static void doSearchAndClick(By searchlocator,By searchSuggLocator, 	String searchKeyword, String suggToClick)
			throws InterruptedException {
		driver.findElement(searchlocator).sendKeys(searchKeyword);

		Thread.sleep(4000); // ALWAYS put wait after entering the search keyword
		// whenever you are automating
		// a search box and you have to click from the suggestions list.
		// But the suggestions are coming after a few seconds.

		List<WebElement> suggestionsList = driver.findElements(searchSuggLocator);

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

}
