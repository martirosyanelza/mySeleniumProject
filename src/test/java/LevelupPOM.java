import LevelUp.Header;
import LevelUp.HomePage;
import LevelUp.Students;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LevelupPOM {
    WebDriver driver;

    @BeforeClass
    public void precondition(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(description = "find myself in LevelUp")
    public void openLevelup() {
        HomePage page = new HomePage(driver);
        page.openHomepage("https://levelup.am/uk");

        Header header = new Header(driver);
        header.findStudents();

        Students student = new Students(driver);
        Assert.assertTrue(student.findMyself().contains("Elza Martirosyan"));
        System.out.println(student.findMyself());
    }
    @AfterClass
    public void postCondition(){
        driver.close();
        driver.quit();
    }
}
