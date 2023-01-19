package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    @Test
    public void StaleElementReferenceExceptionTest1() {
          /*
      StateElementReferenceException
      StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
      Sayfayı yenilediğimizde,
      sayfada ileri geri gittiğimizde meydana gelen exception'dır.

          Çözüm
      Elemanı tekrar bulmak.

 */
        driver.get("https://www.techproeducation.com");
//         LMS Login Linkine Tıkla ve o sayfanın URL'inin lms içerdiğini test et
        WebElement lmsLoginLink=driver.findElement(By.linkText("LMS LOGIN"));
        lmsLoginLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));

//        Tekrar Anasayfaya gel ve lms login sayfasına tekrar git
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(3);
        lmsLoginLink.click();//LMS'e geri git dedik org.openqa.selenium.StaleElementReferenceException

        /*
        lmsLoginLink linkini sayfa yenilendikten sonra (back()) kullandığım için StaleElementReferenceException aldık
         */
    }

    @Test
    public void staleElementReferenceExceptionTest2(){
        driver.get("https://www.youtube.com");
        waitFor(2);
        WebElement shorts = driver.findElement(By.xpath("(//*[@tabindex='0'])[4]"));
        waitFor(2);
        driver.navigate().refresh();
        waitFor(2);
        shorts.click();// SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKDEN SONRA KULLANMAK ISTEDIM
                             //org.openqa.selenium.StaleElementReferenceException

//        COZUMU
//        driver.findElement(By.xpath("(//*[@tabindex='0'])[4]"));

    }


}
