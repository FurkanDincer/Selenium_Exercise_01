package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //1.Bir class oluşturun :CheckBoxTest
        //2.Gerekli yapiyi olusturun ve aşağıdaki görevitamamlayın.
        //a.Verilen web sayfasınagidin.https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b.Checkbox1 ve checkbox2 elementlerini locateedin.
        WebElement checkBox1=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2=driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //c.Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        //d.Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }



    }
}
