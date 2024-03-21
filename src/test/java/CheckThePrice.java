import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckThePrice {
    public static WebDriver driver;
    homepage homeobj;
    documentpage docobj;
    String price="Free";
    String elementname="Exchange a Waiver";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
         homeobj = new homepage(driver);
         docobj = new documentpage(driver);
    }

    @Test
    public void clickoncreate() {




        homeobj.gotohome();

        WebElement element = homeobj.findelement();

        homeobj.clickonelement(element);
      String actualprice=  docobj.findelement(elementname);
        Assert.assertEquals(actualprice,price);



    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
