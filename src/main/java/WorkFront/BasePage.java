package WorkFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void waitForElementVisible(WebElement element){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementClickable(WebElement element){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
    }
}
