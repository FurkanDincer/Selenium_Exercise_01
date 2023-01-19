package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void isExistTest() {
        String userDIR=System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHome=System.getProperty("user.home");
        System.out.println(userHome);// \Users\Furkan

        //logo.jpeg indirip MASAUSTÜNE KAYDEDELİM

//      Logo masaüstünde : /Users/techproed/Desktop

        String dosyaYolu=userHome+"/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExist=Files.exists(Paths.get(dosyaYolu));
        Assert.assertTrue(isExist);
    }
}
