package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ScreenShot2 extends TestBase {

    @Test
    public void takeScreenShotElement() throws IOException {
//        TechPro adresine git
        driver.get("https://techproeducation.com");

//        Sosyal medya kısmının ekran görüntüsünü al
        WebElement socialMediaIcon=findByXpath("(//div[@class='elementor-widget-container'])[1]");
        File image=socialMediaIcon.getScreenshotAs(OutputType.FILE);

//        2.Görüntüyü kaydet
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);
        FileUtils.copyFile(image,hedef);

        WebElement logo=findByXpath("//img[@class='attachment-large size-large lazyloaded']");
        takeScreenshotOfElement(logo);
    }
}
