package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    //Class: Cookies
    //Method: handleCookies
    @Test
    public void handleCookies() {
        //Amazona git
        driver.get("https://amazon.com");
        waitFor(3);

        //1.toplam allCookie sayisini bul
        Set<Cookie> allCookie = driver.manage().getCookies();
        System.out.println(allCookie.size());

        for (Cookie w : allCookie) {
            System.out.println(("Cookie: " + w));//Cookie'nin tamamını yazdık
            System.out.println("Cookie Isimleri: " + w.getName() + " ");

            //3. Bir Cookie yi ismiyle bul
            System.out.println("Seçtiğim Cookie = " + driver.manage().getCookieNamed("i18n-prefs"));


            //4. Yeni bir cookie ekle
            Cookie favoriCookiem = new Cookie("cikolatam", "antep-fistikli-cikolata");
            driver.manage().addCookie(favoriCookiem);
            System.out.println("Yeni Cookie Sayısı: " + driver.manage().getCookies().size());

            //5. Bir Cookie yi ismiyle sil
            driver.manage().deleteCookieNamed("session-id-time");

            //6.Tüm cookieleri silin
            driver.manage().deleteAllCookies();
            System.out.println("Tum cookieleri sildim. Yeni Cookie sayısı:"+driver.manage().getCookies().size());



        }

    }
}
