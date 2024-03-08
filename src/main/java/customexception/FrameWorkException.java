package customexception;

public class FrameWorkException extends RuntimeException {
 
	public FrameWorkException(String mesg) {
		super(mesg);
	}
	
	
	// (INTERVIEW): Why are we creating a custom exception class and creating our
	// own exception, even though we can either throw the exception or 
	// handle the exception using try/catch block in the same class where exception
	// has occurred ? What is the advantage of using custom exception ?
	
	// Ans : Now, if we are not creating a custom exception and using either throw or try/catch block
	// there will be following problems:
	// Problem 1: if we are just throwing the exception from the method or class where the actual
	// exception has occurred then the class/method using that method has to handle the exception
	// instead of the method which is the actual culprit for the exception, which is not the right
	// practice.
	
	// Problem 2: if we have a lot of lines of code and there might be some exceptions in multiple
	// places in that huge code and we are handling each exception using try/catch block
	// then we have to write the try-catch block multiple times within the same
	// code again and again, which will be repetitive and ugly. 
	
	// So to eliminate both these problems we have written a single utility for custom
	// exception where we could pass our own custom message as part of handling that exception
	// and we are handling those in the same method which is the actual CULPRIT.
	
}
