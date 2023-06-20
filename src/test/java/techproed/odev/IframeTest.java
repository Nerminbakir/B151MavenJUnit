package techproed.odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IframeTest extends TestBase {

    @Test
    public void iframeTest() {

        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        bekle(2);

        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin
        WebElement text = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(text.isEnabled());

        // ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.sendKeys("   Merhaba Dünya!");
        bekle(2);

        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.

        driver.switchTo().parentFrame(); //driver.switchTo().defaultContent(); bu da olabilir
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());

        // SORUDAN BAGIMSIZ OLARAK sayfadaki toplam iframe sayısı bulmamız istenseydi;
        // Tüm iframe elementlerini bulun
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        // List<WebElement> iframeElements = driver.findElements(By.xpath("//iframe"));

        // Toplam iframe sayısını yazdırın
        System.out.println("Toplam iframe sayısı: " + iframeElements.size());

    }
}
