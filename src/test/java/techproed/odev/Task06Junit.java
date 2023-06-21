package techproed.odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task06Junit extends TestBase {

    @Test
    public void test01() {

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement sayfa = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(sayfa)
                .moveByOffset(70, 30)
                .moveByOffset(70, -30)
                .moveByOffset(-70, 30)
                .moveByOffset(-70, -30)
                .moveByOffset(70, 30)
                .moveByOffset(70, -30)
                .moveByOffset(-70, 30)
                .moveByOffset(50, 50)
                .moveByOffset(50, 50)
                .moveByOffset(50, 50)
                .moveByOffset(50, 50)
                .release()
                .perform();


        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[@class='button clear']")).click();

        //- Sayfayi kapatiniz
        driver.close();
    }
}
