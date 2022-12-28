package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        //2.Signin buttonuna tiklayin
        //3.Login alanine “username” yazdirin
        //4.Password alanine “password” yazdirin
        //5.Sign in buttonuna tiklayin
        //6.Pay Bills sayfasina gidin
        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina “2020-09-10” yazdirin
        //9.Pay buttonuna tiklayin
        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin


        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();

        //3.Login alanine “username” yazdirin
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username");

        //4.Password alanine “password” yazdirin
        driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.navigate().back();

        //6.Online Banking sayfasina gidin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Online Banking'][1]")).click();

        //7.Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();

        //8.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='sp_amount']")).sendKeys("200", Keys.ENTER);

        //9.tarih kismina “2020-09-10” yazdirin
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[id='sp_date']")).sendKeys("2020-09-10", Keys.ENTER);

        //10.Pay buttonuna tiklayin
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();

        //11.“The payment was successfully submitted.” mesajinin ciktigini control edin
        Thread.sleep(1000);
        WebElement output=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

        if (output.isDisplayed()){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        //12.Sayfayı Kapatın
        driver.close();





    }
}
