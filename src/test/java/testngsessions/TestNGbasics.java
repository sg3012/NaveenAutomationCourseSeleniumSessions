package testngsessions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// This is a JAVA class not a testNG class
// as we are using JAVA only here to create
// our tests

// This class explains basics of testNG like
// how to create the test cases, how to run them etc. 

// Now what steps you will follow
// when you create test cases manually?

// Ans: First we identify and define
// if there are any preconditions which
// need to be fulfilled before every test execution i.e., 
// Global preconditions like the server is up and running, test data is
// available in the system etc.

// Second we write the test steps along with expected and actual results or validation
// or checkpoints

// Third we write post steps like shutdown the server, close the connection to
// resources, log out the application , close the application etc.

// We will follow the exact same 3 steps broadly while
// writing the automated test cases in TestNG. So, we will follow
// below steps in sequence in almost all of the test cases:
// 1. Write Global preconditions
// 2. Write test steps along with validations or checkpoints or expected + actual results
// 3. Close the connection to resources, shutdown server, logout application, close browser etc.

// All the Global preconditions are created under before annotations in testNg 

// All the test cases are created under @Test annotation in testNG

// All the post steps are created under After annotations in testNG

// Make it a practice to append the word "Test" in every test case
// method so that it is clearly visible that it is a Test case

// It is RECOMMENDED that any method written under any
// annotation of testNG SHOULD NOT RETURN any thing
// i.e., there return type should be VOID.
// Because no other method or code going to
// utilize the values written under these methods

// Below is the sequence/priorities of the testNG annotations:
// 1. BeforeSuite
// 2. BeforeTest
// 3. BeforeClass
// 4. BeforeMethod
// 5. Test
// 6. AfterMethod
// 7. AfterClass
// 8. AfterTest
// 9. AfterSuite

// [NOTE] : Code written under the BeforeMethod annotation will be executed
// before code written under each and every Test annotations is executed.
// Similarly, Code written under the AfterMethod annotation will be executed
// after the code written under each and every Test annotations is executed.
// Meaning, if there are 3 test annotations defined and we have BeforeMethod
// and AfterMethod annotations also then before running a script written under
// Test annotation, BeforeMethod will be executed and after the completion
// of every script under Test annotation, AfterMethod will be executed.
// So, BeforeMethod and AfterMethod annotations' code will also
// be running 3 times each.
// BUT the code written under the remaining annotations will
// only be running ONCE, that is NOT DEPENDENT on
// how many Test annotations are there.

// The DEFAULT priority of which code to pick
// to be executed under a Test annotation is decided
// in the Alphabetic order of the method names
// written under each test annotation in increasing order
// But if we have defined priority for a Test annotation
// which is higher (or lower number) then some other
// test annotation then this will be executed first
// even the method name(with higher priority) under this test annotation
// is coming after the method name(with lower priority) 
// under other test annotation, alphabetically.

// [IMPORTANT INTERVIEW] Which will be running first BeforeTest or BeforeClass?
// Ans: BEFORETEST will be running PRIOR to BEFORECLASS

// If we remove all the test annotations from a testNG JAVA class 
// and the class as TestNG test all the methods under other annotations
// (if present) will run and in the console output we will see
// see a message from testNG stating "NO TESTS WERE RUN" along with
// the O/P for methods under the other annotations.

// If we want to run a method only under a specific
// test annotation then just highlight the method name
// (not the parameters, if present) under that 
// annotation >> right click anywhere
// the test file >> click run a testNG test >>
// it will run only the method you highlighted
// under the test annotation.

// We can create a testNG class without Before and After
// annotations with having only Test annotations. If
// we run such class all the test cases under Test annotation
// would run fine, without any error/warning from TestNG.

// Once all the test cases are executed testNG generates some reports
// containing the failure, pass status of the tests which you can
// show it to your mgmnt. Out of these 2 reports are important 
// first index.html, emailable-report.html.

// To see these reports in your project follow below steps:
// Right click on your project root folder >> Refresh the project

// It will generate one test-output folder >> open it.
// You will see both of the above mentioned reports here >> right
   // click on let's say index.html >> go to properties >> copy the
  //  path >> open the path in any web browser.

// There is one more report that testNG generates for
// failures named "testng-failed.xml". You can access
// this report in the same test-output folder.
// This report contains the entries for only failed tests
// in XML form at. If you want to execute only
// failed tests again then you can run only this file
// using following steps:
   // Right click the file name
   // Choose run as testNG suite and it will execute your file.

public class TestNGbasics {
	
	// TestNG Annotations:
	// NOTE: Every annotation in TestNG MUST have a method
	// along with (NOT JUST DECLARATION)associated with it. 
	// If we don't write a method below an annotation then 
	// we will get syntax error

	// Below are the annotations provided by testNG:
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS -- Connect with DB");
	} 
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT -- createUser");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- Launch Browser");
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM -- login To App");
	}
	
	@Test
	public void searchTest() {
		System.out.println("searchTest");
		// Write assertion to validate
		// if the steps performed are correct or not
		// qualifying them as a test case.
		// To validate/assert the test steps in testNG
		// we use Assert class like below:
		
		Assert.assertEquals("Google", "Google1");
		// First parameter in this method is the actual result
		// which you got after executing the test script
		
		// Second parameter in this method is the expected result
		// which we got from the business requirement or user stories.
	}	
	
	@Test
	public void cartTest() {
		System.out.println("cartTest");
		Assert.assertEquals("macbook", "macbook");
	}
	
	@Test
	public void orderTest() {
		System.out.println("orderTest");
		Assert.assertEquals(1000, 1000);
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- closeBrowser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- deleteUser");
	}
	
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS -- disconnectWithDB");
	}
}
