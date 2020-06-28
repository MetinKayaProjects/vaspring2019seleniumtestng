package com.cybertek.tests.pasha_did_demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BriteErp {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //TODO create Implicit wait

        driver.get("http://54.148.96.210/web/login");
    }

    @AfterMethod
    public void closeBrowser(){
        //driver.close();
    }



    @Test(description = "Lunch Invoicing Manager should be able to create new bank account",
            priority = 1)
    public void test1() throws InterruptedException {


            /*Click on module" Contacts" on the top line
              Click "Bank Accounts"
              Click "Create"
              Enter Account number in "Account Number" field
              Enter ABA/Routing number in "ABA/Routing" field
              Enter Bank name in "Bank" field
              Click "Save"
              Verified if saved
            */

        //TODO password and username credentials
        String username = "Lunch_InvoicingManager4@info.com";
        String password = "LD686gfX25";

        //TODO calling method
        BritePavelUtils.login(driver,username,password);




        Thread.sleep(3000);
        //TODO calling method (access Contacts)
        BritePavelUtils.modules(driver,"Contacts");

        Thread.sleep(2000);

        //TODO calling method (access Bank Accounts)
        BritePavelUtils.modules(driver,"Bank Accounts");

        Thread.sleep(2000);

        //TODO  (access Bank Accounts)Used css from parent to child
        driver.findElement(By.cssSelector("a[data-action-id='56']>span")).click();



        //TODO click create button (used css -starts with, ends with) I use JavaScript since Create button didnt click
        //TODO and also i used Explicit time, because it takes 4 sec to Create button appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class^='btn btn-primary'][class$='button_add']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class^='btn btn-primary'][class$='button_add']")));
        WebElement create = driver.findElement(By.cssSelector("button[class^='btn btn-primary'][class$='button_add']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",create);

        Thread.sleep(2000);


        //TODO Enter account number(9 digits)
        driver.findElement(By.name("acc_number")).sendKeys("111222333");


        //TODO Enter Routing number (9 digits)
        driver.findElement(By.name("aba_routing")).sendKeys("111222333");

        Thread.sleep(2000);


        //TODO click Save
        driver.findElement(By.xpath("//button[@accesskey='s']")).click();

        Thread.sleep(2000);


        //TODO  check if Bank Account is created
        WebElement AccNumber = driver.findElement(By.name("acc_number"));
        WebElement  RoutNumber = driver.findElement(By.name("aba_routing"));

        try{
            AccNumber.isDisplayed() ;
            System.out.println("Your account number is: "+AccNumber.getText());
            RoutNumber.isDisplayed() ;
            System.out.println("Your routing number is: "+RoutNumber.getText());
        }catch(Exception e){
            System.out.println("Bank Account is not created");
        }
    }
}

