package utililties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //TestBase'i abstract yapmamızın sebebi bu sınıfın objesini oluşturmak istemeyişimiz.
    //TestBase testBase=new TestBase(); -->yapılamaz
    //Amacımız bu sınıfı extend etmek ve içindeki hazır metodları kullanmak

    //driver objesini oluştur.Driver ya public ya da protected olmalıdır.Sebebi child classlardan görülebilir olması.
    //protected: inheritance yaptığımız classlardan ulaşabiliriz
    protected static WebDriver driver;

    //set up
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    //tearDown
    @After
    public void tearDown(){
        driver.quit();
    }
}
