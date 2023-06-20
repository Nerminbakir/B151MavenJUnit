package techproed.odev;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Action5 extends TestBase {

    @Test
    public void actions() {

        // Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna basın

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).sendKeys("iPhone X fiyatlari").
                keyUp(Keys.SHIFT).sendKeys(" cok pahali!", Keys.ENTER).perform();


    }

    @Test
    public void test02() {
        // google anasayfasına gidiniz
        driver.get("https://google.com");

        // arama kutusunda shift tusuna basılı olarak selenium yazdırınız ve shift tusunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "iPhone X fiyatlari", Keys.SHIFT, " cok pahali!", Keys.ENTER);
        bekle(2);


    }
}
