import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class Main {
    public static void main(String[] args) {
        BlogSubscription blogSubscriptionTest = new BlogSubscription();

        blogSubscriptionTest.SetupTestBrowser();
        blogSubscriptionTest.navigation();
        blogSubscriptionTest.printPlaceholders();

//        blogSubscriptionTest.quitBrowser();
    }
}
