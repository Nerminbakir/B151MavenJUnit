package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDown_KeyUp extends TestBase {

    @Test
    public void test01() {

        // google anasayfasına gidiniz
        driver.get("https://google.com");

        // arama kutusunda shift tusuna basılı olarak selenium yazdırınız ve shift tusunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT). // arama kutusunda shift tusuna bastık
                sendKeys("selenium"). // selenium metnini shift tusuna basılı kaldıgı için buyuk harflerle yazdı
                keyUp(Keys.SHIFT). // shift tusunu serbest bıraktık
                sendKeys("-java", Keys.ENTER). // bu kısmı shift'i serbest bıraktıgımız için kucuk yazdı
                perform();

    }

    @Test
    public void test02() {
        // google anasayfasına gidiniz
        driver.get("https://google.com");

        // arama kutusunda shift tusuna basılı olarak selenium yazdırınız ve shift tusunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, "-java", Keys.ENTER);
        bekle(2);

        /*
        Mouse işlemleri için action class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
        actions class'ını kullanmadan sendKeys() methodu ile de istedigimiz bir metni buyuk harfle yazdırabilir hatta
        birden fazla klavye tuslarına bastırabiliriz. Yukarıdaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
        sonrasında yazdırmak istedigimiz metni kucuk harfle yazmamıza ragmen buyuk harflerle yazdırdı. Tekrar Keys.SHIFT
        kullanarak shift tusunu serbest bırakmıs olduk.
         */
    }

    @Test
    public void test03() {

        //google sayfasına gidelim
        driver.get("https://google.com");

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("Selenium", Keys.ENTER);

        // Sayfayı bekleyin
        bekle(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@id='APjFqb']")). // sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL, "a"); //Metni kesebilmemiz için önce ctrl+a ile secmemiz gerekir
        bekle(2);
        driver.findElement(By.xpath("//*[@id='APjFqb']")).
                sendKeys(Keys.CONTROL, "x"); // Secilen metni ctrl+x ile kestik
        bekle(2);

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@id='APjFqb']")).
                sendKeys(Keys.CONTROL, "v", Keys.ENTER); // kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıstırdık ve arattık
    }
}
