package seleniumscenarios;

public class WaitConcept {
	// Wait are applied to establish sync between the Selenium scripts
	// and the Browser app.

	// There are 2 kinds of waits in Selenium
	// 1. Static wait: --> FROM JAVA LIBRARY
	// Static wait can be applied through -
	// 1. Thread.sleep(2000);
	// PROBLEM WITH STATIC WAIT(s) like sleep() method:
	// The problem is if an element appears before the wait
	// duration applied even then the script is going to wait
	// for full duration. In contrast, if an element doesn't appear even
	// after the wait duration applied then the wait duration is wasted.
	// For e.g. : If you have applied the wait time of 10 secs
	// and element is coming in just 2 secs then script is going to
	// wait for the remaining 8 secs also which are wasted. Similary,
	// If you have applied the wait time of 10 secs and the element
	// is not appearing after 20 secs then the complete wait duration
	// ( of 10 seconds ) get wasted. To solve this problem we use
	// Dynamic wait.

	// 2. Dynamic wait: --> FROM SELENIUM LIBRARY
	// In Dynamic wait technique if an element is appearing before the wait duration
	// then the rest of the wait duration is cancelled or ignored and script will
	// proceed with the next actions, which saves time. For e.g: If the wait
	// duration is 10 seconds and element is appearing in just 2 seconds then the rest of
	// the 8 seconds get ignored and script proceeds with next action(s) immediately
	// after 2 seconds.
	
	// Similarly, if an element is not appearing even after the full wait duration
	// then we will throw an exception. For e.g: If the wait
	// duration is 10 seconds and element is not appearing even after 10 secs then will
	// throw an exception from the script.
	
	// Dynamic wait is of 2 types:
	// 1. Implicit wait
	// 2. Explicit wait
	
	// Explicit wait is of further 2 types:
	// 1. WebDriver wait
	// 2. Fluent Wait
}
