package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void webTables01() {
        //https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        String table1=findByXpath("//table[@id='table1']").getText();
        System.out.println("Table 1 Verileri");
        System.out.println(table1);

        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for(WebElement eachElement : allTableElements){
            System.out.println(eachElement.getText());
        }
    }

    @Test
    public void row3Print() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.forEach(veri -> System.out.println(veri.getText()));
    }

//    Task 3: Son rowdaki dataları print ediniz


    @Test
    public void sonSatirVerileri() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatir=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(veri-> System.out.println(veri.getText()));
    }

    @Test
    public void sutun5Test() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5=driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        sutun5.forEach(veri-> System.out.println(veri.getText()));
    }

    public void printData(int satir, int sutun){
        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }
    @Test
    public void printDataTest(){
        printData(2,3);//fbach@yahoo.com
        printData(1,2);//John
    }
}
