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
        findByXpath("//*[@data-qa='signup-name']").sendKeys("Furkan");
        findByXpath("(//*[@placeholder='Email Address'])[2]").sendKeys("dincerfurkan306@gmail.com");

        //7. Click 'Signup' button
        findByXpath("(//*[@class='btn btn-default'])[2]").click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(findByXpath("//*[text()='Enter Account Information']").isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth

        findByXpath("//*[@id='id_gender1']").click();

        findByXpath("//*[@id='password']").sendKeys("12345");

        findByXpath("//*[@id='days']").sendKeys("26");
        findByXpath("//*[@id='months']").sendKeys("July");
        findByXpath("//*[@id='years']").sendKeys("1997");


        //10. Select checkbox 'Sign up for our newsletter!'
        findByXpath("//*[@id='newsletter']").click();

        //11. Select checkbox 'Receive special offers from our partners!'
        findByXpath("//*[@id='optin']").click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        findByXpath("//*[@id='first_name']").sendKeys("Furkan");
        findByXpath("//*[@id='last_name']").sendKeys("Dincer");
        findByXpath("//*[@id='company']").sendKeys("TechPro");
        findByXpath("//*[@id='address1']").sendKeys("Zonguldak");
        findByXpath("//*[@id='country']").click();
        findByXpath("//*[text()='United States']").click();
        findByXpath("//*[@id='state']").sendKeys("North Caroline");
        findByXpath("//*[@id='city']").sendKeys("Duck");
        findByXpath("//*[@id='zipcode']").sendKeys("12345");
        findByXpath("//*[@id='mobile_number']").sendKeys("12345");




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
        //findByXpath("//*[text()=' Delete Account']").click();

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
