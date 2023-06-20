package techproed.odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task04JUnit extends TestBase {
    @Test
    public void test01() {

        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        bekle(2);

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        bekle(2);

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        bekle(2);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        bekle(2);
        driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']")).click();
        bekle(2);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        bekle(2);

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
        bekle(2);
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        bekle(2);

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.xpath(""));
        textBox.sendKeys("Nermin");
        bekle(2);

        //-Çıkan mesajı konsola yazdırınız
        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
    }
}
