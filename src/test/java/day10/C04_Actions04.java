package day10;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {

    @Test
    public void dragAndDropTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);

        WebElement kaynak=findById("draggable");
        WebElement hedef=findById("droppable");

//        dragAndDrop() sürükleme işlemini gerçekelştirir
        Actions actions=new Actions(driver);

        actions.dragAndDrop(kaynak,hedef).perform();
    }

    @Test
    public void clickAndHoldTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);

        WebElement kaynak=findById("draggable");
        WebElement hedef=findById("droppable");

        Actions actions=new Actions(driver);
        actions.
                clickAndHold(kaynak).//kaynağı tut
                moveToElement(hedef).//hedefe koy
                release().//Kaynağı bırak
                build().//önceki methodların ilişkisini kur/güçlendir.KULLANILMASI TERCİH EDİLİR ŞART DEĞİLDİR
                perform();//işlemi gerçekleştirir

    }

    @Test
    public void moveByOffSetTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);

        WebElement kaynak=findById("draggable");
        WebElement hedef=findById("droppable");

        Actions actions=new Actions(driver);
        actions.clickAndHold(kaynak).moveByOffset(400,14).perform();

    }
}
