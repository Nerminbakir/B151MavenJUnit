package techproed.odev;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;


public class Faker01 extends TestBase {

    @Test
    public void test01() {

        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        bekle(2);

        //3. “firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(faker.name().firstName());
        bekle(2);

        //4. “surname” giris kutusuna bir soyisim yazin
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        bekle(2);

        //5. “email” giris kutusuna bir email yazin
        WebElement emailGirisKutusu = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[3]"));
        emailGirisKutusu.sendKeys(faker.internet().emailAddress());
        bekle(2);

        //6. “email” onay kutusuna emaili tekrar yazin
        emailGirisKutusu.sendKeys( Keys.CONTROL, "a");
        emailGirisKutusu.sendKeys(Keys.CONTROL, "c");
        emailGirisKutusu.sendKeys(Keys.TAB, Keys.CONTROL, "v");
        bekle(2);

        //7. Bir sifre girin
        driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(faker.internet().password());
        bekle(2);

        //8. Tarih icin gun secin
        WebElement ddmDay = driver.findElement(By.xpath("//select[@id='day']"));
        Select select = new Select(ddmDay);
        select.selectByVisibleText("10");
        bekle(2);

        //9. Tarih icin ay secin
        WebElement ddmMonth = driver.findElement(By.xpath("//select[@id='month']"));
        Select select1 = new Select(ddmMonth);
        select1.selectByVisibleText("Mar");
        bekle(2);

        //10. Tarih icin yil secin
        WebElement ddmYear = driver.findElement(By.xpath("//select[@id='year']"));
        Select select2 = new Select(ddmYear);
        select2.selectByVisibleText("1990");
        bekle(2);

        //11. Cinsiyeti secin
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        bekle(2);

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement sonSecilenOption = select.getFirstSelectedOption();
        Assert.assertTrue(sonSecilenOption.isSelected());

        //13. Sayfayi kapatin
        driver.close();
    }
}
