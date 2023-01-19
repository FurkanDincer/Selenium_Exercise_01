package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {
    //Tests package'inda yeni bir class olusturun: WindowHandle
    //https://the-internet.herokuapp.com/windows adresine gidin.
    @Test
    public void handleWindowsTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
//        ILK SAYFANIN ID DEĞERİNİ ALALIM
        String window1Handle=driver.getWindowHandle();

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String actualText=findByXpath("//h3").getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(actualText,expectedText);

        //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String actualTittle=driver.getTitle();
        String expectedTittle="The Internet";
        Assert.assertEquals(actualTittle,expectedTittle);

        //Click Here butonuna basın.
        findByXpath("//*[text()='Click Here']").click();
        Thread.sleep(3000);

//       BU NOKTADA 2 PENCERE AÇIK VE İKİNCİSİNE GEÇİŞ YAPMAK İSTİYORUM
//       BUNUN İÇİN driver.getWindowHandles() ILE TÜM PENCERELERİN ID'LERİNİ ALALIM

        Set<String> allWindowsHandles=driver.getWindowHandles();
        System.out.println(allWindowsHandles);

        for (String eachHandle: allWindowsHandles){
//      Eğer listedeki id windows1'e eşit değilse, otomatik olarak window 2'ye eşittir.
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);//Buradaki eachHandle window2 handle'ına eşittir
                break;
            }
        }
//        BU NOKTADA DRIVER İKİNCİ PENCEREDE

        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        WebElement windows2Text=findByXpath("//h3");
        Assert.assertEquals(driver.getTitle(),"New Window");
        String window2Handle=driver.getWindowHandle();

        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        String windows2Tittle= driver.getTitle();
        Assert.assertEquals(windows2Tittle,"New Window");

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.

        Thread.sleep(3000);

        //1.windowa geçiş yapıyorum
        driver.switchTo().window(window1Handle);
        String windows3Tittle= driver.getTitle();
        Assert.assertEquals(windows3Tittle,"The Internet");

        //2.windowa geçelim
        driver.switchTo().window(window2Handle);



    }
}
