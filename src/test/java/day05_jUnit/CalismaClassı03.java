package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CalismaClassı03 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com/'
        driver.get("http://automationexercise.com/");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(findByXpath("//body").isEnabled());

        //4. Click on 'Signup / Login' button
        sleepMethod(1500);
        findByXpath("//*[text()=' Signup / Login']").click();

        //5. Verify 'New User Signup!' is visible
        sleepMethod(1500);
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

        //6. Enter name and email address
        sleepMethod(1500);
        findByXpath("//*[@data-qa='signup-name']").sendKeys("Furkan");
        sleepMethod(1500);
        findByXpath("(//*[@placeholder='Email Address'])[2]").sendKeys("furkan.d@windowslive.com");

        //7. Click 'Signup' button
        sleepMethod(1500);
        findByXpath("(//*[@class='btn btn-default'])[2]").click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(findByXpath("//*[text()='Enter Account Information']").isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        sleepMethod(1500);
        findByXpath("//*[@id='id_gender1']").click();
        sleepMethod(1500);
        findByXpath("//*[@id='password']").sendKeys("12345");
        sleepMethod(1500);
        findByXpath("//*[@id='days']").sendKeys("26");
        sleepMethod(1500);
        findByXpath("//*[@id='months']").sendKeys("July");
        sleepMethod(1500);
        findByXpath("//*[@id='years']").sendKeys("1997");


        //10. Select checkbox 'Sign up for our newsletter!'
        sleepMethod(1500);
        findByXpath("//*[@id='newsletter']").click();

        //11. Select checkbox 'Receive special offers from our partners!'
        sleepMethod(1500);
        findByXpath("//*[@id='optin']").click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        sleepMethod(1500);
        findByXpath("//*[@id='first_name']").sendKeys("Furkan");
        sleepMethod(1500);
        findByXpath("//*[@id='last_name']").sendKeys("Dincer");
        sleepMethod(1500);
        findByXpath("//*[@id='company']").sendKeys("TechPro");
        sleepMethod(1500);
        findByXpath("//*[@id='address1']").sendKeys("Zonguldak");
        sleepMethod(1500);
        findByXpath("//*[@id='country']").click();
        sleepMethod(1500);
        findByXpath("//*[text()='United States']").click();
        sleepMethod(1500);
        findByXpath("//*[@id='state']").sendKeys("North Caroline");
        sleepMethod(1500);
        findByXpath("//*[@id='city']").sendKeys("Duck");
        sleepMethod(1500);
        findByXpath("//*[@id='zipcode']").sendKeys("12345");
        sleepMethod(1500);
        findByXpath("//*[@id='mobile_number']").sendKeys("12345");
        sleepMethod(1500);




        //13. Click 'Create Account button'
        sleepMethod(1500);
        findByXpath("//*[text()='Create Account']").click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(findByXpath("//*[text()='Account Created!']").isDisplayed());

        //15. Click 'Continue' button
        sleepMethod(1500);
        findByXpath("//*[@class='btn btn-primary']").click();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(findByXpath("//*[text()=' Logged in as ']").isDisplayed());
        //17. Click 'Delete Account' button
        sleepMethod(1500);
        findByXpath("//*[text()=' Delete Account']").click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        sleepMethod(1500);
        findByXpath("//*[text()='Account Deleted!']").isDisplayed();
    }
    public static WebElement findByXpath(String a){

        return driver.findElement(By.xpath(a));
    }
    public static void sleepMethod(int a) throws InterruptedException {
        Thread.sleep(a);
    }

}
