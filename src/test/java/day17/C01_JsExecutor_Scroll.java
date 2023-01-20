package day17;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JsExecutor_Scroll extends TestBase {
    @Test
    public void scrollIntoViewTest() throws IOException {

        //scrollIntoViewTest metotu olustur


        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        waitFor(3);

        //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al

//        1.Elementi Bul
        WebElement weOfferText=findByXpath("//span[.='we offer']");

//        2.JavaScript Executor Objesi oluştur
        JavascriptExecutor js=(JavascriptExecutor) driver;

//        3.Yapmak istediğim işlemi js.executeScript metotu ile yap
//        scrollIntoViev(true) methodu belirdir bir elemana scroll yapmak için kullanılır
        waitFor(1);
        js.executeScript("arguments[0].scrollIntoView(true)",weOfferText);
        takeScreenShotOfPage();
        waitFor(2);

        //Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enrollText=findByXpath("//span[.='Enroll Free Course']");
        scrollIntoViewJS(enrollText);
        waitFor(2);
        takeScreenShotOfPage();


        //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(findByXpath("//h3[.='WHY US?']"));
        waitFor(2);
        takeScreenShotOfPage();

        //Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(enrollText);
        takeScreenShotOfPage();


        //EN ÜSTE GİT
        scrollTopJS();
        waitFor(1);

        //EN ALTA GİT
        scrollEndJS();
        waitFor(1);
    }
}

