import AmazonPackage.MyCard;
import AmazonPackage.SearchResults;
import AmazonPackage.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class AmazonPOM{
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
        Homepage page = new Homepage(driver);
        page.openHomepage("https://www.amazon.com");
        page.performSearch("headphones");

        SearchResults result = new SearchResults(driver);
        result.elementName();
        result.chooseElement();
        result.addToCard();
        result.viewCard();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        MyCard card = new MyCard(driver);
        Assert.assertEquals(result.elementName(),card.checkItem());
    }

    @AfterClass
    public void postCondition(){
        driver.close();
        driver.quit();
    }
}
