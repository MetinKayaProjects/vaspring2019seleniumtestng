package com.cybertek.tests.office_hours;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class OODashboardPage {
    public OODashboardPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    OONavigationBar navigationBar = new OONavigationBar();


}
