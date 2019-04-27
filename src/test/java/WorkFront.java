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
        page.openHomepage("https://ancient-taiga-22967.herokuapp.com/");
        page.openRegForm();

        Registration reg = new Registration(driver);
        reg.enterName("elza");
        reg.enterEmail("elza+9@gmail.com");
        reg.enterPass("nbnbnb");
        reg.enterPassc("nbnbnb");
        reg.submit();

        Account account = new Account(driver);
        account.logout();
        page.openLoginForm();

        Login login = new Login(driver);
        login.enterEmail("elza+9@gmail.com");
        login.enterPassword("nbnbnb");
        login.login();
        Assert.assertTrue(account.check().contains("elza"));

        account.openTodo();

        CreateTask task = new CreateTask(driver);
        task.enterTitle("Workfront homework");
        task.pickADate();
        task.choosePriority();
        task.createTask();

        TaskList list = new TaskList(driver);
        Assert.assertTrue(list.checkTask().contains("homework"));
    }
    @AfterClass
    public void postCondition(){
        driver.close();
        driver.quit();
    }
}
