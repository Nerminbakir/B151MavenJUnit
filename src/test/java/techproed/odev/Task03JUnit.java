package techproed.odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class Task03JUnit {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        //*** Aşağıdaki task'i Junit framework'ü ile yapınız
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        System.out.println(select.getOptions());

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        //Not: Select Class'ı kullanalım

        int sayac=1;
        for (WebElement w: select.getOptions()) {
            Select select1 = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            select1.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());

            driver.navigate().back();
            Thread.sleep(2000);
            sayac++;
            if (sayac>=6){
                break;
            }
        }
    }
}
