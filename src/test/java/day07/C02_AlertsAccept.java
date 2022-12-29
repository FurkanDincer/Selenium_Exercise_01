package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utililties.TestBase;

public class C02_AlertsAccept extends TestBase {
    /*
       Bir class olusturun: Alerts
        https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        */
    @Test
    public void acceptAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        //yukarıdaki OK butonuna
        Thread.sleep(3000);
        driver.
                switchTo().//değiştir
                alert().//alert'e değiştir
                accept();//OK seçeneğine tıklanır
        Thread.sleep(3000);
        //result mesajının  “You successfully clicked an alert” oldugunu test edin.
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(actualResult,expectedResult);
    }
    /*
    Alerleri nasıl automate ederiz?
    Alertler javascript ile oluşur. Inspect edilemezler. Öncelikle alert'e switch etmemiz gerekir
     */
}
