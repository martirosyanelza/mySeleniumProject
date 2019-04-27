package WorkFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account extends BasePage {
    By user = By.cssSelector(".btn.dropdown-toggle");
    By out = By.cssSelector("a[href='/user/logout']");
    By todo = By.cssSelector("a[href='/user/todos/new']");


    public Account(WebDriver driver) {
        super(driver);
    }
    public void logout(){
        waitForElementClickable(user);
        driver.findElement(user).click();
        waitForElementClickable(out);
        driver.findElement(out).click();
    }
    public String check(){
        waitForElementClickable(user);
        System.out.println(driver.findElement(user).getText());
        return driver.findElement(user).getText();
    }
    public void openTodo(){
        waitForElementClickable(todo);
        driver.findElement(todo).click();
    }
}
