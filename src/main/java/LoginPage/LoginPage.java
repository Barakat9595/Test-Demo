package LoginPage;

import HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By usernameField = By.name("user-name");
    private By passwordField = By.name("password");
    private By submitBtn = By.id("login-button");
    private By errorBox = By.xpath("//div[@class='error-message-container error']");

    public void enterName(String username)
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitBtn)));
    }

    public HomePage clickLogin()
    {

         driver.findElement(submitBtn).click();
         return new HomePage(driver);
    }
    public String getError()
    {
        return driver.findElement(errorBox).getText();

    }


}
