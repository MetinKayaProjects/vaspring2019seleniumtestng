package com.cybertek.tests.office_hours;

import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OOLoginPage {

    public static void main(String[] args) {
        // TODO INHERITANCE
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.selectMenuOption("Fleet", "Vehicles");

        // TODO HAS-A
        OODashboardPage ooDashboardPage = new OODashboardPage();

        ooDashboardPage.navigationBar.selectMenuOption("Fleet", "Vehicles");

    }


    public OOLoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name="_username")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy (id = "_submit")
    public WebElement submit;


    public void login(String usernameStr, String passwordStr){
        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        submit.click();

        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.titleIs("Dashboard"));

    }

}
