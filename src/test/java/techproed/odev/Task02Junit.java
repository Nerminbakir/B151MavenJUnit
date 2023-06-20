package techproed.odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02Junit {

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() {

        //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        //Before methodunda http://www.google.com adresine gidin
        //Üç farklı test methodu ile;
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("The God Father", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.cssSelector("div[id='result-stats']"));
        String [] sonuc = sonucYazisi.getText().split(" ");
        System.out.println(sonuc[1]);
    }

    @Test
    public void test02() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
        //driver.findElement(By.xpath("//*[@class='z1asCe MZy1Rb']")).click(); sayfaya filmin adını yazdırdıgımda sonuc yazısı ekrana gelmedi. arama butonuna click yaptım.
        driver.navigate().refresh(); // ya da sayfayı yenilersekte sorun çözülüyor
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String [] sonuc = sonucYazisi.getText().split(" ");
        System.out.println(sonuc[1]);

    }

    @Test
    public void test03() {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("Kill Bill", Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String [] sonuc = sonucYazisi.getText().split(" ");
        System.out.println(sonuc[1]);

    }
    @After
    public void tearDown() throws Exception {
        //After method'u ile başlıkları yazdırınız
        System.out.println(driver.getTitle());

    }

    @AfterClass
    public static void afterClass() throws Exception {
        //driver.close();
    }
}
