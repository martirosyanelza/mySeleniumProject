package WorkFront;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BasePage {
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "confirmationPassword")
    WebElement confirm;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement regButton;

    public Registration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public Registration enterName(String input){
        waitForElementVisible(name);
        name.sendKeys(input);
        return new Registration(driver);
    }
    public Registration enterEmail(String input){
        waitForElementVisible(email);
        email.sendKeys(input);
        return new Registration(driver);
    }
    public Registration enterPass(String input){
        waitForElementVisible(password);
        password.sendKeys(input);
        return new Registration(driver);
    }
    public Registration enterPassc(String input){
        waitForElementVisible(confirm);
        confirm.sendKeys(input);
        return new Registration(driver);
    }
    public Account submit(){
        waitForElementClickable(regButton);
        regButton.click();
        return new Account(driver);
    }
}
