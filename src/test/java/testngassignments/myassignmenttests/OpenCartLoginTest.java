package testngassignments.myassignmenttests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartLoginTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/"
				+ "opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("input-email")).sendKeys("sgnight30@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "My Account");
		Thread.sleep(1500);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
