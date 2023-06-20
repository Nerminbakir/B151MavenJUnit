package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    /*
    Implictly Wait; sayfadaki tüm webelementlerin yüklenebilmesi için max bekleme süresidir.
    Explicitly Wait; belirli bir koşul gerceklesene kadar max süre boyunca default olarak
    500ms aralıklarla webelementi kontrol ederek bekler.
    sadece belirli bir webelemenet için kullanılır.
     */

    @Test
    public void test01() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //==> Hello World! yazısının görünürlügünü test edin
        /*WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());

        Hello World! yazısının görünürlüğünü Implicitly Wait ile çözemedik
         */
        // 1.Yol

        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(helloWorld)); // beklenen şart.görünür olma(helloWorld)'sına kadar
        Assert.assertTrue(helloWorld.isDisplayed());


        // 2. Yol

//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//        WebElement helloWorldYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
//        Assert.assertTrue(helloWorldYazisi.isDisplayed());
    }
}
