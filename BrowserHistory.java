import java.util.Stack;

public class BrowserHistory {

    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage;

    public BrowserHistory(String homepage) {
        this.currentPage = homepage;
    }

    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
    }

    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        }
    }

    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        }
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("homepage.com");

        browserHistory.visit("page1.com");
        browserHistory.visit("page2.com");
        browserHistory.visit("page3.com");

        System.out.println("Current Page: " + browserHistory.getCurrentPage()); // page3.com

        browserHistory.back();
        System.out.println("After going back, Current Page: " + browserHistory.getCurrentPage()); // page2.com

        browserHistory.back();
        System.out.println("After going back again, Current Page: " + browserHistory.getCurrentPage()); // page1.com

        browserHistory.forward();
        System.out.println("After going forward, Current Page: " + browserHistory.getCurrentPage()); // page2.com

        browserHistory.visit("page4.com");
        System.out.println("After visiting a new page, Current Page: " + browserHistory.getCurrentPage()); // page4.com

        browserHistory.forward();
        System.out.println("After trying to go forward, Current Page: " + browserHistory.getCurrentPage()); // page4.com (no change)
    }
}