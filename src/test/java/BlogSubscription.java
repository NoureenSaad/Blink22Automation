import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BlogSubscription extends Setup {
    public void navigation(){
        driver.navigate().to(baseURL + "/blog");
    }

    public void printPlaceholders(){
        WebElement nameField = driver.findElement(By.id("fullname"));
        String namePlaceholder = nameField.getAttribute("placeholder");
        WebElement emailField = driver.findElement(By.id("email"));
        String emailPlaceholder = emailField.getAttribute("placeholder");

        System.out.println("Name placeholder: " + namePlaceholder);
        System.out.println("Email placeholder: " + emailPlaceholder);
    }

}
