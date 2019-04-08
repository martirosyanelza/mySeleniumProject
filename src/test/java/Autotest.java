import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class Autotest {

    WebDriver driver;
    @BeforeClass
    public void precondition(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test(description = "find Mercedes in Auto.am")
            public void searchTest() throws InterruptedException{

            driver.get("https://auto.am/");
        Thread.sleep(3000);
            driver.manage().window().maximize();
            WebElement searchMake = driver.findElement(By.xpath("//*[contains(@aria-labelledby,'make-container')]"));
            searchMake.click();
            Select objMake = new Select(driver.findElement(By.id("filter-make")));
            objMake.selectByVisibleText("Mercedes-Benz");

        Thread.sleep(5000);
            WebElement searchModel = driver.findElement(By.xpath("//*[contains(@aria-labelledby,'model-container')]"));
            searchModel.click();
            Select objModel = new Select(driver.findElement(By.id("v-model")));
            objModel.selectByVisibleText("E 350");

        Thread.sleep(3000);
            WebElement searchYearFrom = driver.findElement(By.xpath("//*[contains(@aria-labelledby,'yeargt')]"));
            searchYearFrom.click();
            Select objFrom = new Select(driver.findElement(By.name("year[gt]")));
            objFrom.selectByVisibleText("2011");

        Thread.sleep(3000);
            WebElement searchYearTo = driver.findElement(By.xpath("//*[contains(@aria-labelledby,'yearlt')]"));
            searchYearTo.click();
            Select objTo = new Select(driver.findElement(By.name("year[lt]")));
            objTo.selectByVisibleText("2019");

        Thread.sleep(3000);
            WebElement searchCheckbox = driver.findElement(By.xpath("//div[@class='col s12 m12 l12 pad-top-12 home-filters-switch']//following::label[1]"));
            searchCheckbox.click();

        Thread.sleep(2000);
            WebElement searchButton = driver.findElement(By.cssSelector("#search-btn"));
            searchButton.click();

        Thread.sleep(7000);
            WebElement searchFirstElement = driver.findElement(By.xpath("//div[@id='search-result']/child::div[1]/child::div[1]"));
            searchFirstElement.click();

        Thread.sleep(7000);
        WebElement searchPrice= driver.findElement(By.xpath("//div[contains(@class,'top-price')]//ul"));
        List<WebElement> priceList = searchPrice.findElements(By.tagName("li"));
        for (WebElement li : priceList) {
            if (li.getText().contains("$")) {
                System.out.println("Mercedes-Benz price in US dollars is " + li.getText());
            }else if (li.getText().contains("֏")) {
                System.out.println("Mercedes-Benz price in AM drams is " + li.getText());
            }
        }
        Thread.sleep(5000);
    }
    @AfterClass
    public void postCondition(){
        driver.close();
        driver.quit();
    }
}
