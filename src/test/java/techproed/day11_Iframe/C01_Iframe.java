package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe() {

    //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

    //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        WebElement anIframeYazisi = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(anIframeYazisi.getText().contains("black border"));

    //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
        WebElement iframe = driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iframe);

        /*
            Applications lists yazisini dogru locate edip dogru sekilde görünür oldugunu test etmemize ragmen failed oldu.
            Bunun üzerine HTML kodlarını inceleyince Applications lists yazisinin aslında bir iframe içerisinde oldugunu
            gördük. Bu durumda önce iframe'i locate edip switchTo() methodu ile iframe'e gecmeliyiz.
         */

        WebElement appLists = driver.findElement(By.xpath("//h1[text()='Applications lists']"));
        Assert.assertTrue(appLists.isDisplayed());

    //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().defaultContent(); // defaultContent(); anasayfaya gecmek için kullandık.  parentFrame() methodu da kullanılabilir.

        /*
        parentFrame() methodu bir üst seviyedeki Iframe'e cıkmak için kullanılır.
        defaultContent() methodu en üst seviyedeki Iframe'e cıkmak için kullanılır.
         */
        WebElement poveredBy = driver.findElement(By.xpath("//p[text()='Povered By']"));
        Assert.assertTrue(poveredBy.getText().contains("Povered"));

   }

}
