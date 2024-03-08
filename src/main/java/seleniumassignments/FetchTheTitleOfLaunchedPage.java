package seleniumassignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class FetchTheTitleOfLaunchedPage {
	
	// This class shows how to launch a web app,
	// fetch the title of the page and validate its
	// correct or not

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.cricbuzz.com");
		
		String title = driver.getTitle();
		
		System.out.println("Actual title: "+title);
		
		if(title.equals("Live Cricket Score, Schedule, Latest News, Stats & Videos | Cricbuzz.com")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		driver.quit();
		
	}

}
