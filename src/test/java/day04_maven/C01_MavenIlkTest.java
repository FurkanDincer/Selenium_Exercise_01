package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1-https://www.amazon.com/ sayfasinagidelim
        //2arama kutusunu locateedelim
        //3-“Samsung headphones” ile aramayapalim
        //4Bulunan sonuc sayisiniyazdiralim
        //5Ilk urunutiklayalim
        //6-Sayfadaki tum basliklari yazdiralim

        //1-https://www.amazon.com/ sayfasinagidelim
        driver.get("https://www.amazon.com/");

        //2-arama kutusunu locateedelim
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //3-“Samsung headphones” ile aramayapalim

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).
                sendKeys("Samsung headphones", Keys.ENTER);

        //4-Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama Sonucu: "+aramaSonucu.getText());

        //5-Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //6-Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklariListesi= driver.findElements(By.xpath("//h1"));

        for (WebElement w:sayfaBasliklariListesi){
            System.out.print(w.getText()+" ");
        }

        System.out.println( );
        sayfaBasliklariListesi.stream().forEach(t-> System.out.print(t.getText()+" "));

        //7-Sayfayı Kapatın
        driver.close();

    }
}
