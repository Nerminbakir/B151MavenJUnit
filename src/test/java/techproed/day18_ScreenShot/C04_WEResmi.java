package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEResmi extends TestBase {

    /*
    Bir WE'nin resmini almak için önce WE'yi locate edip bir WE'ye assign ederiz.
    ve bu W'yi direk getScreenShotAs() methodunu kullanarak resmini belirttiğimiz dosyaya kaydederiz.
    */

    @Test
    public void test01() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        // iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        // cıkan sonucun ekran görüntüsünü alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/WebElementResmi/WEscreenShot" + tarih + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}
