import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class Main {
    public static WebDriver driver = new ChromeDriver();
    public static String baseURL = "https://www.blink22.com";
    public static void main(String[] args) {
        manageScreen();
        openBrowser(baseURL);
        navigation("/blog");
        quitBrowser();
    }

    public static void openBrowser(String url){
        driver.get(url);
    }
    public static void navigation(String url){
        driver.navigate().to(baseURL + url);
    }
    public static void manageScreen(){
        driver.manage().window().maximize();
    }

    public static void quitBrowser(){
        driver.quit();
    }
}
