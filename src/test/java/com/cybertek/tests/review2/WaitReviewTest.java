package com.cybertek.tests.review2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitReviewTest extends TestBase {

    @Test
    public void implicitWaitTest() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        WebElement message = driver.findElement(By.id("finish"));

        WebElement message2 = driver.findElement(By.id("finish"));

        System.out.println(message.getText());
    }


    @Test
    public void implicitWaitTest2() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");

        driver.findElement(By.tagName("button")).click();

        WebElement message = driver.findElement(By.id("finish"));

        System.out.println(message.getText());
    }


    @Test
    public void waitForInvisibleExplicitTest() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        // 1. until --> this is when waiting starts
        // 2. ExpectedConditions.invisibilityOfElementLocated   --> what are we waiting for
        // 3. which element  --> By.id("id")
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("lasasoading")));
        WebElement message = driver.findElement(By.id("finish"));
        System.out.println(message.getText());

    }

    @Test
    public void waitForInvisibleExplicitTest2() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.tagName("button"));


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submit.click();

    }


    @Test
    public void testTitle() throws InterruptedException {
        driver.get("http://qa3.vytrack.com");

        VytrackUtils.login(driver, "salesmanager120", "UserUser123");

        System.out.println(driver.getTitle());
        VytrackUtils.selectMenuOption(driver, "Fleet", "Vehicles");
        // waits until title changes and contains string 'Car'
        wait.until(ExpectedConditions.titleContains("Car"));
        System.out.println(driver.getTitle());

    }

}
