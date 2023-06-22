package techproed.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void NoSuchElementException() {
        /*
        NoSuchElementException;
        sayfada bulunmayan bir elemente erisim saglanmaya calısıldıgında NoSuchElementException hatası alırız.

        */

        // techpro education sayfasına gidiniz
        driver.get("https://www.techproeducation.com");
        bekle(2);

        // reklamı kapatınız
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        bekle(2);

        // arama butonuna "java" yazıp aratın.
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER);
        bekle(2);

        // locate'i yanlıs alırsak NoSuchElementException hatası alırız


    }
}
