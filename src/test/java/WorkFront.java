import WorkFront.Homepage;
import WorkFront.Registration;
import WorkFront.Account;
import WorkFront.Login;
import WorkFront.CreateTask;
import WorkFront.TaskList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkFront {
    WebDriver driver;

    @BeforeClass
    public void precondition(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    public void Homework(){
        Homepage page = new Homepage(driver);
        page.open("https://ancient-taiga-22967.herokuapp.com/");
        page.openRegForm();

        new Registration(driver).enterName("elza")
                .enterEmail("elza+11@gmail.com")
                .enterPass("nbnbnb")
                .enterPassc("nbnbnb")
                .submit();

        Account account = new Account(driver);
        account.logout();
        page.openLoginForm();

        new Login(driver).enterEmail("elza+11@gmail.com")
                .enterPassword("nbnbnb")
                .login();
        Assert.assertTrue(account.check().contains("elza"));

        account.openTodo();

        new CreateTask(driver).enterTitle("Workfront homework")
                .pickADate()
                .choosePriority()
                .createTask();

        TaskList list = new TaskList(driver);
        Assert.assertTrue(list.checkTask().contains("homework"));
    }
    @AfterClass
    public void postCondition(){
        driver.close();
        driver.quit();
    }
}
