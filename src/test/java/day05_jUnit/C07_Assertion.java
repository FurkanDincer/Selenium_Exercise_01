package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.close();
    }

    //https://www.amazon.com adresine gidin
    //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //=> titleTest => Sayfa başlığının “Amazon” oldugunu test edin
    //=> image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin

    @Test
    public void test01() {
        String actualTittle = driver.getTitle();
        String expectedTittle = "Amazon";
        Assert.assertTrue(actualTittle.contains(expectedTittle));
    }
    /*
    @Test
    public void test02(){
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }
     */



    @Test
    public void test03() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }



    @Test
    public void test04() {
        String actualTittle = driver.getTitle();
        String expectedTittle = "amazon";
        Assert.assertFalse(actualTittle.contains(expectedTittle));
    }


}
