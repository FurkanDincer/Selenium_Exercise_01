package day05_jUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CalısmaClassı {
    static WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test01(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());
        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("furkand@hotmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("yanlisSifre");

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible9
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());

    }

}
