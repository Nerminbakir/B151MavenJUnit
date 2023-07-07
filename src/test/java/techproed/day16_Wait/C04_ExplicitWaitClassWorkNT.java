package techproed.day16_Wait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TestBase;

import java.time.Duration;
public class C04_ExplicitWaitClassWorkNT extends TestBase {

    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me to open an Alert buttonuna basalım
        driver.findElement(By.xpath("(//button)[3]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        //Alert çıkana kadar bekleyecek

        //Çıkan Alert'ü kapatalım
        alertAccept();

    }
}
