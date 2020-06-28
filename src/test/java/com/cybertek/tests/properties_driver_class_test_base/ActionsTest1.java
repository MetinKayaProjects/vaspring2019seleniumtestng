package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest1 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
        driver.quit();
    }
    @Test
    public void hover() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.tagName("img"));
        //moveToElement() --> move the mouse to given target
        //perform --> triggers the action
        actions.moveToElement(element).perform();

        // Assert.assertTrue(VerificationUtils.isElementDisplayed(driver.By.linkText("View profile")));
    }
    @Test
    public void chainingActions() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(6000);
        WebElement firstOne = driver.findElement(By.cssSelector("#ui-id-3"));
        WebElement secondOne = driver.findElement(By.cssSelector("#ui-id-3"));

        actions.moveToElement(firstOne).pause(1000).moveToElement(secondOne).build().perform();

    }

    @Test
    public void dragDrop() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/keno-ui/dragdrop/index");
        Thread.sleep(1000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        //click and hold source
        //move
        //let it go

        actions.clickAndHold(source).pause(1000).
                moveToElement(target).pause(1000).
                release().build().perform();

    }
}