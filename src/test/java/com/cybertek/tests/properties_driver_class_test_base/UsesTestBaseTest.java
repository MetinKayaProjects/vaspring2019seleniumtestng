package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class UsesTestBaseTest extends TestBase {

    @Test
    public void test() {
        // driver
        driver.get("https://google.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void test2() {
        // sales manager
        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void test3() {

        driver.get("https://ebay.com");
        System.out.println(driver.getTitle());

    }
}
