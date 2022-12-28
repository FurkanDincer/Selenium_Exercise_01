package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Homework {
    public static void main(String[] args) throws InterruptedException {

        //    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        //    ~ click on Phones & PDAs
        //    ~ get the brandName of phones
        //    ~ click on add to button for all elements
        //    ~ click on black total added cart button
        //    ~ get the names of list from the cart
        //    ~ compare the names from displaying list and cart list
        //     */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //~ click on Phones & PDAs
        Thread.sleep(1000);

        driver.findElement(By.linkText("Phones & PDAs")).click();

        //~ get the brandName of phones
        List<WebElement> brandNames = driver.findElements(By.xpath("//h4"));



        //~ click on add to button for all elements
        List<WebElement> allEl = driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        allEl.forEach(WebElement::click);

        /*
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]")).click();
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[3]")).click();

         */


        //~ click on black total added cart button
        Thread.sleep(1000);
        driver.findElement(By.id("cart-total")).click();

        //~ get the names of list from the cart
        List<WebElement> names = driver.findElements(By.xpath("//*[@class='text-left']"));








    }

}
