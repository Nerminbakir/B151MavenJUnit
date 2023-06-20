package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void actions() {

        /*
        Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard islemlerini gerçekleştirmek
        icin kullandigimiz hazır bir selenium kutuphanesidir. Ornegin, sag tiklamak(contextClick),
        çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement) gibi mouse islemlerini
        gerçekleştirebiliriz. Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada
        actions yardımıyla basabiliriz. Bu tur islemlerde sendKeys metodu kullaninir.

         */

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        // Sag click yapabilmek için öncelikle Actions Class'ından bir obje olusturmalıyız.
        Actions actions = new Actions(driver);
        actions.contextClick(kutu). // Sag click yapma methodu kullandık
                         perform(); // actions objemizle yapacagımız işlemi uygulaması için veya sonlandırması için perform() kullanırız

        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

        //Tamam diyerek alert'i kapatın
        alertAccept(); //TestBase'deki method
    }
}
