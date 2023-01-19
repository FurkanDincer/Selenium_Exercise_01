package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot  extends TestBase {

    /*
    Selenium'da tüm ekran görüntüsü nasıl alınır?

        -tüm ekran görünüsü Selenium'dan gelen getScreenshotAs() metodu ile alınır.
     */

    @Test
    public void screenShotTest() throws IOException {
        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");

//        1.Adım: Ekran Görüntüsünü getScreenShotAs metotu ile alıp File olarak oluştururuz
        File resim=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        2.Adım: Almış olduğumuz ekran görüntüsünü belirlediğimiz bir Path'e kaydettik
//        Note: Kayıt ismini dinamik yapmak için date objesi kullandım(unique olması için)
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);
//        3.Adım: Görüntüm ile dosyamızı birleştirip kaydediyoruz
        FileUtils.copyFile(resim,hedef);


        //QA Araması yapın
        findByXpath("//input[@type='search']").sendKeys("QA"+ Keys.ENTER);

        //Açılan sayfanın metnini test et ve ekran görüntüsünü al
        String text=findByXpath("//*[contains(text(),'Search Results for')]").getText();
        Assert.assertTrue("Search Results for: QA".contains(text));

//        Resuable method yardımıyla ekran görüntüsü alırız
        takeScreenShotOfPage();
    }
}
