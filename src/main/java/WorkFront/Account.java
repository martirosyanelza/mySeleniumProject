package WorkFront;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account extends BasePage {
    @FindBy(css = ".btn.dropdown-toggle")
    WebElement userInfo;
    @FindBy(css = "a[href='/user/logout']")
    WebElement logoutButton;
    @FindBy(css = "a[href='/user/todos/new']")
    WebElement todoButton;

    public Account(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public Homepage logout(){
        waitForElementClickable(userInfo);
        userInfo.click();
        waitForElementClickable(logoutButton);
        logoutButton.click();
        return new Homepage(driver);
    }
    public String check(){
        waitForElementClickable(userInfo);
        return userInfo.getText();
    }
    public CreateTask openTodo(){
        waitForElementClickable(todoButton);
        todoButton.click();
        return new CreateTask(driver);
    }
}
