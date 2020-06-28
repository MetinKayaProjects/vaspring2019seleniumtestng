package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestBase {


    @BeforeMethod
    public void setUpMethod2() {

        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void loginDriverTest() {
        // give name to the test
        extentLogger = report.createTest("Positive login as Driver");
        // prints the passed string to the report, used to capture test steps ...
        extentLogger.info("Getting user credentials");
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Entering username and password");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);

        extentLogger.info("Clicking on submit");
        loginPage.submit.click();

        BrowserUtils.waitFor(2);

        extentLogger.info("Verifying title contains Dashboard");
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
        extentLogger.pass("PASSED: Positive login as Driver");

    }

    @Test
    public void loginSalesManager() {
        // give name to the test
        extentLogger = report.createTest("Positive login as Sales manager");
        // prints the passed string to the report, used to capture test steps ...
        extentLogger.info("Getting user credentials");
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_username");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Entering username and salesmanager_password");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);

        extentLogger.info("Clicking on submit");
        loginPage.submit.click();

        BrowserUtils.waitFor(2);

        extentLogger.info("Verifying title contains Dashboard");
        Assert.assertTrue(driver.getTitle().contains("Dashboard"),
                "Title did not contain Dashboard");
        extentLogger.pass("PASSED: Positive login as Sales manager");    }

}









