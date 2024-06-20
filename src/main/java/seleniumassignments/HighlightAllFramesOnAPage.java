package seleniumassignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightAllFramesOnAPage {
	// This class shows how to highlight
	// all frames present on a web page
	// with Red colored border

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(1000);
		
		// Locate all the frames on a web page:
		List<WebElement> frameElementList = driver
						.findElements(By.xpath("//frame"));
		System.out.println("Frame Size: "+frameElementList.size());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Iterate the list of frames
		// and highlight them one by one
		
		for(WebElement ele : frameElementList) {
			js.executeScript("arguments[0].style.border='3px solid Yellow'",ele);
		}		
	}

}
