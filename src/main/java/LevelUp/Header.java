package LevelUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage{
    By students = By.xpath("//ul[@class='flexible aCenter']//a[@href='/students/uk']");

    public Header(WebDriver driver){
        super(driver);
    }
    public void findStudents(){
        waitForElementClickable(students);
        driver.findElement(students).click();
    }
}
