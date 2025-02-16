package BaseTests;

import LoginPage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver driver;  //protected to get inherited for the @afterMethod annotation
    protected LoginPage loginPage;

    @BeforeClass
    public void setUpStartingPoint()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
   @AfterClass
    public void tearDown()
    {
        driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
        driver.quit();
    }



}
