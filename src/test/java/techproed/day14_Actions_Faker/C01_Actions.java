package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01() {

        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // cıkan reklamı kapattık
        bekle(2);

        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
        bekle(2);

    }

    @Test
    public void test02() {

        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // cıkan reklamı kapattık
        bekle(2);

        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        bekle(2);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).build().perform();
        // build() methodu action'ları birlestirmek için kullanılan methoddur. Birden fazla oluşturduğumuz action
        // objesini birbirine bağlar
        // Eger yapilan islemin cok hizli olmasini istemiyorsak build() kullanmak yerine her action'dan sonra perform() kullanmamiz gerekir.
        // release() methodu mouse'u serbest bırakır
    }

    @Test
    public void test03() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // cıkan reklamı kapattık
        bekle(2);

        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1500).perform();

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0, -1500).perform();

    }
}
