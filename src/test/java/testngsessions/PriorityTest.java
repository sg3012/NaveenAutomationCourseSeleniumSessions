package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {
	
	// This class explains what are Priorities
	// in TestNG and how we could define 
	// priorities for test cases to be executed
	// in Certain order
	
	// Priority is a feature that defines at which
	// number a particular test case should run, explicitly.
	// Lesser the priority value quicker the
	// execution of a test. For e.g. A test case
	// having priority 2 will run before the test case
	// having priority 4.
	
	// We can give the Priority value as 0. If priority
	// is set as 0 for some test case and all other
	// tests have priority more than 0 then 0th priority
	// will be running 1st
	
	// We can give the Priority value as negative. If priority
	// is set as negative for some test case and all other
	// tests have priority more than the negative one 
	// then negative priority test will be running 1st
	
	// If some multiple tests have negative priorities
	// then the tests will more negative priority
	// value will be running before the ones
	// with less negative value.
	// But NO-ONE gives/uses the negative and 0 priority in REAL-TIME projects
	
	// If some Test annotations are written without priority and some are
	// written with priority then the Tests written without priority
	// will be executed in alphabetical order (increasing alphabetical) 
	// first and then the one written with priority will be 
	// executed according to the Priorities given.
	
	// If some test annotations are written with different priorities 
	// and some with same priorities then tests having lesser priority
	// value will run first and then the test annotations written
	// with same priority will run in alphabetical order (increasing alphabetical).
	
	

	@Test(priority = 1)
	public void searchTest() {
		System.out.println("searchTest");
		// Write assertion to validate
		// if the steps performed are correct or not
		// qualifying them as a test case.
		// To validate/assert the test steps in testNG
		// we use Assert class like below:

		Assert.assertEquals("Google", "Google");
		// First parameter in this method is the actual result
		// which you got after executing the test script

		// Second parameter in this method is the expected result
		// which we got from the business requirement or user stories.
	}

	@Test(priority = 2)
	public void cartTest() {
		System.out.println("cartTest");
		Assert.assertEquals("macbook", "macbook");
	}

	@Test(priority = 3)
	public void orderTest() {
		System.out.println("orderTest");
		Assert.assertEquals(1000, 1000);
	}
	
	@Test(priority = 3)
	public void paymentTest() {
		System.out.println("paymentTest");
		Assert.assertEquals("300", "300");
	}

	@Test(priority = 3)
	public void emailTest() {
		System.out.println("emailTest");
		Assert.assertEquals(1000, 1000);
	}

}
