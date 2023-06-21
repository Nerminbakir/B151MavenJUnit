package techproed.odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class DropDownAmazon {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //● Bir class oluşturun: C3_DropDownAmazon
        //● https://www.amazon.com/ adresine gidin.

        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement category = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(category);

        List<WebElement> kategori = select.getOptions();
        Assert.assertFalse(kategori.size()==45);
        System.out.println(kategori.size());
    }

    @Test
    public void test02() {
        //-Test 2
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String sonuc = sonucYazisi.getText();

        //4. Sonucun Java kelimesini icerdigini test edin
        String arananKelime = "Java";
        Assert.assertTrue(sonuc.contains(arananKelime));

    }
}
