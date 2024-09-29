package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	// This class explains ExpectedExceptions feature of TestNG
	
	// If at any point in a test written under Test annotation,
	// there is an exception occurring and it is not handled
	// then the test will fail immediately at the line where
	// exception has occurred
	
	// To ignore the exception we use expectedExceptions
	// keyword so that the test bypasses the ignored exception
	// and passes.
	
	// Now, if we have ignored an exception using expectedExceptions
	// keyword but there is no exception at all in the test method
	// then also the test will be failed saying it was
	// expecting an exception but it didn't occur, on the console.
	
//	@Test
//	public void searchTest() {
//		System.out.println("searchTest");
//		int i = 9/0; // The test will be failed at this line
//		// because of Arithmetic exception. To fix 
//		// this we will use the keyword ExpectedConditions
//		// provided by testNG and configure it to except Arithmetic 
//		// Exception as shown below.
//	}
	
	String name;
	
	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class})
	public void searchTest() {
		System.out.println("searchTest");
		int i = 9/0; // ArithmeticException, but ignored
		
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj = null;
		obj.name = "Naveen"; // The test will be failed
		// at this line because we have allowed the Arithmetic
		// exception to occur but here we will get NullPointerException.
		// If Arithmetic Exception would have occurred then the test would be
		// passed but it is now failed due NPE. Also, NPE will be thrown
		// on the console.
		// So, can we ignore/allow multiple exceptions 
		// using expectedExcpetion keyword?
		// Ans: Yes. The expectedExceptions takes
		// an array of classes as parameter. So,
		// we will pass multiple arrays in the form
		// of literals as shown above in @Test signature
		
		// This (expectedExceptions)
		// feature of testNG is used by developers
		// to perform some negative tests
		// while unit testing their code.	
	}
	
	// Now, tomorrow if due to bad locator or bad strategy we have 
	// a lot of instances of NoSuchElementException or StaleElementException
	// or any major exception which must be fixed, is using
	// expectedConditions and ignoring those exceptions
	// and by passing your mistakes a right thing to do?
	// Ans: No, you should never use this feature of testNG to ignore the
	// exceptions that must be fixed just to bypass your mistakes. So
	// be very CAREFUL while using this feature while giving demos to
	// the client. Becuase if you do this then there will be bugs
	// leaked in prod or manual testers will find bugs but your scripts won't.
	// This feature is introduced only to perform some negative tests.

}
