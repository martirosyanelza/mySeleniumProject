package WorkFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateTask extends BasePage {
    By title = By.id("title");
    By date = By.id("dueDate");
    By month = By.xpath("//th[@class='switch'][1]");
    By day = By.xpath("//td[contains(text(),'29')]");
    By priority = By.id("priority");
    By button = By.xpath("//button[@class='btn btn-primary']");

    public CreateTask(WebDriver driver){
        super(driver);
    }
    public void enterTitle(String input){
        waitForElementVisible(title);
        driver.findElement(title).sendKeys(input);
    }
    public void pickADate(){
        waitForElementVisible(date);
        driver.findElement(date).click();
        if(driver.findElement(month).getText().contains("April")){
            driver.findElement(day).click();
        }
    }
    public void choosePriority(){
        waitForElementVisible(priority);
        Select obj = new Select(driver.findElement(By.id("priority")));
        obj.selectByValue("HIGH");
    }
    public void createTask(){
        waitForElementClickable(button);
        driver.findElement(button).click();
    }
}
