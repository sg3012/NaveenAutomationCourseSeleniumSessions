package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlert {
	// This class explains about how to wait
	// for non-web element alert.

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // This time until
		// method will return Alert class reference variable. Also,
		// alerIsPresent() will not only return the Alert
		// class reference variable but also switch to that alert.
		// Above line will also throw TimeoutException if alert is
		// not displayed within the waiting time.
		
		// Using generic method to wait for alert
		Alert alert = waitForJsAlert(5);
		String alertTxt = alert.getText();
		System.out.println(alertTxt);
		Thread.sleep(1500);
		alert.accept();
		
		
		// [IMPORTANT INTERVIEW]: Can we handle non-web elements using Selenium WebDriver
		// waits?
		// Ans: Yes, we can.
		
		// [INTERVIEW]: Which method you will use to wait for the JS alert(s)
		// in Selenium ? And will this method switch to the alert or not
		// after alert is displayed ?
		// Ans: alertIsPresent() of ExpectedConditions class is used. Yes this
		// method will wait as well as switch to the alert after it is displayed.
	}
	
	// Generic method to wait for JS Alerts. It also creates, returns and switches
	// the alert automatically
	public static Alert waitForJsAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

}
