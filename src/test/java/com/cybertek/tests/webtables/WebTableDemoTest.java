package com.cybertek.tests.webtables;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableDemoTest extends TestBase {

    @BeforeMethod
    public void setUpMethodGetThatSite() {
        driver.get(ConfigurationReader.get("urlTable"));
    }

    @Test
    public void printTable() {


        WebElement table = driver.findElement(By.id("table1"));

        System.out.println(table.getText());

    }

    // headers

    @Test
    public void headersTest() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        headers.forEach((cell -> System.out.println(cell.getText())));
        System.out.println("headers.size() = " + headers.size());

    }

    // get table size
    @Test
    public void tableSizeTest() {
        // TODO number of columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of columns: " + headers.size());
        // TODO number row including headers

        List<WebElement> rowsWithHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of rows including headers: " + rowsWithHeaders.size());

        // TODO number row without headers
        List<WebElement> rowsWithOutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of rows without headers:" + rowsWithOutHeaders.size());

    }


    // get whole row
    @Test
    public void getWholeRow() {

        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row.getText());

        int index = 4;
        String rowXpath = "//table[@id='table1']/tbody/tr[" + index + "]";

        row = driver.findElement(By.xpath(rowXpath));
        System.out.println(row.getText());
    }


    // get all cells from certain row
    @Test
    public void getCellsinRow() {
        List<WebElement> cellsInRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        cellsInRow.forEach((cell -> System.out.println(cell.getText())));
        System.out.println("cellsInRow.size() = " + cellsInRow.size());

        int index = 3;
        String cellInRowXpath = "//table[@id='table1']/tbody/tr[" + index + "]/td";

        cellsInRow = driver.findElements(By.xpath(cellInRowXpath));
        cellsInRow.forEach((cell -> System.out.println(cell.getText())));

    }

    // get certain cell
    @Test
    public void getCellTest() {
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[4]"));
        System.out.println(cell.getText());

    }

    @Test
    public void getCellMethodTest() {
        WebElement cell = getCell(3, 4);
        Assert.assertEquals(cell.getText(), "$100.00");

        cell = getCell(4, 5);
        Assert.assertEquals(cell.getText(), "http://www.timconway.com");


    }

    // get do you get a value from a cell based on its coordinates/index?
    public WebElement getCell(int rowIndex, int colIndex) {
        String xpath = "//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]";
        return driver.findElement(By.xpath(xpath));

    }

    // go to the page
    // click on email
    // verify email column is sorted in ascending order
    @Test
    public void columnSortTest() {
        // click on column email
        // get all columns names
        // click on col email

        List<WebElement> colNames = getAllColumnsNames();

        for (WebElement colName : colNames) {
            if (colName.getText().equals("Email")) {
                colName.click();
            }
        }
        // get all data under the Email col
        // get the index of the Email
        int colIndex = getColumnIndex("Email");
        System.out.println(colIndex);
        // generate the xpath all cells under the email col

        String xpath = "//table[@id='table1']/tbody/tr/td[" + colIndex + "]";
        List<WebElement> allEmails = driver.findElements(By.xpath(xpath));

        allEmails.forEach((email -> System.out.println(email.getText())));

        for (int i = 0; i < allEmails.size() - 1; i++) {
            String email1 = allEmails.get(i).getText();
            String email2 = allEmails.get(i + 1).getText();
            Assert.assertTrue(email1.compareTo(email2) < 0);

        }


    }

    private List<WebElement> getAllColumnsNames() {
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return cols;
    }

    private int getColumnIndex(String col) {
        List<WebElement> cols = getAllColumnsNames();
        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i).getText().equals(col)) {
                return i + 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println("a".compareTo("c"));
    }


}
