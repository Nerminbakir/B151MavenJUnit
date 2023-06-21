package techproed.odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class GenelTekrarTesti extends TestBase {

    @Test
    public void test01() {

        //1- amazon gidin
        driver.get("https://amazon.com");

        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> tumOptionlar = select.getOptions();

        for (WebElement w:tumOptionlar) {
            System.out.println(w.getText());
        }
        //select.getOptions().forEach(w-> System.out.println(w.getText())); -->Lambda ile

        //3. dropdown menude 40 eleman olduğunu doğrulayın

        List<WebElement> kategori = select.getOptions();
        Assert.assertFalse(kategori.size()==40);
        System.out.println(kategori.size());

//        int actualSize = select.getOptions().size();
//        Assert.assertNotEquals(40, actualSize );
//        System.out.println("ddm sayisi : " + actualSize);
    }

    @Test
    public void test02() {

        //1. dropdown menuden elektronik bölümü seçin
        driver.get("https://amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        bekle(2);

        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        bekle(2);
        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")); // 1-48 of over 6,000 results for "iphone"

        String [] sonuc = sonucYazisi.getText().split(" ");
        System.out.println(sonuc[3]);

        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String iphone = sonucYazisi.getText();
        Assert.assertTrue(iphone.contains("iphone"));

        //4. ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("((//img[@class='s-image'])[1]"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("div")).toRightOf(birinciUrun));
        ikinciUrun.click();
        bekle(2);

        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String actualTitle = driver.getTitle();
        System.out.println("Ürün baslıgı : " + actualTitle);
        WebElement fiyat = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]"));
        String urunFiyati = fiyat.getText();
        System.out.println("Ürün Fiyatı : " + urunFiyati);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']]")).click();




    }

    @Test
    public void test03() {

        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2. dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");
        bekle(2);

        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bebek puset", Keys.ENTER);
        WebElement sncYazisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] snc = sncYazisi.getText().split(" ");
        System.out.println(snc[0]);

        //4. sonuç yazısının puset içerdiğini test edin
        String sonuc = sncYazisi.getText();
        Assert.assertTrue(sonuc.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin

        WebElement ikinciUrun = driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
        driver.findElement(with(By.tagName("a")).below(ikinciUrun)).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title = driver.getTitle();
        System.out.println(title);
        WebElement fiyat = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]"));
        String urunFiyati = fiyat.getText();
        System.out.println("Ürün Fiyatı : " + urunFiyati);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']]")).click();


    }

    @Test
    public void test04() {

        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
