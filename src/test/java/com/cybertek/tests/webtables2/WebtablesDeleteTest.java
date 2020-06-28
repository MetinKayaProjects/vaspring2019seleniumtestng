package com.cybertek.tests.webtables2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebtablesDeleteTest extends TestBase {

    /**
     * click on delete link for tconway@earthlink.net
     * verify tconway@earthlink.net does not exist in emails table
     */
    @Test
    public void test(){
        driver.get(ConfigurationReader.get("urlTable"));
        String xpath = "//table[@id='table1']//td[.='tconway@earthlink.net']/../td[6]/a[2]";

        WebElement delete = driver.findElement(By.xpath(xpath));
        delete.click();

        TableOneTest tableOneTest = new TableOneTest();
        List<WebElement> emails = tableOneTest.getCellsInColumn("Email");

//        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        List<String> emailsStr = BrowserUtils.getElementsText(emails);

        Assert.assertFalse(emailsStr.contains("tconway@earthlink.net"));
    }
}
