package AmazonPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends Settings {
    By searchInput = By.id("twotabsearchtextbox");
    By searchButton = By.cssSelector(".nav-search-submit");

    public Homepage(WebDriver driver) {
        super(driver);
    }
    public void openHomepage(String url){
        driver.get(url);
    }
    public void performSearch (String input){
        waitForElementVisible(searchInput);
        driver.findElement(searchInput).sendKeys(input);
        waitForElementClickable(searchButton);
        driver.findElement(searchButton).click();
    }
}
