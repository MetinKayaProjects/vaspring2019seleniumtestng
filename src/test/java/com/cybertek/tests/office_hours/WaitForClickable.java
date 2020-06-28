package com.cybertek.tests.office_hours;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WaitForClickable extends TestBase {


    @Test
    public void testForEnabled(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement button = driver.findElement(By.cssSelector("[onclick='swapInput()']"));
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));

        button.click();

        wait.until(ExpectedConditions.elementToBeClickable(input));

        input.sendKeys("yes master");

    }
}
