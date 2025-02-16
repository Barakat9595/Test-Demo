package LoginPageTests;

import BaseTests.BaseTests;
import DataProviders.DataProviders;
import HomePage.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTests extends BaseTests {

    @BeforeMethod //BeforeMethod to make sure it's in the default state before each data set
    public void getBack()
    {
     driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "valid-user", dataProviderClass = DataProviders.class)
    public void e2eLoginScenario(String user, String passwd)
    {
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterName(user);
        loginPage.enterPassword(passwd);
        HomePage homePage = loginPage.clickLogin();
        softAssert.assertTrue(homePage.getTabTitle().contains("Swag Labs"));
        softAssert.assertAll();
    }

    @Test(dataProvider = "invalid-users", dataProviderClass = DataProviders.class)
    public void testInvalidScenarios(String user, String passwd, String validationMsg)
    {
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterName(user);
        loginPage.enterPassword(passwd);
        loginPage.clickLogin();
        String error = loginPage.getError();
        softAssert.assertTrue(error.contains(validationMsg));
        softAssert.assertAll();

    }


}
