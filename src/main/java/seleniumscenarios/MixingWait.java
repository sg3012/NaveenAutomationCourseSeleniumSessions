package seleniumscenarios;

public class MixingWait {
	
	// This class some cases where we apply both implicit
	// and Explicit waits on a page/elements.

	public static void main(String[] args) {
		// [CASE STUDY] : Let's say we have applied both implicit wait
		// at global level on a page (say, Login page) and explicit
		// wait on an element on the same page (say, username field)
		// then how will the waits be applied ? Is it
		// the combination of both waits or just any one of the
		// waits ?
		// Let's assume we have defined a total implicit wait of
		// 10 secs and explicit wait of 15 secs for username field then
		// following can be the total times in which the username field is found
		// on the page
		
		
		// USERNAME:
		// ImpWait: Total - 10 secs --> Element found in 2 secs
		// WebDWait(Explicit wait): Total time - 15 secs --> Element found in 5 secs
		// Total time in which element is found: 7 secs (Rest of the time will be ignored)
		
		// ImpWait: Total - 10 secs --> Element found in 9 secs
		// WebDWait(Explicit wait): Total time - 15 secs --> Element found in 14 secs
        // Total time in which element is found: 23 secs (Rest of the time will be ignored)
		
		// ImpWait: Total - 10 secs --> Element found in 10 secs
		// WebDWait(Explicit wait): Total time - 15 secs --> Element found in 14 secs
		// Total time in which element is found: 24 secs (Rest of the time will be ignored)
		
		// ImpWait: Total - 10 secs --> Element not found in 10 secs
		// WebDWait(Explicit wait): Total time - 15 secs --> Element found in 15 secs
		// Total time in which element is found: 25 secs (Rest of the time will be ignored)
		
		// ImpWait: Total - 10 secs --> Element found in 9 secs
		// WebDWait(Explicit wait): Total time - 15 secs --> Element found in 1 secs
		// Total time in which element is found: 10 secs (Rest of the time will be ignored)
		
		// So, if we observe the above case study it is a bad idea to use both the waits
		// on a single page as selenium accumulates both the wait times (if they are used)
		// and try to find the element using both waits. So the overall time
		// in which the element is found increases if we use both the waits instead
		// of just single one. So, if an element was found in 9 secs using ImpWait
		// and we have applied explicit wait too using which element is getting
		// located in 10 secs then the overall time to locate the element is 10 secs
		// which would have been only 1 sec if we would have used only Explicit or WebDriverWait.
		// Mixing both the waits would BADLY impact the PERFORMANCE OF THE SCRIPT.
		
	}

}
