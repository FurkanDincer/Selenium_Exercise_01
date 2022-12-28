package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
      @BeforeClass ve @AfterClass notasyonları sadece static methodlar için çalışır.
    @BeforeClass ve @AfterClass kullanırsak oluşturduğumuz @Test methodlarının tepsini aynı anda çalışıtırıp
    en son @AfterClass'ı çalıştırırız.
      Ama sadece @Before ve @After kullanırsak her test için @Before ve @After kullanılır.
     */

    @BeforeClass
    public static void setUp(){

        System.out.println("Ben BEFORECLASS'IM !!Bütün testlerden önce çalıştı");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Ben AFTERCLASS'IM!!Bütün testlerden sonra çalıştı");
    }

    @Before
    public void setUp01(){
        System.out.println("Her testten önce çalışır");
    }
    @After
    public void teardown01(){
        System.out.println("Her testten sonra çalışır");
    }

    @Test
    public void test01(){
        System.out.println("ilk test");
    }

    @Test
    public void test02(){
        System.out.println("ikinci test");
    }

    @Test
    @Ignore //eğer bir testi çalıştırmak istemezsek bu şekilde kullanabiliriz.
    public void test03(){
        System.out.println("üçüncü test");
    }
}
