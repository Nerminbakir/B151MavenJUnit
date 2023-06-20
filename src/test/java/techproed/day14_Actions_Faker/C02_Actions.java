package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {
        // https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        // Drag me to my target webelementini Drop here webelementi üzerine bırakalım
        /*
        drag ve drop webelementleri iframe içinde oldugu için iframe'ye gecis yapmalıyız
        */

        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();

        /*
        Eger hareketli bir webelementi tutup baska bir webelementin üzerine bırakmak istersek
        sürüklemek istediğimiz webelementin locate'ini alıp üzerine bırakacagımız webelementin locatinide alarak
        dragAndDrop(kaynak, hedef) methodu ile işlemi gercekleştirebiliriz
         */

    }

    @Test
    public void test02() {
        // https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag). // Bu method ile webelemente mouse ile basılı tuttuk
                moveToElement(drop). // Bu method ile basılı tuttugumuz webelementi diger webelementin uzerine göturduk
                release(). // Bu method ile mouse'u basılı tuttugumuz webelementi serbest bıraktık
                perform(); // işlemi sonlandırdık

    }

    @Test
    public void test03() {

        // https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(150, 28). // Belirtmiş oldugumuz koordinatlara webelementi tasır
                release().perform();

    }
}
