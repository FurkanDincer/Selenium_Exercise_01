package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {
    @Test
    public void windowHandleTest() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle=driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text=findByXpath("//*[.='Opening a new window']").getText();
        String expectedWindow1Text="Opening a new window";
        Assert.assertEquals(actualWindow1Text,expectedWindow1Text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualWindow1Tittle=driver.getTitle();
        String expectedWindow1Tittle="The Internet";
        Assert.assertEquals(actualWindow1Tittle,expectedWindow1Tittle);

        //Click Here butonuna basın.
        // İkinci bir pencere açılır ve ikinci pencerede işlem yapmak istediğimden o pencereye switch-geçiş yapmalıyız

        driver.findElement(By.linkText("Click Here")).click();
        waitFor(3);

        switchToWindow(1);//


        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin
        String actualWindow2Tittle=driver.getTitle();
        String expectedWindow2Tittle="New Window";
        Assert.assertEquals(actualWindow2Tittle,expectedWindow2Tittle);


    }
}

