package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	// This class explains the concept 
	// of dependsOnMethods in TestNG
	
	// dependsOnMethods is a keyword used to define the
	// dependency of one method over the other.
	
	// dependsOnMethods keyword takes a String value
	// as the parameter. The string value will
	// be of the method that the current method
	// is dependent upon. The string value of the
	// method name is case-sensitive so be cautious
	// while giving the method name value.
	
	// If some method (say A) is dependent on some
	// other method (say B) to be executed before
	// the dependent method (say A) then the
	// method B will be executed before method A
	// doesn't matter method A's name is
	// alphabetically before the method B's name.
	// TestNG will always give priority to depending
	// method (method B) over dependent method (method A)
	// and execute it before method A. This will be 
	// the execution sequence even if we have given
	// priority to method A to be running before method B.
	
	// If the depending method (A) is getting failed
	// then dependent method (B) is skipped for execution
	// using dependsOnMethods keyword.
	
	// It is NOT ADVISABLE to use dependsOnMethods
	// in real-time frameworks because
	// what if the depending method is getting failed
	// for a very short duration and because
	// of this failure all the remaining dependent tests
	// are not executed which is not good.
	
	@Test
	public void loginTest() { // Login test will be running before 
		                      // appSearchTest doesn't matter appSearchTest
		                      // is alphabetically before loginTest
		System.out.println("login to app");
		int  i = 9/0; // This loginTest
		// will fail at this point because 
		// of AE and then the execution
		// of appSearchTest and selectProductTest
		// will be skipped because there is
		// no point running searchTest and selectProductTest
		// if login itself is not working.
	}
	
	@Test(dependsOnMethods = "loginTest") 
	public void appSearchTest() {
		System.out.println("appSearchTest");
		
		// ########### CORRECTED APPROACH ###########//
		// Remove dependsOnMethods above, perform login 
		// separately and do the search test like below
		
		// login()
		System.out.println("appSearchTest");
	}
	
	@Test(dependsOnMethods = "appSearchTest")
	public void selectProductTest() {
		System.out.println("selectProductTest");
		
		// ########### CORRECTED APPROACH ###########//
		// Remove dependsOnMethods above, perform login,
		// perform product search separately and 
		// do the select product afterwards test like below
				
		// login()
		// appSearch();
		System.out.println("login to app");
	}
	
// #################################// 
	
//	@Test(priority = 2) 
//	public void loginTest() { // Login test will be running before 
//		                      // appSearchTest doesn't matter appSearchTest
//		                      // is alphabetically before loginTest
//		System.out.println("login to app");
//	}
//	
//	@Test(dependsOnMethods = "loginTest", priority = 1) 
//	public void appSearchTest() {
//		System.out.println("appSearchTest");
//	}
//	
//	@Test(dependsOnMethods = "appSearchTest", priority = 3)
//	public void selectProductTest() {
//		System.out.println("login to app");
//	}
	
	// execution sequence of methods(which have priorities) under above Test annotations:
	// 1. loginTest
	// 2. appSearchTest
	// 3. selectProductTest

	// And this will be the sequence doesn't matter
	// if we have given the method 'appSearchTest'
	// a priority value to be run before the method
	// 'loginTest' because dependsOnMethods will take
	// priority over any other priorities defined.

	// PROBLEMS WITH DEPENDSONMETHODS
	
	// 1. So, if the depending method (loginTest) fails then
	// dependent methods will also fail. 
	
	// So, how to remove dependency on the loginTest if it fails
	// one time?
	// Ans: Perform login or any other depending operation separately each time when
	// you perform a test (see the code under corrected approach
	// section) in each test method above giving them
	// another chance to execute if loginTest passes after some moments.
	// This can be done by creating a separate login() or any other depending 
	// method for any user action.
	
	// 2. Other problem is when we execute the tests in parallel/multi-threading mode
	// in which all threads will almost start running at the same time and if
	// we have create lots of dependencies as shown in the above tests then the threads
	// will get stuck in parallel mode and it will be very difficult to run tests in sync.
	
	
	// Below are some examples of some test cases
	// on how we should design test flows in real-time:
	
	// login ---> homepage ----> search ----> cart ----> payment ----> perform test
	// login ---> homepage ----> search2 ----> cart ----> payment ----> perform test
	

}
