package com.cybertek.tests.office_hours;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonsDemo2 extends TestBase {

    @Test
    public  void test() {

        String myUrl = ConfigurationReader.get("url");
        driver.get(myUrl);

        // verify blue is selected by default
        // verify red is not selected by default

        WebElement blue = driver.findElement(By.id("blue"));
        WebElement red = driver.findElement(By.id("red"));

        System.out.println("Blue: "+ blue.isSelected());
        System.out.println("Red: " + red.isSelected());

        System.out.println("Selecting red");

        red.click();

        // verify blue is not selected
        VerificationUtils.verifySelected(blue, false);
        // verify red is selected
        VerificationUtils.verifySelected(red, true);

        // see if element is disabled or enabled

        WebElement green = driver.findElement(By.id("green"));

        System.out.println("Is green enabled: " + green.isEnabled());
        System.out.println("Is red enabled: " + red.isEnabled());

        green.click();

        VerificationUtils.verifySelected(green, false);

    }
}

