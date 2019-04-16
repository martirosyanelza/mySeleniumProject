package AmazonPackage;

import org.openqa.selenium.By;

public class Homepage extends Settings {
    By searchInput = By.id("twotabsearchtextbox");
    By searchButton = By.name("nav-search-submit");

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
