package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Executor_Types extends TestBase {

    @Test
    public void typeTest() {
        //techpro adresine git
        driver.get("https://techproeducation.com");

        //Arama kutusuna QA yaz
        waitFor(2);
        WebElement searchBox=driver.findElement(By.xpath("//input[@type='search']"));
        typeWithJS(searchBox,"QA");

    }
}
