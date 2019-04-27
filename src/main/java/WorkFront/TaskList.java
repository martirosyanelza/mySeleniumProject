package WorkFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskList extends BasePage{
    By title = By.xpath("//tbody/tr/td[2]");

    public TaskList(WebDriver driver){
        super(driver);
    }
    public String checkTask(){
        waitForElementVisible(title);
        return driver.findElement(title).getText();
    }
}
