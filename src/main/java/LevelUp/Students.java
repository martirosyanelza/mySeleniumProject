package LevelUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Students extends BasePage {
    By myself = By.xpath("//div[@class='info-block flexible vertical aCenter']");
    String text;

    public Students(WebDriver driver){
        super(driver);
    }
    public String findMyself(){
        waitForElementVisible(myself);
        List<WebElement> list = driver.findElements(myself);
        for (WebElement div: list){
            if (div.getText().contains("Elza Martirosyan")) {
                return div.getText();
            }
        }return text;
    }
}
