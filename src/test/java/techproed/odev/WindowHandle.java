package techproed.odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle extends TestBase {

    @Test
    public void test01() {
        //● https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        bekle(2);
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("Sayfa1 handle = " + sayfa1Handle);

        //● Title in ‘Windows’ oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle,expectedTitle);

        //● Click here a tiklayin
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        bekle(2);

        //● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> windowHandleSet = driver.getWindowHandles();
        System.out.println(windowHandleSet);

        String sayfa2Handle = "";
        for (String each : windowHandleSet) {
            if (!each.equals(sayfa1Handle)){
                sayfa2Handle = each;
            }
        }

        System.out.println("Sayfa2 Handle Degeri : " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);

        String sayfa2Baslik = driver.getTitle();
        String arananKelime = "New Window";
        Assert.assertEquals(sayfa2Baslik,arananKelime);








    }
}
