package day07;

import org.junit.Test;
import utililties.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest(){
        //Anasayfaki "An iframe with a thin black border:" metninin yazılı olduğunu test edelim
        //Ayrıca "Applications lists" yazısının sayfada olduğunu test edelim
        //Son olarak footer'daki "Povered by" yazısının olduğunu doğrulayalım
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
    }
}
