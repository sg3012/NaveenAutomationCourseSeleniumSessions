package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import customexception.FrameWorkException;

public class CalendarHandling {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016"
				+ "/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		
		// click next button and select future date from date picker
		// selectFutureDate("December 2025", 29);
		 
		// click prev button and select past date from date picker
		   selectPastDate("October 2024", 2);
	}
	
	
	/* This is a generic method to select a past date
	 * from a date picker based on a particular year
	 * and month
	 * */
	public static void selectPastDate(String expMonthYear, int date) throws InterruptedException { // expMonthYear = October 2025
		
		int intYear; 
		
		String stringMonthYear=expMonthYear;
		
		if(date<1 || date>31) {
			throw new FrameWorkException("INCORRECT DATE. DATE CANNOT BE LESS THAN 1"
					+ " OR GREATER THAN 31");
		}
		
		if(stringMonthYear.toLowerCase().contains("february")) {
			if(date==29) {
				System.out.println("Date to be selected...."+date);
				stringMonthYear = stringMonthYear.replaceAll("\\D+", " ");
				stringMonthYear = stringMonthYear.trim();
				intYear = Integer.parseInt(stringMonthYear);
				 if ((intYear % 4 == 0 && intYear % 100 != 0) || (intYear % 400 == 0)){
					 System.out.println(intYear+" is a leap Year...Selecting the appropriate date...");
				 }
				 else {
					 System.out.println(intYear+" is not a leap year...cannot select the date... "+date+" exiting....");
					 return;
				 }
			}
		}
		
		String actMonthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		System.out.println(actMonthYear); // August 2025
		
		while(!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			// click on previous button
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			
			actMonthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
			System.out.println(actMonthYear);
			Thread.sleep(500);
		}
		selectDate(date);
	}
	
	
	/* This is a generic method to select a future date
	 * from a date picker based on a particular year
	 * and month
	 * */
	public static void selectFutureDate(String expMonthYear, int date) throws InterruptedException { // expMonthYear = October 2025
		
		int intYear; // declared a new integer Year variable here
		// to store only the integer year from the string expMonthYear
		
		String stringMonthYear=expMonthYear; // declared
		// a new String type monthyear variable here
		// so that we could use this while making comparisons
		// for leap year below
		
		// check if date is greater less than 1 or greater than 31
		if(date<1 || date>31) {
			throw new FrameWorkException("INCORRECT DATE. DATE CANNOT BE LESS THAN 1"
					+ " OR GREATER THAN 31");
		}
		
		if(stringMonthYear.toLowerCase().contains("february")) {
			if(date==29) {
				System.out.println("Date to be selected...."+date);
				stringMonthYear = stringMonthYear.replaceAll("\\D+", " ");
				stringMonthYear = stringMonthYear.trim();
				intYear = Integer.parseInt(stringMonthYear);
				 if ((intYear % 4 == 0 && intYear % 100 != 0) || (intYear % 400 == 0)){
					 System.out.println(intYear+" is a leap Year...Selecting the appropriate date...");
				 }
				 else {
					 System.out.println(intYear+" is not a leap year...cannot select the date... "+date+" exiting....");
					 return;
				 }
			}
		}
		
		String actMonthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		System.out.println(actMonthYear); // August 2025
		
		// When actual month and year are not equal
		// to exp month and year then only click
		// on next button date picker. Otherwise,
		// there is no point in clicking next
	    // because whatever month and year are expected
		// are already present on the first view 
		// itself of the date picker.
		while(!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			// click on next button
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			// updating the actual month-year in the loop again
			// so that the variable actMonthYear doesn't take
			// the initial value which was assigned to it
			// the very first time
			actMonthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
			System.out.println(actMonthYear);
			Thread.sleep(500);
		}
		selectDate(date);
	}
	
	/* This is a generic function to select any date on
	 * a date picker element. 
	 * Params:
	 * integer date
	 * */
	public static void selectDate(int date) {
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
	}

}
