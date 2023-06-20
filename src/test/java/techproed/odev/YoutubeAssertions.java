package techproed.odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeAssertions {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void youtubeAssertions1() throws InterruptedException {

        // 1)Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //=> Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@class='style-scope yt-icon'])[5]"));
        Assert.assertTrue(logo.isDisplayed());

    }
    public void youtubeAssertions2() throws InterruptedException {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }

    public void wrongTitleTest() throws InterruptedException {
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actuelTitle = driver.getTitle();
        Assert.assertFalse(actuelTitle.contains("youtube"));
    }

}


