package WorkFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage{
    By reg = By.xpath("//ul[@class='nav pull-right']//a[@href='/register']");
    By login = By.xpath("//ul[@class='nav pull-right']//a[@href='/login']");



    public Homepage(WebDriver driver) {
        super(driver);
    }
    public void openHomepage(String url){
        driver.get(url);
    }
    public void openRegForm () {
        waitForElementClickable(reg);
        driver.findElement(reg).click();
    }
    public void openLoginForm(){
        waitForElementClickable(login);
        driver.findElement(login).click();
    }
}
