package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    //Tests packagenin altina bir class oluşturun : C05_UploadFile


    @Test
    public void fileUploadTest() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileButton=findById("file-upload");

        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu=System.getProperty("user.home")+"/Desktop/logo.jpeg";

        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(5);
        /*
        chooseFileButton'a tıklayarak yüklemek istediğim dosyanın pathini göndererek dosyayı seçtim
         */

        //Upload butonuna basalim.
        findById("file-submit").click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String uploadedText=findByXpath("//h3").getText();
        Assert.assertEquals("File Uploaded!",uploadedText);
    }
}
