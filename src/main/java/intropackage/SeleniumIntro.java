package intropackage;

public class SeleniumIntro {
	
	// This class Explains following:
	// What is Selenium?
	// Why it was created and what purpose does it serve?
	// A brief history about Selenium
	
	// What is Selenium?
	// Selenium is just an automation library that can ONLY AUTOMATE
	// the USER ACTIONS such as click, filling data, drag-drop etc.
	// on web-based applications. It is not a testing automation
	// tool because we cannot verify any of the user actions we
	// have automated, using Selenium. Meaning, we cannot write
	// expected and actual results using Selenium.  IT IS NOT A TEST AUTOMATION TOOL
	
	// Selenium can only automate web apps.
	
	// We can not only automate the tasks that are related to testing purpose
	// but also can automate any repetitive task using Selenium on a Web app to
	// save time.
	
	// The pom.xml file created after creating a Maven project is called
	// Project Object Model file NOT Page Object Model file.
	
	// PROS OF SELENIUM:
	// 1. Open Source and Free tool. Open source means the Source code is available to the end user
	//    to modify the software according to their need. Free tool means source code is not
	//    available to the user but it can be downloaded, installed and used free of cost.
	//    In free tool not all features will be available to the user for free in some cases and
	//    they have to pay to use advanced features. Paid tools are the ones
	//    we have to pay to be able to use the basic features even like QTP, UFT etc.
	
	// 2. Supports all Major browsers - Chrome/FF/Safari/Edge/Opera/Brave
	
	// 3. Selenium supports all major programming languages - JAVA, Python, JS, PHP, Go, .net/c#, Ruby
	
	// 4. Supports different OS/platforms : windows, MacOS, Linux (Unix is not supported)
	
	// 5. Supports W3C WebDriver protocol. W3C is a community that defines
	//    certain rules / standards for Web browser based applications like
	//    how to define buttons, where to click on elements etc., that are followed
	//    all over the world by the devs. So that the application passes those standards
	//    and are W3C certified. Now, selenium webdriver is also W3C Certified.
	//    Meaning both the Browsers and the Selenium Webdriver are w3c certified and 
	//    communication between both the parties becomes easier. (MAJOR ADVANTAGE)
	
	// 6. Community Support is very good. Meaning, if you are stuck on a scenario
	// you will find a solution for that online in most of the cases. Because
	// Selenium community is there from last 15 years and is very active (even their official team.)

	// 7. If you have learned Selenium then transition to some Selenium based
	// will be easy. Some Selenium based tools are Appium, webdriverIO, Selenide,
	// Protractor(deprecated) etc. They are also called Selenium Family because
	// all of these tools are using Selenium library internally and they have customized
	// it and developed these tools on top of it.
	
	// CONS OF SELENIUM:
	
	// 1. Only for Web, not for mobile, desktop apps and api automation. But can automate
	// mobile responsive sites using different viewports.
	
	// 2. It is not a testing tool - meaning we cannot check if
	// a test is passed or failed, how many tests failed or passed, cannot generate test reports etc.
	
	// 3. We cannot maintain any test data (Test Data Management) using Selenium.
	
	// 4. Cannot automate any H/W/ testing like Raspberry PI, bluetooth devices, iot etc.
	
	// 5. Cannot automate captcha, BAR codes, QR codes using selenium only.
	
	// 6. Cannot do performance testing using Selenium.
	
	// 7. Cannot do Security Testing with Selenium.
	
	// 8. Cannot automate non-webelements like PDFs, Word documents, CSV files, Excel files etc.
	
	// 9. Cannot do accessibility testing only with Selenium Library.
	
	// 10. Cannot run test cases in parallel only with Selenium. It is supported by
	// TESTNG.
	
	// 11. Cannot do Image testing with Selenium only.
	
	
	// COMPONENTS OF SELENIUM
	
	// 1.Selenium IDE - Record n Play plugin on chrome/firefox 
	
    // 2.Selenium RC (Remote Control) - It was called Selenium 1. Totally deprecated from the market.
	
	// 3.Selenium WebDriver - WebDriver is a different library altogether. Selenium
	// team integarted webdriver with RC and called in Selenium Webdriver. So that
	// we could use the combined features of both Webdriver and RC which was called Selenium 2.
	// After that came Selenium 3 and then Selenium 4. The major difference between sel 3 and sel 4
	// is Selenium 4 is W3C certified but Selenium 3 or any other previous versions are not.
	// Last stable version of Selenium 3 was 3.141.59.
	
	// 4. Selenium GRID - Hub + Nodes- Grid is basically used to run the test cases
	// on a Remote machine/cloud machine/AWS server in parallel using TestNG.
	
	
	// Selenium ACRHITECTURE (BASIC DON'T NEED TO EXPLAIN IN INTERVIEW):
	// Selenium uses browser drivers exe files (like chromedriver.exe, edgedriver.exe etc) 
	// to interact with any bowser. It cannot communicate directly with any browser.
	
	// chromedriver can only interact with Chrome browser, geckodriver can only
	// interact with FF and like that. chromedriver cannot interact with FF browser like that.
	// Driver and browser mapping is one to one mapping only. (See the file SeleniumArc_BASIC_May23_2023_1
	// in the intropackage for the architecture)
	
	
	// SELENIUM ARCHITECTURE (ADVANCED NEED TO BE EXPLAINED IN INTERVIEW):
	// SearchContext is the top most Interface relevant to the Selenium architecture
	// having 2 methods declared, findElement() and findElements() without any method bodies.
	
	// The next Interface in the architecture is WebDriver which is extending
	// SearchContext Interface and overriding both findElement() and findElelements().
	// WebDriver interface has some own methods also like get(url), getTitle(),
	// quit(), close() etc. without any bodies.
	
	// Then there is a class in the Arc. hierarchy called RemoteWebDriver
	// which is implementing WebDriver Interface. This class is overriding
	// and implementing all the methods that belong to WebDriver itself along with
	// the ones which WebDriver was overriding. So, In Short all the methods
	// that are visible in the WebDriver.
	
	// Then there are some direct sub-classes of RemoteWebDriver class
	// relevant to the Selenium Arc. which are specific to the 
	// browsers available in the market like SafariDriver, FireFoxDriver, ChromiumDriver etc.
	// which define some standard functions for the specific browsers.
	
	// Then ChromiumDriver has 2 direct child classes - ChromeDriver, EdgeDriver. So,
	// ChromeDriver and EdgeDriver classes don't inherit RemoteWebDriver directly
	// because Chromium is a technology (or a set of rules) which chrome and edge follow
	// that is why ChromeDriver and EdgeDriver first extend ChromiumDriver then
	// ChromiumDriver extends RemoteWebDriver. So, we can say that ChromeDriver and EdgeDriver
	// are grand children of RemoteWebDriver.
	
	// (INTERVIEW QUESTION - Regarding architecture only):
	// What was the major change happened Selenium version 4.6.0 onwards?
	// Ans: Before selenium 4.6.0 every time the browser in version installed 
	// in the local system was updated the automation engineer had to download
	// the corresponding bowserdriver.exe file to run the automation script.
	// And Every major browser company releases new updates very frequently
	// (like after every 15 days or a month). So, it was very difficult for the SDETs
	// to manage these browserdriver updates so quickly. 
	// So, selenium 4.6.0 onwards user doesn't need to download the browserdriver.exe
	// files explicitly according to the browser version. Selenium downloads
	// the corresponding exes internally and does the work automatically using
	// a feature called SELENIUMMANAGER.
	
	// All those .exes are downloaded in the .cache folder
	// of users folder on a WINDOWS machine by the Selenium manager.
	
	
	
	
	// But if we don't want to use the Selenium Manager in the project
	// then we can download the separate .exe files for corresponding browser
	// and provide their path in the framework the old way.
	
	// (IMPORTANT)Apple doesn't provide the exe file for 
	// Safari driver separately, Selenium takes care of 
	// Safari automation internally, if we want to download 
	// separate exe files to create automation framework
	
	
	// CONTNIUED..... (SELENIUM ARCHITECTURE IN SeleniumIntro2.java)

}
