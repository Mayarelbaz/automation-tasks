/*import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestCase1 {
    //variables
    WebDriver driver;
    String url="https://www.google.com/";
    String Searchkey="Test Automation";
    String statusvalueid="result-stats";
    //locators
    By SearchBar = new By.ByName("q");// دى طريقه او ممكن زى تحت اكتب



    //kewords
    @Test
    public  void Test(){
        driver= new ChromeDriver();// interface implement  chromeclass
     driver.get(url);// روح يا بروزر لل url ده
     driver.findElement(SearchBar).sendKeys(Searchkey);
     driver.findElement(SearchBar).sendKeys(Keys.ENTER);// Instread of find element by locator it ,and then click on it
        WebElement searchstatistices= driver.findElement(By.id(statusvalueid));
        assertTrue(searchstatistices.isDisplayed());
        assertEquals("حوالى 642,000,000 نتيجة (0.25 ثانية) ",searchstatistices.getText());
        driver.close();




    }
}*/



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import java.io.File;
import java.sql.Driver;
import java.util.List;

public class Test {

     WebDriver driver;
    String username="standard_user";
    String password="secret_sauce";

    By usernameField=By.xpath("//input[@ placeholder='Username']");
    By passwordField=By.id("password");
    By loginField=By.id("login-button");
    By elements = By.className("inventory_item_name");

    @org.testng.annotations.Test
    public void testDemo(){


        driver = new ChromeDriver();



        driver.get("https://www.saucedemo.com/");



        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginField).click();
        WebElement actual=additemtocart("Sauce Labs Backpack");
        //String s=String;
        actual.click();
        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();
        WebElement cartitem=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        Assert.assertEquals(cartitem.getText(),"Sauce Labs Backpack");
        //driver.quit();

    }
    public WebElement additemtocart(String itemname){

        String locator=String.format("//div[@class='inventory_item_name '][contains( text(),'%s')]/../../following-sibling::div/button",itemname);
        WebElement actual=driver.findElement(By.xpath(locator));
        return  actual;


    }
}