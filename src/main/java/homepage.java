import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homepage {

    WebDriver driver;

    // Constructor to accept WebDriver instance
    public homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void gotohome() {
        driver.get("https://www.levelset.com/");
    }

    public WebElement findelement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']")));
    }

    public void clickonelement( WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }
}
