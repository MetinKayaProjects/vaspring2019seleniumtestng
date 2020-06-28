package com.cybertek.tests.office_hours;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BriteERPTest extends TestBase {
    String url = "http://54.148.96.210/";
    String singIn = "#top_menu > li:nth-child(10) > a";
    String email = "input[name='login']";
    String password = "input[name='password']";
    String loginButton = "button[type='submit']";
    String CRM_Moduel = "//nav/div/ul/li/a/span[@class='oe_menu_text' and contains(text(), 'CRM')]";
    String createButton1 = "button[accesskey=c]";
    String opporunityTitle = "input.o_field_char.o_field_widget.o_input.o_required_modifier";
    String customerInputCSS = "div[name='partner_id'] input[id^='o_field_input_']";
    String createOppoButton = "button[name=close_dialog]";
    String createContactButtonXpath = "(//div[@class='modal-content']//button[.='Create'])[2]";
    String listBtn = "button[data-view-type='list']";
    String deleteBtn = "a[data-index='3']";
    String oprtCheckBox = "(//input[1])[7]";
    String action = "//button[contains(text(), 'Action')]";
    String confirmOKbutton = "//span[contains(text(), 'Ok')]";


    @Test
    public void test() {
        driver.get(url);
        driver.findElement(By.cssSelector(singIn)).click();
        String signInPage = driver.getTitle();
        driver.findElement(By.cssSelector(email)).sendKeys("Lunch_InvoicingManager4@info.com");
        driver.findElement(By.cssSelector(password)).sendKeys("LD686gfX25");
        driver.findElement(By.cssSelector(loginButton)).click();
        String inboxPage = driver.getTitle();
        driver.findElement(By.xpath(CRM_Moduel)).click();
//        BrowserUtils.waitFor(3);

        driver.findElement(By.cssSelector(createButton1)).click();
        driver.findElement(By.cssSelector(opporunityTitle)).sendKeys("Great opportunity");
        String name = new Faker().name().fullName();

        driver.findElement(By.cssSelector(customerInputCSS)).sendKeys(name);

        driver.findElement(By.cssSelector(createOppoButton)).click();
        driver.findElement(By.xpath(createContactButtonXpath)).click();
        driver.findElement(By.cssSelector(createOppoButton)).click();

//        BrowserUtils.waitFor(3);
//        waitFotOFormSheet();
//        driver.findElement(By.cssSelector(listBtn)).click();
        BrowserUtils.clickWithJS(driver.findElement(By.cssSelector(listBtn)));
//        BrowserUtils.waitFor(3);
        String act = driver.getTitle();
        String exp = "Pipeline - Odoo";
        Assert.assertEquals(act, exp);
        driver.findElement(By.xpath(oprtCheckBox)).click();
                BrowserUtils.waitFor(3);
        driver.findElement(By.xpath(action)).click();
        driver.findElement(By.cssSelector(deleteBtn)).click();
        driver.findElement(By.xpath(confirmOKbutton)).click();

    }

    public void waitFotOFormSheet(){
        wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(listBtn)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("o_form_sheet")));
    }
}
