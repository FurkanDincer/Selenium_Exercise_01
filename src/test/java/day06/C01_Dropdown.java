package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    static WebDriver driver;

    //Eğer test sınıfında birden fazla method oluşturulmuşsa @Before kullanılır
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {
        //1.Locate dropdown element
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));

        //2.Select objesi oluştur
        Select yearDropDown = new Select(year);

        //3.Select object'i kullanarak üç farklı şekilde seçim yapabiliriz.
        yearDropDown.selectByIndex(22);//SEÇENEK SIRASI 0'DAN BAŞLAR. 2000 yılı 21.sırada

        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));

        Select monthDropDown = new Select(month);
        monthDropDown.selectByValue("0");//option in value değeri ile seçim yapılabilir. January seçeneğinin value'si 0'dır.

        //Gün seçimi
        WebElement day= driver.findElement(By.xpath("//*[@id='day']"));
        Select dayDropDown=new Select(day);
        dayDropDown.selectByVisibleText("10");//CASE SENSITIVE
    }

    @Test
    public void printTestAll(){
        //tüm eyalet isimlerini konsola yazdırın
        WebElement state=driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropDown=new Select(state);
        List<WebElement> stateList=stateDropDown.getOptions();
/*
        for(WebElement w:stateList){
            System.out.println(w.getText()+",");
        }
 */
        stateList.
                stream().
                map(t-> t.getText()).
                forEach(System.out::println);

    }
    @Test
    public void getSelectedOptionTest(){
        //state dropdown varsayılan seçili seçeneğin 'Select a state' olduğunu verify edelim
        WebElement state=driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropDown=new Select(state);
        String varsayilanText=stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",varsayilanText);
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    /*
    1.What is the Dropdown? Dropdown Nedir??
    DropDown liste oluşturmak için kullanılır.

    2.How to handle dropdown elements? Dropdown nasıl automate edilir??
    -dropdown'u locate ederim
    -select objesi oluştururum
    -select objesi ile istediğim seçeneği seçerim
    NOT:select objecsi oluşturma nedenim dropdownların Select classı ile oluşturulması

    3.Tum dropdown seçeneklerini nasıl print ederiz?
    -tüm dropdown elementlerini getOptions() methodu ile listeye koyarız.
    -sonra seçenekleri loop/lambda ile yazdırabiliriz

    4.Bir seçeneğin seçili olduğunu automate etmek için ne yapılır?
    Ornek: Gun olarak 10'u seçtik ama ya seçilmediyse

    getFirstSelectedOption() seçili olan seçiliği return eder.

     */




























}
