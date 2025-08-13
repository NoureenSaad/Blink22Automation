import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogSubscription{
    protected WebDriver driver = new ChromeDriver();
    protected String baseURL = "https://www.blink22.com";
    private final By nameFieldLocator = By.id("fullname");
    private final By emailFieldLocator = By.id("email");
    private final By subscriptionButtonLocator = By.id("_form_5_submit");
    private final By cookieButtonLocator = By.id("rcc-confirm-button");
    private final By nameErrorLocator = By.xpath("//input[@id='fullname']/following-sibling::div/div[@class='_error-inner']");
    private final By emailErrorLocator = By.xpath("//input[@id='email']/following-sibling::div/div[@class='_error-inner']");
    private final By thankYouFormLocator = By.xpath("//div[@class='_form-thank-you']");

    @Before
    public void SetupTestBrowser(){
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.navigate().to(baseURL + "/blog");
        closeCookieBanner();
    }

    public void closeCookieBanner() {
        try {
            WebElement cookieButton = driver.findElement(cookieButtonLocator);
            cookieButton.click();
            System.out.println("Cookie banner closed.");
        } catch (Exception e) {
            System.out.println("No cookie banner found.");
        }
    }

    @Test
    public void printPlaceholders() {
        WebElement nameField = driver.findElement(nameFieldLocator);
        WebElement emailField = driver.findElement(emailFieldLocator);

        String namePlaceholder = nameField.getAttribute("placeholder");
        String emailPlaceholder = emailField.getAttribute("placeholder");

        System.out.println("Name placeholder: " + namePlaceholder);
        System.out.println("Email placeholder: " + emailPlaceholder);
    }

    @Test
    public void submitFormWithoutNameAndEmail() {
        driver.findElement(subscriptionButtonLocator).click();

        String nameError = driver.findElement(nameErrorLocator).getText();
        String emailError = driver.findElement(emailErrorLocator).getText();

        System.out.println("Name field error: " + nameError);
        System.out.println("Email field error: " + emailError);
    }

    @Test
    public void submitFormWithoutEmail(){
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.sendKeys("Noureen Saad");

        driver.findElement(subscriptionButtonLocator).click();

        String emailError = driver.findElement(emailErrorLocator).getText();

        System.out.println("Email field error: " + emailError);
    }

    @Test
    public void submitFormWithoutName(){
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys("TestingEmail@gmail.com");

        driver.findElement(subscriptionButtonLocator).click();

        String nameError = driver.findElement(nameErrorLocator).getText();

        System.out.println("Email field error: " + nameError);
    }

    @Test
    public void submitFormWithNameAndEmail(){
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.sendKeys("Noureen Saad");

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys("TestingEmail@gmail.com");

        driver.findElement(subscriptionButtonLocator).click();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));
        WebElement thankYouElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        thankYouFormLocator
                )
        );

        String thankYouMessage = thankYouElement.getText();

        Assert.assertEquals(
                "Thanks for signing up! Check your inbox for your Welcome package!",
                thankYouMessage);

        System.out.println(thankYouMessage);
    }

    @Test
    public void submitFormWithInvalidEmail(){
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.sendKeys("Noureen Saad");

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys("TestingInvalidEmail.email");

        driver.findElement(subscriptionButtonLocator).click();

        String emailError = driver.findElement(emailErrorLocator).getText();

        System.out.println("Email field error: " + emailError);
    }

    @After
    public void quitBrowser(){
        driver.quit();
    }
}
