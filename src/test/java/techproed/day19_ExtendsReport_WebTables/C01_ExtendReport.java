package techproed.day19_ExtendsReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtendReport extends TestBase {

    /*
    EXTENTREPORT;
        1) ExtendReport (aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı dependency'i
        pom.xml dosyamıza ekleriz.
        2) ExtentReports Class'ından class seviyesinde obje olustururuz.
        3) ExtentHtmlReporter Class'ından class seviyesinde obje olustururuz.
        4) ExtentTest Class'ından class seviyesinde obje olustururuz.
     */
    ExtentReports extentReports; // Raporlamayı baslatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter; // Raporu HTML formatında düzenler
    ExtentTest extentTest; // Test adımlarına eklemek istediğimiz bilgileri bu class ile olustururuz.
    @Test
    public void test01() {

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport.html" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter); // HTML formatında raporlamayı baslatacak

        // Raporda görünmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Nermin");
        extentHtmlReporter.config().setDocumentTitle("Extend Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

        // amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        // baslıgın "Amazon" içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains( "Amazon"));
        extentTest.info("Baslığın Amazon içerdiği test edildi");

        //arama kutusunda "iphone" aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");

        // sonuc yazısını konsola yazdıralım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());
        extentTest.info("Sonuc yazısı konsolda yazdırıldı");
        extentTest.pass("Sayfa kapatıldı");

        /*
            ExtentTest objesi ile info() methodunu kullanarak her stepte ne yaptıgımızla alakalı bilgi yazabiliriz.
        Testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
        ekleyebiliriz.
            Son olarak actions'daki perform() methodu gibi extentReport objesi ile flush() methodu kullanarak
        raporu sonlandırırız.
         */
        extentReports.flush(); // bu methodu kullanmazsak raporumuz olusmaz.


    }
}
