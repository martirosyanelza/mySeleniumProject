import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Amazon {

    WebDriver driver;
    @BeforeClass
    public void precondition(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Test(description = "find a headphone in Amazon.com")
    public void searchHeadphones(){

        driver.get("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("headphones");
        driver.findElement(By.cssSelector(".nav-search-submit")).click();
        driver.findElement(By.xpath("//div[@data-cel-widget='search_result_1']//h5")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        String openLinkNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.xpath("//div[@role='dialog']//a[@href='/gp/cart/view.html/ref=uss_cart']")).sendKeys(openLinkNewTab);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='nav-cart-count']")).getText(), "1");

    }
    @AfterClass
    public void postCondition(){
        driver.close();
        driver.quit();
    }
}
