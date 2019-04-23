package AmazonPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
    WebDriver driver;

    public Settings(WebDriver driver){
        this.driver = driver;
    }
    public void waitForElementVisible(By by){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementClickable(By by){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(by));
    }
}
