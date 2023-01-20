package day17;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSClick extends TestBase {
    @Test
    public void clickByJSTest() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        waitFor(2);
        //LMS LOGIN elementine tikla
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));

        //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        Assert.assertTrue(driver.getCurrentUrl().equals("https://lms.techproeducation.com/"));
    }
}