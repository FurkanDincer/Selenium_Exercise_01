package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown_Reusable {
    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    //REUSABLE METHOD:Dropdown için tekrar tekrar kullanabileceğiniz bir method oluşturalım

    public void selectFromDropdown(WebElement dropdown, String secenek){
        //WebElement year = driver.findElement(By.xpath("//*[@id='year']"),"2005"); ---> year'dan 2005
        //WebElement month = driver.findElement(By.xpath("//*[@id='month']"),"January");------>month'dan January
        //WebElement month = driver.findElement(By.xpath("//*[@id='day']"),"12");

        //Gonderilen dropdown elementlerinin tüm optionsları alınır
        List<WebElement> options=dropdown.findElements(By.tagName("option"));//Tüm option tagli elementleri alıyorum

        for (WebElement eachOption: options){
            if (eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }
        }
    }

    @Test
    public void selectFromDropdown(){
      selectFromDropdown(driver.findElement(By.xpath("//*[@id='year']")),"2005");
      selectFromDropdown(driver.findElement(By.id("month")),"November");
      selectFromDropdown(driver.findElement(By.id("day")),"26");
      selectFromDropdown(driver.findElement(By.id("state")),"Texas");
    }

}
