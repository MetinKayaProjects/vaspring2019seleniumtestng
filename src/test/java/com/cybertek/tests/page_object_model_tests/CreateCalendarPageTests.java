package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VytrackUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCalendarPageTests extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void repeatOptionsTest(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        VytrackUtils.waitForUIOverlay();


        calendarEventsPage.createCalendarEvent.click();

        calendarEventsPage.createCalendarEvent.click();





        VytrackUtils.waitForUIOverlay();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        String selectedValue = createCalendarEventsPage.repeatOptionsList().getFirstSelectedOption().getText();
        System.out.println(selectedValue);

        Assert.assertEquals(selectedValue, "Daily");


    }
}
