class WebPage{
    public String url;
    public String content;
    WebPage(String url, String content) {
	this.url = url;
	this.content = content;
    }
    public void display() {
	System.out.println("URL: " + url);
	System.out.println("Content: <html>" + content + "</html>\n");
    }
}

/* Doubly Linked list Node*/
class HistoryState {
    public WebPage page;
    public HistoryState prev;
    public HistoryState next;

    // Constructor to create a new state
    // next and prev is by default initialized as null
    HistoryState(WebPage p) { page = p; }
}

class BrowserHistory {
    public HistoryState current;
    public WebPage errorPage;
    BrowserHistory() {
	current = null;
	errorPage = new WebPage(null, "404 not found");
    }

    public WebPage back() {
	// current can be null
	// current.prev can be null
	if (current == null){
	    System.out.println("No valid current page!");
	    return errorPage;
	}
	if (current.prev == null){
	    System.out.println("No valid page to go back to! Staying on page:");
	    return current.page;
	}
	current = current.prev;
	return current.page;
    }

    public WebPage navigate(String url, String content){
	WebPage newpage = new WebPage(url, content);
	HistoryState newstate = new HistoryState(newpage);
	if(current == null){
	    current = newstate;
	}
	else{
	    current.next = newstate;
	    newstate.prev = current;
	    current = newstate;
	}
	return newpage;
    }

    public WebPage forward() {
	if (current == null){
	    System.out.println("No valid current page!");
	    return errorPage;
	}
	if (current.next == null){
	    System.out.println("No valid page to go forward to! Staying on page:");
	    return current.page;
	}
	current = current.next;
	return current.page;
    }
    // Implement needed methods here
    // 3. forward
}

public class Browser {
    public static void main(String[] args) {
	BrowserHistory history = new BrowserHistory();

	history.back().display();

	history.navigate("www.nyu.edu", "We love purple").display();
	history.navigate("www.google.com", "search for stuff").display();
	history.navigate("www.yahoo.com", "did you get lost looking for google?").display();
	history.navigate("www.amazon.com", "buy stuff").display();
	
	history.forward().display();

	history.back().display();
	history.back().display();

	history.navigate("www.facebook.com", "search for friends").display();
	history.forward().display();

	history.back().display();
	history.back().display();
	history.back().display();

	history.forward().display();
	history.forward().display();
    }
}