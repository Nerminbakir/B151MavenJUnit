package techproed.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
        StaleElementReferanceException:

        bir web sayfasındaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.

        Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
        yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasını alırız.

        Bunu handle edebilmek icin webelemente yeniden aynı locate'ı atamalıyız.
        (webelementin locate'ını hatırlatma gibi diyebiliriz.)

     */

    @Test
    public void StaleElementReferenceExceptionTest01() {

        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        //sayfayi yenileyelim
        driver.navigate().refresh();
        bekle(2);

        //LMS Login butonuna tiklayalim
        driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]")).click();
        bekle(2);
    }

    @Test
    public void StaleElementReferenceExceptionTest02() {

        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        //LMS Login butonuna locate'ini alalım
        WebElement login = driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]"));
        bekle(2);

        //sayfayi yenileyelim
        driver.navigate().refresh();
        bekle(2);

        //LMS Login butonuna tiklayalim
        login.click();
        //driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]")).click(); bu şekilde yapmalıyız.
        bekle(2);

        /*
        LMS LOGIN webelementini locate ettikten sonra sayfayı yenilediğimiz için LMS LOGIN webelementi
        eskidi(bayatladı). Sonrasında bayatlayan webelemente click yaptıgımız için StaleElementReferenceException
        hatası aldık. Bu exception'ı handle edebilmek için refresh yaptıktan sonra tekrar tekrar aynı locate'i webelemente
        atamamız gerekiyor.
        */
    }
}
