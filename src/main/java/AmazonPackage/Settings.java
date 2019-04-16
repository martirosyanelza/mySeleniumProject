package AmazonPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
    WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, 20);

    public Settings(){
    }

    public Settings(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementVisible(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
