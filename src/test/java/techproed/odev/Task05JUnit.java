package techproed.odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task05JUnit extends TestBase {

    @Test
    public void test01() {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        //WebElement ikinciEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement ikinciEmoji = driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]"));
        ikinciEmoji.click();
        bekle(2);

        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojiler = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']"));
        for (WebElement each : emojiler) {
            System.out.println(each.getText());
        }

        // Parent iframe e geri donun
        driver.switchTo().parentFrame();
        bekle(2);

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> kutucuklar = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> metin = new ArrayList<>(Arrays.asList("Nermin", "Bakır", "Aile", "Galatasaray", "123", "1987", "789", "456", "147", "ajkdvnjv", "afrhdjc"));

        for (int i = 0; i < kutucuklar.size(); i++) {
            kutucuklar.get(i).sendKeys(metin.get(i));

        }
        bekle(3);

        // Apply button a basiniz
        driver.findElement(By.xpath("//button[@id='send']")).click();
        bekle(2);


    }
}


