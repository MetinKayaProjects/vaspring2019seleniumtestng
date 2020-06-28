package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

public class LoginNegativeTests extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void blankUsernameAndPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://qa3.vytrack.com/user/login");

    }


    @Test
    public void wrongCredentialsTest(){
        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys("superuser");
        loginPage.password.sendKeys("password");
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://qa3.vytrack.com/user/login");

    }

}











