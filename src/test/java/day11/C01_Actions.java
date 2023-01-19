package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void keyboardActionsTest() {

//        Google a gidin https://www.google.com
        driver.get("https://www.google.com");

//        ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        WebElement aramaKutusu=driver.findElement(By.name("q"));

        Actions actions=new Actions(driver);
        actions.
                keyDown(aramaKutusu, Keys.SHIFT).//arama kutusunun üstünde Shift tuşuna bas
                sendKeys("ıphone x fiyatları").//shift'e basılı iken yazı yaz
                keyUp(aramaKutusu,Keys.SHIFT).//shift'e artık basma
                sendKeys("  çok pahali!"+Keys.ENTER ).//normal halde yaz ve enter tuşuna bas
                build().//birden fazla actions metodu kullanıldığında build() kullanılması önerilir
                perform();
//        ‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
//        Ve ENTER tusuna bas

    }
}
/*
        1-Actions Nedir?
    *Actions seleniumdan gelen bir kütüphanedir.Actions aynı zamanda Mouse ve Keyboard işlemlerini gerçekleştirmek
    için kullandığımız bir Selenium Kütüphanesidir. Örneğin, sağ tıklamak(contexClick), çift tıklamak(doubleclick),
    bir elementin üzerine gitmek(moveToElement) gibi mouse işlemlerini gerçekleştirebiliriz. Aynı zamanda Shift,Control
    Delete,Enter gibi klavye tuşlarına da actions yardımıyla basabiliriz.
    Bu tür işlemlerde sendKeys methodu kullanılır.

        2-Ne tür methodlar kullandınız?
    *Actions metotları önemlidir ve tekrar tekrar kullanmam gerektiğinden Actions methodlarını içeren Reusable methodları oluşturdum.
    Ve gerektiğinde bu resuable methodları kullanıyorum. Örneğin rightClick methodunu bir elemente sağ tıklamak için test
    class'ından çağırabilirim.

      3- Hangi methodlari kullandin ne ne ise yarar?
      Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement) gibi mouse islemlerini gerçekleştirebiliriz.
      Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada actions yardımıyla basabiliriz.
      Bu tur islemlerde sendKeys metodu kullaninir.



*/