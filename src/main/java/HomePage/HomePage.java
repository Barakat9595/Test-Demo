package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By moduleTitle = By.xpath("//div[@class='header_secondary_container']/span");
    private By sideList = By.xpath("//div[@class='bm-burger-button']");
    private By logoutOption = By.xpath("//a[text()='Logout']");
    private By socialMediaIcon = By.xpath("//li[@class='social_twitter']//a[1]");

    public String getModuleName()
    {
        return driver.findElement(moduleTitle).getText();
    }
    public void clickSideList()
    {
        driver.findElement(sideList).click();
    }

    public String getTabTitle()
    {
        return driver.getTitle();
    }

    public void scrollToSocialMediaIcon()
    {
        WebElement icon = driver.findElement(socialMediaIcon);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, icon); //javascript method
    }

}
