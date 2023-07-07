package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {

    @Test
    public void jsExecuterTypeTest() {
        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // reklamı kapattık
        bekle(2);

        // Arama kutusuna "QA" yazıp aratın
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'", aramaKutusu);
        //sendKeysJS(aramaKutusu,"QA");

        // 2. yol
        /*WebElement aramaKutusu = driver.findElement(By.xpath("//input[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttibute('value','QA'", aramaKutusu);
         */

        // sendAttributeJS(aramaKutusu, "QA");

    }
}
