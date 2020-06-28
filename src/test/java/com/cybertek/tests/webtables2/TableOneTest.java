package com.cybertek.tests.webtables2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.assertEquals;

/**
 * Complete the implementation of methods.
 * All of the methods are about the first web table
 * from the http://practice.cybertekschool.com/tables
 * Run the test following any method to test it
 */
public class TableOneTest extends TestBase {

    @BeforeMethod
    public void setUpMethodSubClass() {
        driver.get("http://practice.cybertekschool.com/tables");
    }

    /**
     * method that returns the number of rows including headers in table 1
     *
     * @return
     */
    public int getRowCount() {
        return driver.findElements(By.xpath("//table[@id='table1']//tr")).size();

    }

    @Test
    public void getRowCountTest() {

        assertEquals(getRowCount(), 5, "Number of rows did not match");
    }

    /**
     * method that returns the number of columns in table 1
     *
     * @return
     */
    public int getColCount() {

        return driver.findElements(By.xpath("//table[@id='table1']//th")).size();
    }

    @Test
    public void getColCountTest() {

        assertEquals(getColCount(), 6, "Number of columns did not match");
    }

    public int cellName(String elementName){
        List<WebElement> cellsName = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td"));

        for (WebElement cname : cellsName){
            System.out.println(cname.getText().toString());
        }
      int index = 0;
        for (int i=0; i < cellsName.size(); i++) {
            if (cellsName.get(i).getText().equals(elementName)){
                index = i;
            }
        }return  index;
    }

    @Test
    public void cellNameTest(){

        int ind = cellName("Frank");
        System.out.println("ind = " + ind);

    }





    /**
     * method that returns the size of the table 1
     *
     * @return
     */
    public int[] getTableSize() {
        int[] size = new int[2];
        size[0] = getRowCount();
        size[1] = getColCount();
        return size;
    }

    @Test
    public void getTableSizeTest() {
        int[] expectedSize = new int[]{5, 6};
        assertEquals(getTableSize(), expectedSize, "Table size did not match");
    }

    /**
     * method that returns all headers in table 1
     *
     * @return
     */
    public List<WebElement> getHeaders() {
        return driver.findElements(By.xpath("//table[@id='table1']//th"));
    }

    @Test
    public void getHeadersTest() {
        List<String> expectedHeaders = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<String> actualHeaders = BrowserUtils.getElementsText(getHeaders());
        assertEquals(actualHeaders, expectedHeaders, "Headers did not match");

    }

    /**
     * method that returns all cells under given column in table 1
     *
     * @param colName
     * @return
     */

    public List<WebElement> getCellsInColumn(String colName) {
        List<WebElement> headers = getHeaders();
        List<String> headersStr = BrowserUtils.getElementsText(headers);

        int index = headersStr.indexOf(colName)+1;
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td["+index+"]"));
        return cells;

    }

    @Test
    public void getCellsInColumnTest() {
        List<String> expectedLastNames = Arrays.asList("Smith", "Bach", "Doe", "Conway");
        List<String> actualLastNames = BrowserUtils.getElementsText(getCellsInColumn("Last Name"));
        assertEquals(actualLastNames, expectedLastNames, "First names did not match");
        List<String> expectedFirstNames = Arrays.asList("John", "Frank", "Jason", "Tim");
        List<String> actualFirstNames = BrowserUtils.getElementsText(getCellsInColumn("First Name"));
        assertEquals(actualFirstNames, expectedFirstNames, "First names did not match");
    }

    @Test
    public void itirateTable(){

        for (int i = 1; i < getRowCount(); i++) {
            for (int j = 1; j <= getColCount(); j++) {
                String xpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(driver.findElement(By.xpath(xpath)).getText());

            }

        }
    }

}