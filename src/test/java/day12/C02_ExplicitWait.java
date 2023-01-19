package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    //https://the-internet.herokuapp.com/dynamic_loading/1
    //Start buttonuna tıkla
    //Hello World! Yazının sitede oldugunu test et
    @Test
    public void explicitWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        findByXpath("//div[@id='start']//button").click();

//        1.WebDriverWait objesini oluştur
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));//30 saniyeye kadar bekle dedik ancak 30 saniye beklemiyor

//        2.wait objesini kullanarak bekleme problemini çözmeye çalış
        WebElement helloWorlElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText= helloWorlElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);





    }
}
