package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest() {
        //User Story:
        //Sinif : IFrame
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String anaMetin = findByXpath("//*[text()='An iframe with a thin black border:']").getText();
        String expectedMetin = "black border";
        Assert.assertTrue(anaMetin.contains(expectedMetin));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //aplication list elementi iframe'in içinde. Iframe switch yapmamız şart
        driver.switchTo().frame(0);//index 0'dan başlar
        String appList = findByXpath("//*[text()='Applications lists']").getText();
        String expectedText = "Applications lists";
        Assert.assertTrue(appList.contains(expectedText));

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        //Anasayfadaki Povered By sayfasını test etmek istiyorum ancak driver halen daha iframe'in içinde
        driver.switchTo().defaultContent();
        String footerText = findByXpath("(//footer[@class='blog-footer'])[1]//p").getText();
        String expectedTextfooter = "Povered By";
        Assert.assertTrue(footerText.contains(expectedTextfooter));

        /*
        How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
         ***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
         ***driver.findElements(By.tagName(“iframe”));
         ***driver.findElements(By.xpath(“//iframe”));
         ————————————
         Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
         ***2 farkli yol vardır.
         ***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
         ———————————-
         What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
         *** Oncelikle her ikiside framein disina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
         —————————————
         What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
         Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
         Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz.
         O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
         Iframe. Cozum : switch to iframe
         Alert. Cozum : switch to alert
         New window(Yeni pencere) : switch to window
*/
    }
}