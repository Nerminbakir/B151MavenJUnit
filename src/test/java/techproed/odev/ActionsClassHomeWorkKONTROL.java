package techproed.odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsClassHomeWorkKONTROL extends TestBase {

    @Test
    public void test01() {

        //    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        bekle(2);

        //    2- Hover over  Me First" kutusunun ustune gelin
        WebElement ilkKutu = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(ilkKutu).perform();
        bekle(2);

        //    3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        link1.click();
        bekle(2);

        //    4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //    5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(2);

        //    6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHold);
        bekle(2);

        //    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        //    8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClickMe = driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickMe).perform();
        bekle(2);

        String actualClass=doubleClickMe.getAttribute("class");
        String expectedClass="h2[text()='Double Click Me!";
        Assert.assertEquals(expectedClass,actualClass);
    }
}
