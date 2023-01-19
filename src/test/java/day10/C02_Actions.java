package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    /*
      MANUAL:
      1. Amazon home sayfasina git
      2. Account & list e uzerinde bekle-mouse over/hover over
      3.Acilan pencerede Account linkine tokla
      4.Acilan sayfanin Title inin, your Account oldugunu dogrula
 */

    @Test
    public void hoverOverTest() {
        //Amazon a gidelim https://www.amazon.com/

        driver.get("https://www.amazon.com/");

//        1.Actions Objesi Oluştur
        Actions actions = new Actions(driver);
//        2.Webelementi Bul
        WebElement accountList = findById("nav-link-accountList");
        waitFor(1);
//        3.UYGUN ACTIONS METHODUNU UYGULA. SONUNA perform() KOYMAYI UNUTMA
        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
        actions.moveToElement(accountList).perform();
        waitFor(3);
//        “Account” secenegine tikka
        driver.findElement(By.linkText("Account")).click();

//        Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }
    //Class: Actions2
    //Method : hoverOver() and test the following scenario:



}
