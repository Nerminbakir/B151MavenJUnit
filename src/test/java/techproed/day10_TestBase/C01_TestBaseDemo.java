package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
        @Test
    public void test01() {

            // techproeducation sayfasına gidiniz
            driver.get("https://techproeducation.com");

            // Baslıgın "Bootcamp" içerdiğini test ediniz.
            String actualTitle = driver.getTitle();
            String arananKelime = "Bootcamp";
            Assert.assertTrue(actualTitle.contains(arananKelime));

        }
}
