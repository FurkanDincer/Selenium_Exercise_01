package day09;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {
    @Test
    public void BasicAuthenticationTest() {

        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //asagidaki yontem ve test datalarini kullanarak authentication'i yapin
        //URL              : https://username:password@URL
        //Username    : admin
        //password    : admin
        //Basarili sekilde sayfaya girin ve 'Congratulations!' yasizini doğrulayın

//      Authentication URL miz: https://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        waitFor(3);
        String actualText=findByXpath("//p").getText();
        Assert.assertTrue(actualText.contains("Congratulations"));
    }
}
