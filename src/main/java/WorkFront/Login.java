package WorkFront;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePage {
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public Login enterEmail(String input){
        waitForElementVisible(email);
        email.sendKeys(input);
        return new Login(driver);
    }
    public Login enterPassword(String input){
        waitForElementVisible(password);
        password.sendKeys(input);
        return new Login(driver);
    }
    public Account login(){
        waitForElementClickable(loginButton);
        loginButton.click();
        return new Account(driver);
    }
}
