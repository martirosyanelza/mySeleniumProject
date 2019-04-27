package WorkFront;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskList extends BasePage{
    @FindBy(xpath = "//tbody/tr/td[2]")
    WebElement title;

    public TaskList(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public String checkTask(){
        waitForElementVisible(title);
        return title.getText();
    }
}
