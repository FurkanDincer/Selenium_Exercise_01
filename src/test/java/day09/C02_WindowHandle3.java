package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest() {
//        1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        String techProHandle=driver.getWindowHandle();

//        2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1.Yeni pencere oluşturur 2.Oraya geçiş yapar
        driver.get("https://amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//        3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1.Yeni pencere oluşturur 2.Oraya geçiş yapar
        driver.get("https://linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

//         DRIVER NEREDE? LINKEDIN DE
//        TECHPRO SAYFASINA GEÇMEK İÇİN driver.switchTo().window(techproHandle)

        driver.switchTo().window(techProHandle);

    }
}
