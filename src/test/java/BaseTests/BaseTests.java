package BaseTests;

import LoginPage.LoginPage;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class BaseTests {
    protected WebDriver driver;  //protected to get inherited for the @afterMethod annotation
    protected LoginPage loginPage;
    protected Logger logger;
    @BeforeClass
    public void setUpStartingPoint()
    {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger = Logger.getLogger(getClass());
        logger.info("✅ Starting Browser");

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
        logger.info("browser closed");
    }



}
