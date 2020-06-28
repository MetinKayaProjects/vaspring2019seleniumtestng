package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehiclesPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VytrackUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class VehiclesPageTests extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        // creating a new page object and using
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Test
    public void testFirstHeaderOption() {


        // create and use object in the same line. object is not saved
        new DashboardPage().selectMenuOption("Fleet", "Vehicles");

        // verify that first col name is license plate
        String expectedCol = "LICENSE PLATE";

        VehiclesPage vehiclesPage = new VehiclesPage();
        BrowserUtils.waitFor(2);
        WebElement firstColumn = vehiclesPage.gridHeaders.get(0);

        Assert.assertEquals(firstColumn.getText(), expectedCol);

    }


    @Test
    public void removeGridHeaderTest() {
        new DashboardPage().selectMenuOption("Fleet", "Vehicles");

        VehiclesPage vehiclesPage = new VehiclesPage();
        VytrackUtils.waitForUIOverlay();
        vehiclesPage.gridSettings.click();

        WebElement licensePlateCh = vehiclesPage.gridSettingsCheckbox("License Plate");

        Assert.assertTrue(licensePlateCh.isSelected(), "Checkbox should be checked");
        licensePlateCh.click();

        List<WebElement> allGridHeaders = vehiclesPage.gridHeaders;

        for (WebElement element : allGridHeaders) {
            if (element.getText().equals("LICENSE PLATE")) {
                Assert.fail("LICENSE PLATE should not be displayed");
            }
        }

    }
}
