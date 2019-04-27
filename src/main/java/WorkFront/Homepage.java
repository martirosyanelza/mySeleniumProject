package WorkFront;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage{
    @FindBy(xpath = "//ul[@class='nav pull-right']//a[@href='/register']")
    WebElement regButton;
    @FindBy(xpath = "//ul[@class='nav pull-right']//a[@href='/login']")
    WebElement loginButton;

    public Homepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public Homepage open (String url){
        driver.get(url);
        return new Homepage(driver);
    }
    public Registration openRegForm(){
        waitForElementClickable(regButton);
        regButton.click();
        return new Registration(driver);
    }
    public Login openLoginForm(){
        waitForElementClickable(loginButton);
        loginButton.click();
        return new Login(driver);
    }
}
