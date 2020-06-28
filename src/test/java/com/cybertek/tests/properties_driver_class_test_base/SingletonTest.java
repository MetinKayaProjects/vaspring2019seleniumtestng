package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){
        String str1 = Singleton.getInstance();

        String str2 = Singleton.getInstance();

        Singleton.getInstance();
        Singleton.getInstance();
        Singleton.getInstance();

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

    }

    @Test
    public void test1(){
       // Driver.get() --> open a new browser if there is not browser and return it
        WebDriver driver = Driver.get();

        driver.get("https://google.com");

    }

    @Test
    public void test2(){

        Driver.get().get("https://amazon.com");
        String title = Driver.get().getTitle();
        
        System.out.println(title);
    }
}
