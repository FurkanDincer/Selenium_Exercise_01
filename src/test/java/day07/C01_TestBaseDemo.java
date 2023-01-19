package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    /*
    UTILITIES:
    -Utilities tekrar tekrar kullanacağımız classları koyduğumuz paketin adıdır.
         -TestBase
         -Driver --->Sonra
         -ExcelUtilities-->Sonra
         -Configuration -->Sonra

    -Utilities paketinde TEST CASE YAZILMAZ.
    -Sadece tekrar kullanılabilecek destek sınıfları (support class) oluşturulur.
    -Bu support classlar test caselerin yazılmasını hızlandırır.
     */

    @Test
    public void test1(){
//        techproeducation ana sayfasına git
        driver.get("https://techproeducation.com");
//        ve tittle'ın Bootcamps içerdiğini test et
        String pageTittle=driver.getTitle();
        Assert.assertTrue(pageTittle.contains("Bootcamps"));
    }
}
