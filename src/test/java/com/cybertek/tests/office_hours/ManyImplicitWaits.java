package com.cybertek.tests.office_hours;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ManyImplicitWaits {

    @Test
    public void manyImplicitWaits(){

        WebDriver driver = Driver.get();

        // waits when findElement method cannot find the element
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // wait for page to load completely
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // waits for javascript processes in the page to finish
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);



    }

}
