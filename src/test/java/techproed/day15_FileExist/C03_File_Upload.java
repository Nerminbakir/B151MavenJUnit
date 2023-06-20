package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_File_Upload extends TestBase {

    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
        bekle(2);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='file-upload']"));

        // "C:\Users\nrmn_\OneDrive\Masaüstü\deneme.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\deneme.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//input[@class='button']")).click();

        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement fileUploaded = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Assert.assertTrue(fileUploaded.isDisplayed());


    }
}
