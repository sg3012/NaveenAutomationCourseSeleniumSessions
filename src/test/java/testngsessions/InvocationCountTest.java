package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvocationCountTest {
	// This class explains about the
	// invocationCount feature of TestNG

	// invocationCount defines how many times same test
	// should run in a test execution containing
	// multiple different test cases.
	
	// We can also give priorities along with invocationcount,
	// expectedExpections for a test annotation.

	@Test(invocationCount = 10, priority = 1, expectedExceptions = Exception.class) 
	// searchtest will be running at 1st priority 10 times
	public void searchTest() {
		System.out.println("searchTest");
		Assert.assertEquals("Google", "Google");
	}

	@Test(priority = 2) // carttest will be running at 2nd priority only 1 time
	public void cartTest() {
		System.out.println("cartTest");
		Assert.assertEquals("macbook", "macbook");
	}

}
