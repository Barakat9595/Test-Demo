package HomePageTests;

import BaseTests.BaseTests;
import DataProviders.DataProviders;
import HomePage.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTests extends BaseTests {



    @BeforeMethod //BeforeMethod to make sure it's in the default state before each data set
    public void getBack()
    {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "valid-user", dataProviderClass = DataProviders.class)
    public void testHome(String username, String passwd)
    {
        SoftAssert softAssert = new SoftAssert();
        logger.info("starting test now");
       loginPage.enterName(username);
        loginPage.enterPassword(passwd);
        HomePage homePage = loginPage.clickLogin();
        String module = homePage.getModuleName();
        softAssert.assertEquals(module, "not products"); //fails
        softAssert.assertAll();



    }

    @Test(dataProvider = "csvData", dataProviderClass = DataProviders.class)
    public void testHomeUsingCSV(String username, String passwd)
    {
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterName(username);
        loginPage.enterPassword(passwd);
        HomePage homePage = loginPage.clickLogin();


    }



}
