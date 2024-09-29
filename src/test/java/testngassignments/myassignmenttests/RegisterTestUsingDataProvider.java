package testngassignments.myassignmenttests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTestUsingDataProvider {

	// This class explains how to register
	// multiple users on a web app
	// using Test data from a data provider

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
	}

	@DataProvider
	public Object[][] registerTestData() {

		return new Object[][] { { "test", "user104", "test104@gmail.com", "9876543210", "test@1234" },
				{ "test", "user102", "test102@gmail.com", "9876543211", "test@1235" },
				{ "test", "user103", "test103@gmail.com", "9876543212", "test@1236" } };
	}

	@Test(dataProvider = "registerTestData")
	public void registerTest(String firstName, String lastName, String email, String phone, String pwd)
			throws InterruptedException {

		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);

		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);

		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phone);

		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);

		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(pwd);

		Thread.sleep(500);
		driver.findElement(By.name("agree")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(1500);

		String actAcctCreationTxt = driver.findElement(By.tagName("h1")).getText();

		Assert.assertEquals(actAcctCreationTxt, "Your Account Has Been Created!");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
