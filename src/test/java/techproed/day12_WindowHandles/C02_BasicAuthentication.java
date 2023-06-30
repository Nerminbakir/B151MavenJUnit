package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    /*
    Authentication; Kimlik dogrulama yöntemidir.
    Söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder.
    Authentication üzerinde sag click yapıp locate alınamaz.
    Authentication bir alert degildir.
    Authentication yapabilmek için uygulamanın kullanıcılara Authentication'ın nasıl yapılacagını dair bilgilendirme
    yapmıs olması gerekir. (https://username:password@URL gibi)
     */
    @Test
    public void basicAuthentication() {

        // Aşağıdaki bilgileri kullanarak authentication yapınız:
        // Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin
        // Yukarıda belirtilen formata uygun kimlik dogrulaması yapılacaktır.  https://username:password@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);
        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations"));

        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//--> Açılan yeni pencereye geçtik

        //Başlığın Elemental Selenium olmadığını doğrulayın
        System.out.println("Sayfa Başlığı : "+driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());

        //DDM'den java seçelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        /*
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");
         */
        selectVisibleText(ddm,"Java"); //--> Method ile

    }

}
