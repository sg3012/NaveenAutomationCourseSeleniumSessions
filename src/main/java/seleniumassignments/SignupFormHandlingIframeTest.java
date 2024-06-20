package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupFormHandlingIframeTest {
	
	// This class explains how to fill a signup
	// form which is inside an Iframe

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates"
				+ "/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration"
				+ "-Forms-and-Examples']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By
				.xpath("//iframe[contains(@id,'frame-one')]")));
		
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Vehicle Proposal");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("Delhi/NCR");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("4/20/2024");
		driver.findElement(By.id("RESULT_TextArea-5")).sendKeys("Test Desc");
		driver.findElement(By.id("RESULT_FileUpload-6")).sendKeys("C:\\Users\\sgupta12\\Downloads\\Test file upload.txt");
		
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("Shubham");
		driver.findElement(By.id("RESULT_TextField-9")).sendKeys("Shubham");
		driver.findElement(By.id("RESULT_TextField-10")).sendKeys("1/9305, Street 2/2, West Rohtash Nagar");
		driver.findElement(By.id("RESULT_TextField-11")).sendKeys("Shahdara");
		driver.findElement(By.id("RESULT_TextField-12")).sendKeys("Delhi");
		
		WebElement stateDropdown = driver.findElement(By.id("RESULT_RadioButton-13"));
		
		Select select = new Select(stateDropdown);
		
		select.selectByVisibleText("Colorado");
		
		driver.findElement(By.id("RESULT_TextField-14")).sendKeys("110032");
		driver.findElement(By.id("RESULT_TextField-15")).sendKeys("9653569196");
		driver.findElement(By.id("RESULT_TextField-16")).sendKeys("test@test.com");
		
	}

}
