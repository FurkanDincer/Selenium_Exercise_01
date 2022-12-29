package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utililties.TestBase;


public class C03_DismissAlert extends TestBase {
    //2. butona tıklayın,
    // uyarıdaki Cancel butonuna tıklayın
    // result mesajının “You clicked: Cancel” oldugunu test edin.

    @Test
    public void test01() throws InterruptedException {
        //2. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //uyarıdaki Cancel butonuna tıklayın
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        // result mesajının “You clicked: Cancel” oldugunu test edin.
        String actualtResult=driver.findElement(By.id("result")).getText();
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(actualtResult,expectedResult);


    }


}
