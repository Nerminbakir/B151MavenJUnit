package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload  extends TestBase {

    @Test
    public void test01() {

        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        File silinecekDosya = new File("C:\\Users\\nrmn_\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        /*
        Eger localinizden otomasyon ile bir dosya silmek için File Class'ından obje olusturup dosya yolunuzu
        içine yerlestiririz. Ve olusturdugumuz obje ile delete() methodunu kullanarak o dosyayı silebiliriz.
        Bunu yapma sebebimiz test class'ımızı çalıştırdıgımızda her calsıtırmada yeni bir dosya indirecegi için
        ordaki dosya kalabalıgını önlemiş oluruz. Aynı zamanda dogrulama yaparken işimizi garantiye almıs oluruz.

        Aynı isimde birden fazla dosya indirmiş olsakta her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
        o klasörün içinde bulamayacağı için her zaman ilk dosyanın varlığını böylelikle test etmiş oluruz

         */

        //"b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']")).click();
        bekle(5);

        // Dosyanın başarıyla indirilip indirilmediğini test edin.
        /*
        dosyanın, bilgisayarımda dowloads'a basarıyla indirilip indirilmedigini
        java ile test edecegim.
        cünkü selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki dowloads'a müdahele edemez.
         */

        // Assert.assertTrue(Files.exists(Paths.get("\"C:\\Users\\nrmn_\\Downloads\\b10 all test cases, code.docx")));

        // daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
