package techproed.odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task07JUnit extends TestBase {

    @Test
    public void test01() {


        // -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement ikinciKutucuk = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(ikinciKutucuk);

        //-Sarı olduğunu test edelim






    }
}
