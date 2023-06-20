package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        bekle(2);

        //  ilk sayfasının Handle degerini alın yazdırın
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("Sayfa1 Handle Degeri : " + sayfa1Handle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement text = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assert.assertEquals("Opening a new window",text.getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle);
        bekle(2);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        // String sayfa2Handle = driver.getWindowHandle(); 2. sayfanın handle degerini almak istedim ama driver 2.sayfaya gecmediği için sayfa1'in
        // handle degeriyle aynı degeri verdi.Handle degerleri unique oldugu için yanlıs oldugundan getWindowHandles() methodunu kullandık.

        /*
        Eger bir butona tıkladıgımızda bizim kontrolümüz dısında 2. sayfa acılıyorsa otomatik acılan 2. sayfaya
        driver'ı gecirmemiz gerekir. 2. sayfa'ya driver'ı gecirebilmemiz için 2. sayfanın handle degerini bulmalıyız.
        getwindowHandles() methodu ile 2. sayfa'nın handle degerini tespit edebiliriz.Daha sonra driver.switchTo.window(sayfa2Handle) diyerek
        2. sayfaya driver'ı gecirebiliriz.
         */
        Set<String> windowHandleSet = driver.getWindowHandles();
        System.out.println(windowHandleSet);

        String sayfa2Handle = "";
        for (String each:windowHandleSet) {
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }
        }
        /*
        windowHandlesSeti.
        stream().
        filter(t->!t.equals(sayfa1Handle)).
        forEach(t-> System.out.println("2.Sayfa Handle değeri : " + t));
         */

        System.out.println("Sayfa2 Handle Degeri : " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String sayfa2Baslik = driver.getTitle();
        String arananKelime = "New Window";

        Assert.assertEquals(sayfa2Baslik,arananKelime);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(sayfa1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);
    }
}
