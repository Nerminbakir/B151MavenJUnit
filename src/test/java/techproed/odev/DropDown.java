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

import java.time.Duration;
import java.util.List;

public class DropDown {

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
    public void test01() throws InterruptedException {

        //Bir class oluşturun: DropDown
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(option1);
        select.selectByIndex(1);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement option2 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select2 = new Select(option2);
        select2.selectByValue("2");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumOptionlar = select.getOptions();

        for (WebElement each:tumOptionlar) {
            System.out.println(each.getText());
        }

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True, degilse False yazdırın
        int dropdownSize = select.getOptions().size();
        boolean hasFourOptions = dropdownSize == 4;
        System.out.println("Dropdown boyutu: " + dropdownSize);
        System.out.println("Dropdown'da 4 öğe var mı? " + hasFourOptions);
    }
}

