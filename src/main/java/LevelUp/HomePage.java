package LevelUp;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }
    public void openHomepage(String url){
        driver.get(url);
    }
}
