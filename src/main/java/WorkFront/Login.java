package WorkFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Registration {
    By email = By.id("email");
    By pass = By.id("password");
    By button = By.xpath("//button[@type='submit']");

    public Login(WebDriver driver) {
        super(driver);
    }
    public void enterEmail(String input){
        waitForElementVisible(email);
        driver.findElement(email).sendKeys(input);
    }
    public void enterPassword(String input){
        waitForElementVisible(pass);
        driver.findElement(pass).sendKeys(input);
    }
    public void login(){
        waitForElementClickable(button);
        driver.findElement(button).click();
    }
}
