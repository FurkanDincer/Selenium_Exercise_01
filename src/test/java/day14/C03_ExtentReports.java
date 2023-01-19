package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {
    //        HATIRLAMAMIZ GEREKEN 3 CLASS
    public static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    @Test
    public void extentReportsTest() {
//        Report Path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//        *******************************RAPORU CUSTOMIZE EDERİZ************************************************
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "TechPro Education");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Eagles");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint No", "Sprint145");
        extentReports.setSystemInfo("QA","Furkan");

//        *******************************EXTRA RAPOR ISMI VE DOCUMAN İSMİ EKLEYEBİLİRİZ***************************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extend  Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");
//        ********************************RAPOR AYARLARI BITTI****************************
//        Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);

//        Extent Test Objesini oluşturduk
        extentTest=extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");

//        Tum ayarlar bitti. Extent Test Objesi ile Loglama (rapora yazdırma) işlemini yapabilirim
        extentTest.pass("Kullanıcı Ana Sayfaya girer");
        driver.get("https://www.techproeducation.com");

//        LMS Sayfasına Gidelim
        extentTest.pass("Kullanıcı LMS Sayfasına Gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();

//        Test Bitti
        extentTest.pass("Test Başarıyla Gerçekleştirildi");

//        Raporu Göster
        extentReports.flush();




















    }
}
