import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    public static WebDriver driver = new ChromeDriver();
    public static String baseURL = "https://www.blink22.com";

    public void SetupTestBrowser(){
        manageScreen();
        openBrowser(baseURL);
    }
    public void openBrowser(String url){
        driver.get(url);
    }
    public void manageScreen(){
        driver.manage().window().maximize();
    }

    public void quitBrowser(){
        driver.quit();
    }
}
