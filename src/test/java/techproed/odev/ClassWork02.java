package techproed.odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClassWork02 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");
        Thread.sleep(2000);

        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("(//div[@class='inventory_item_img'])[1]")).click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        System.out.println(driver.findElement(By.xpath("//*[@class='cart_item']")).isDisplayed());

        //9. Sayfayi kapatin
        driver.close();



    }
}
