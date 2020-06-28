package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends NavigationBar {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;


    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

}
