package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException {

    WebDriver driver;
    Faker faker;

    @Test
    public void nullPointerExceptionTest() {
        /*
    NullPointerException
        Değişkenleri oluşturup instantiate etmediğimizde alırız.
        Örn: driver = new ChoromeDriver()'da "new" kelimesini kullanmadığımızda NullPointerException hatasını alırız.
        Sorunun çözümü ise değikeni instantiate etmeketir.
     */
        driver.get("https://techproeducation.com");//java.lang.NullPointerException
    }

    @Test
    public void nullPointerExceptionTest2() {
        faker=new Faker();
        System.out.println(faker.name().fullName());
    }
}
