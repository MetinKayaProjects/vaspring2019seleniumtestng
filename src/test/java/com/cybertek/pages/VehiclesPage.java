package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesPage extends NavigationBar {

    public VehiclesPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(css = "div[class='page-size pull-right form-horizontal'] button[data-toggle='dropdown']")
    public WebElement viewPerPage;

    @FindBy(css = "a[title='Filters']")
    public WebElement filters;

    @FindBy(css = "a[title='Refresh']")
    public WebElement refresh;

    @FindBy(css = "a[title='Reset']")
    public WebElement reset;

    @FindBy(css = "a[title='Grid Settings']")
    public WebElement gridSettings;

    @FindBy(css = "table.table-bordered th")
    public List<WebElement> gridHeaders;

    public WebElement gridSettingsCheckbox(String header) {
        String xpath = "//label[.='"+header+"']/../../td[last()]/input";
        return Driver.get().findElement(By.xpath(xpath));
    }

}









