package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    @Test
    public void iframe() {

        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement kalinYazi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

        //==>  textBox içindeki yazıyı siliniz.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        /*
         Iframe'e gecmenin 2. yolu index ile;
         driver.switchTo().frame(0);

         Eger 2 tane iframe olsaydı ve 2. iframe'e gecmek isteseydim index'i 1 almam gerekecekti.
        */

        /*
        Iframe'e gecmenin 3. yolu id veya name value ile;
        iframe HTML kod blogunda id veya name attribute'u varsa
       driver.switchTo().frame("mce_0_ifr"); bu sekilde de gecis yapabiliriz.
         */

        bekle(2);
        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();

        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);

        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementSelenium.getText().contains("Elemental Selenium"));


    }
}
