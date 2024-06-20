package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadConcept {
	
	// This class explains how you can handle
	// file upload from your local system
	// using selenium library.
	
	// SELENIUM DOESN'T HAVE NATIVE support to 
	// automate any scenario on any Desktop, (Windows, MAC etc.)
	// it just automates the web apps. Because of this reason
	// whenever a pop-up comes when we click on the upload button
	// on a web page, selenium couldn't handle that pop-up and
	// choose file from the local system like we do it manually.
	
	// So, how to automate file upload scenario then?
	// We Automate file upload using a WORKAROUND by directly passing the path to the file
	// to be uploaded directly to the SENDKEYS() method instead of
	// clicking an upload button, after launching the desired page.
	
	// To use the WORKAROUND following CONDITION MUST be satisfied:
	// There MUST BE an attribute called TYPE whose value MUST
	// be FILE in the HTML code of the UPLOAD BUTTON. Otherwise, the workaround
	// will not work. The HTMML tag of the upload button could be anything like
	// input or button etc. In MOST OF THE cases the the attribute "type"
	// with value as "file" will be there.
	
	// If you want to upload multiple files at the same time like we do manually, you
	// can't do it in a single go using this workaround. To upload multiple files
	// we have to call sendKeys() method multiple times.
	
	// If you have drag and drop upload supported in your app for the file uploads then
	// you CANNOT AUTOMATE this scenario also with SELENIUM using any workaround.

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\sgupta12\\Downloads\\Test file upload.txt");
		// Don't forget to add the FILE EXTENSION with file name while passing the path
		// to the file in SENDKEYS() method.
		
		// BUT what if TYPE = FILE attribute and value pair is not
		// there ?
		// Go with the following approaches:
		
		// 1. ASK YOUR DEV to add this attribute-value pair in the HTML (THIS IS THE BEST APPROACH
		// YOU COULD FOLLOW)
		
		// 2. If devs don't agree then use ROBOT CLASS (BUT IT IS NOT AT ALL RECOMMENDED
		// BECAUSE IT ONLY WORKS ON WINDOWS AND NOT ON MAC, LINUX, HEADLESS, GRID, JENKINS,
		// DOCKER OR ANY OTHER CLOUD PLATFORM WHERE WE WILL CONFIGURE OUR AUTOMATION FRAMEWORK
		// AND WANT TO RUN ON CLOUD)
		
		// 3. OR, Use autoIT library (BUT IT IS NOT AT ALL RECOMMENDED
		// BECAUSE IT ONLY WORKS ON WINDOWS AND NOT ON MAC, LINUX, HEADLESS, GRID,JENKINS,
		// DOCKER OR ANY OTHER CLOUD PLATFORM WHERE WE WILL CONFIGURE OUR AUTOMATION FRAMEWORK
		// AND WANT TO RUN ON CLOUD)
		
		// 4. OR, Siklui API - 
		// BUT ITS NOT RECOMMENDED BECAUSE:
		// IT IS IMAGE BASED AND WE HAVE STORE A LOT OF IMAGES INCLUDING THE FILE TO UPLOAD
		// IN OUR SYSTEM FOR THE ELEMENTS WHICH WE HAVE TO VISIT
		// IN ORDER TO REACH THE REQUIRED FILE TO BE UPLOADED
		
		// If there is a slight PIXEL DIFFERENCE between the images on 2 different machines
		// (for e.g. one windows 10 machine and the other windows 11 machine which
		// may have different UI for the documents folder in the upload pop-up) it will NOT WORK.
		
		
		// ADV POP-UPS:
		// How to handle them ?
		// Ans: To handle these pop-ups just inspect
		// them as normal web element (if they are not in an Iframe)
		// and just close them or do whatever action you want.
		// But generally these pop-ups are disables in lower environments like
		// Dev/QA/STG/UAT because most of the time they are not part
		// of the application functionality and will not impact anything in the 
		// lower environment if not tested. SO, these are always enabled in the
		// PROD env. and we don't automate prod and we don't require to
		// automate them on lower environments also.
		
		
		// What if the ADV pop-ups are coming randomly on a web page? Can we or should
		// we automate those?
		// Ans: No we shouldn't automate handling of random pop-ups because
		// sometimes these are coming after 5 seconds or 10 seconds or may be an hour
		// or not coming at all or coming after clicking some specific elements.
		// So, if we want to apply the wait logic to automate these then also
		// we are not certain that after that much wait duration the pop-up will
		// every time. In this case we are not certain about when the pop-up will
		// come. Hence, we should not automate the Random pop-ups.
		
		
		
		
	}

}
