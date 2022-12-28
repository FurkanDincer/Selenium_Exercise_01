package day05_jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_Before_After {

    @Before
    public void setup(){
        System.out.println("Her test metodundan önce çalışır");
    }
    @After
    public void tearDown(){
        System.out.println("Her test metodundan sonra çalışır");
    }

    @Test
    public void test01(){
        System.out.println("İlk Test");
    }

    @Test
    public void test02(){
        System.out.println("İkinci test");
    }
}
