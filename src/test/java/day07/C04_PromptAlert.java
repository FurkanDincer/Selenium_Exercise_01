package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utililties.TestBase;

public class C04_PromptAlert extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //3. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        // uyarıdaki metin kutusuna isminizi yazin,
        Thread.sleep(4000);
        driver.switchTo().alert().sendKeys("Furkan");
        // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        Thread.sleep(4000);
        driver.switchTo().alert().accept();

        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="Furkan";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
