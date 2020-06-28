package com.cybertek.tests.pasha_did_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BritePavelUtils {




        //TODO LOGIN
        public static void login(WebDriver driver, String username, String password) throws InterruptedException {

            driver.findElement(By.id("login")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password+ Keys.ENTER);
            Thread.sleep(1000);
        }


        //TODO Tab menu line
        public static void modules(WebDriver driver,String menuOption){

            driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'"+menuOption+"')]")).click();
        }

        //TODO Tab menu on the left side
        public static void leftMenu (WebDriver driver,String menuOption){

            driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'"+menuOption+"')]")).click();
        }






    }

