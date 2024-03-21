import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class documentpage {
    WebDriver driver;

    public documentpage(WebDriver driver) {
        this.driver = driver;
    }
    public String findelement(String itemname) {
        String locator=String.format("//div[@class=\"left\"][contains( text(),'%s')]/following-sibling::div/span[@class=\"price-amount\"]",itemname);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
    }
  }
