package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CRUDTest {
	
	// This class explains the following interview question:
	
	// [IMPORTANT-INTERVIEW] How will you
	// create tests for Create, Read, Update, Delete
	// (CRUD) operations in your framework?
	
	// And you can apply CRUD operations for any
	// record(s) on an application like
	// creating a product on ecommerce app,
	// creating properties of a vehicle on an app 
	// by filling a form, adding a user etc.
	
	// int userId = -1; // Default
	// value of the userId. We have assigned
	// this as -1 to indicate that there
	// could not be user with this (negative) userID
	// in the system. This value will be used if
	// for any reason a user couldn't be added in
	// the system.
	
	public int addUser() {
		System.out.println("addind a user");
		int userId = 123;
		return userId;
	}
	
	@Test(priority = 1)
	public void addUserTest() {
//		System.out.println("adding a user");
//		userId = 123;
		
		// Now, let's say while adding a user the user
		// couldn't be added due to some failure
		// like server side error, some problem with application,
		// some exception getting thrown etc. then in that
		// case the user and userID cannot be created in the DB
		// and the userID will be -1 (Default value).
		
		
		// ################# CORRECTED APPROACH #############//
		int userId = addUser();
		Assert.assertEquals(userId, 123);
	}
	
	@Test(priority = 2)
	public void getUserTest() {
		// System.out.println("get the user for userID "+userId);
		// Now, if we are trying to fetch the same user here
		// which couldn't be added due to the problems
		// mentioned in addUserTest() we will not get any user
		// because there will not be any user with userId -1 in the DB.
		// And when we will try to validate / assert here that
		// user exists or not, the test will FAIL.
		// This is the major problem when we are creating
		// test cases for CRUD operations and using the same
		// variable values (In this example UserId) in all the tests.
		// Due to this all further tests updateUserTest(), deleteUserTest()
		// will also be failed and it is a violation of AAA rule
		// of unit testing.
		
		// To avoid this problem it is strongly recommended to
		// not use the same variable values in all your CRUD
		// tests making them dependent on each other, while performing
		// unit tests. Write the tests which are as independent from each other
		// as possible so that each test looks like a unit
		// which is the basic principle of unit testing.
		
		// How to write the independent tests?
		// Ans: Create a separate method for adding user (as shown above
		// the addUserTest() method) and use the same method in
		// other CRUD methods (read, update, delete as shown in 
		// respective methods) creating a new user every time
		// a CRUD test in performed - generating a new userId and don't
		// use the default userId (-1 in this case). This way we reduce
		// the chances of failures of other methods if
		// create user test fails the first time but 
		// works fine while read, update and delete user test.
		
		// ################# CORRECTED APPROACH #############//
		int userId = addUser();
		System.out.println("get the user for userID "+userId);
	}
	
	@Test(priority = 3)
	public void updateUserTest() {
		// System.out.println("update the user for userID "+userId);
		
		// ################# CORRECTED APPROACH #############//
		int userId = addUser();
		System.out.println("update the user for userID "+userId);
	}
	
	@Test(priority = 4)
	public void deleteUserTest() {
		// System.out.println("delete the user for userID "+userId);
		
		// ################# CORRECTED APPROACH #############//
		int userId = addUser();
		System.out.println("delete the user for userID "+userId);
	}
	
	// Adding a user or performing create operation every time
	// and creating independent tests will not only improve CRUD tests 
	// it will also improve tests apart from CRUD operations like
	// when you perform some tests after deleting a user such as
	// searching for a user and verifying details , assigning
	// some tasks to user, send notifications to user etc.
	// In automation framework also we will follow the same
	// approach.
	
	// Some people say that to make the tests
	// independent we will consume a userID
	// which is already existent in the system and it will work
	// for all CRUD tests (HARDCODED VALUES), instead of adding 
	// new users every time. But there
	// are few problems with this approach:
	
	// 1. First if the delete operation is performed
	// then further tests on the same user will be failed
	// which is not the case when you add fresh user every time
	// in each test.
	
	// 2. Second let's the hardcoded userId is existing on a
	// specific environment (say QA) then the tests will
	// work fine on QA but what if the same userID is not
	// existing on other environments (say STG, UAT, PROD)?
	// Then again the tests will fail on multi-env setup
	// which is not the case when adding fresh user every time.
	

}
