package techproed.odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClassWork01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-C01_TekrarTesti isimli bir class olusturun
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin
        //4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //5. Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("Nutella", Keys.ENTER);

        //6. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi.getText());

        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc [] = sonucYazisi.getText().split(" "); // Yaklaşık 114.000.000 sonuç bulundu
        String s = sonuc[1].replaceAll("[^0-9]",""); // noktaları silmek için replaceAll kullandım
        int intS =  Integer.valueOf(s);

        if (intS >10000000){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //8. Sayfayi kapatin
        driver.close();
    }
}
