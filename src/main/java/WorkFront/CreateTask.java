package WorkFront;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateTask extends BasePage {
    @FindBy(id = "title")
    WebElement title;
    @FindBy(id = "dueDate")
    WebElement date;
    @FindBy(xpath = "//th[@class='switch'][1]")
    WebElement month;
    @FindBy(xpath = "//td[contains(text(),'29')]")
    WebElement day;
    @FindBy(id = "priority")
    WebElement priority;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement createButton;

    public CreateTask(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public CreateTask enterTitle(String input){
        waitForElementVisible(title);
        title.sendKeys(input);
        return new CreateTask(driver);
    }
    public CreateTask pickADate(){
        waitForElementVisible(date);
        date.click();
        if(month.getText().contains("April")){
            day.click();
        }
        return new CreateTask(driver);
    }
    public CreateTask choosePriority(){
        waitForElementVisible(priority);
        Select obj = new Select(priority);
        obj.selectByValue("HIGH");
        return new CreateTask(driver);
    }
    public CreateTask createTask(){
        waitForElementClickable(createButton);
        createButton.click();
        return new CreateTask(driver);
    }
}
