package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends NavigationBar {
    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);

    }


}
