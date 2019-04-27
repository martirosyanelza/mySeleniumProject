package WorkFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration extends BasePage {
    By name = By.id("name");
    By email = By.id("email");
    By pass = By.id("password");
    By confirm = By.id("confirmationPassword");
    By button = By.xpath("//button[@type='submit']");


    public Registration(WebDriver driver) {
        super(driver);
    }
    public void enterName(String input){
        waitForElementVisible(name);
        driver.findElement(name).sendKeys(input);
    }
    public void enterEmail(String input){
        waitForElementVisible(email);
        driver.findElement(email).sendKeys(input);
    }
    public void enterPass(String input){
        waitForElementVisible(pass);
        driver.findElement(pass).sendKeys(input);
    }
    public void enterPassc(String input){
        waitForElementVisible(confirm);
        driver.findElement(confirm).sendKeys(input);
    }
    public void submit(){
        waitForElementClickable(button);
        driver.findElement(button).click();
    }
}
