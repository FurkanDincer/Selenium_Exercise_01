package day05_jUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalismaClassı02 {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        // ~ click on Phones & PDAs
        driver.findElement(By.linkText("Phones & PDAs")).click();

        // ~ get the brandName of phones
        List<WebElement> brandNames = getWebElements("//h4");
        List<String> brandNamesList = new ArrayList<>();
        createList(brandNames, brandNamesList);


        // ~ click on add to button for all elements
        List<WebElement> allEl = getWebElements("//*[text()='Add to Cart']");

        for (WebElement w : allEl) {
            w.click();
        }
        driver.navigate().refresh();

        // ~ click on black total added cart button,
        driver.findElement(By.id("cart-total")).click();

        // ~ get the names of list from the cart
        List<WebElement> namesOnCart = getWebElements("//*[@class='text-left']");
        List<String> namesOnChartList = new ArrayList<>();
        createList(namesOnCart,namesOnChartList);

        // ~ compare the names from displaying list and cart list
        boolean sonuc = brandNamesList.equals(namesOnChartList);
        System.out.println("Test Passed = " + sonuc);
    }

    public static List<WebElement> getWebElements(String xPathexpression) {
        return driver.findElements(By.xpath(xPathexpression));

    }

    public static List<String> createList(List<WebElement> a,List<String> b) {

        for (WebElement w : a) {
            b.add(w.getText());
        }
        Collections.sort(b);
        return b;
    }
}