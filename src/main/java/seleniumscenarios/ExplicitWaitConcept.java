package seleniumscenarios;

public class ExplicitWaitConcept {

	// This class explains:
	// What is explicit wait?
	// Where Could we use explicit wait?

	// There are 2 kinds of Explicit wait:
	// 1. WebDriverWait
	// 2. FluentWait
	// WebDriverWait is a class in JAVA which is extending FluentWait Class.
	// FluentWait further implements Wait Interface. Wait interface has one
	// method named until() which is implemented by the immediate child
	// class i.e, FluentWait. Apart from until() implementation
	// FluentWait has some other methods also.

	// So the hierarchy is like this:

	// WebDriverWait(C) ---> FluentWait(C) ---> Wait(I): until()
	// Inheriting from // until(){}
	// FluentWait // + other methods
	// No Individual method

	// C -> Class, I -> Interface

	// Explicit wait is a wait that is applied to a specific
	// element not globally to all the elements. So. it is
	// not a global wait.

	// Explicit wait could be applied to non-web elements also
	// like title, url, alerts, frames etc.

	// Explicit wait can be applied under different conditions
	// which are provided by ExpectedConditions class.

	// [IMPORTANT]: What is difference between WebDriverWait and FluentWait?
	// Ans: As WebDriverWait is a child of FluentWait and it has no
	// individual methods also, we could say that WebDriverWait is also
	// a kind of FluentWait. So conceptually there is no difference as such.
}
