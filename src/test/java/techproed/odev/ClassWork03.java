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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ClassWork03 {

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
        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4. Password kutusuna “password” yazin
        driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[contains(text(),'Online Banking')]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[contains(text(),'Purchase Foreign Currency')]")).click();
        Thread.sleep(2000);

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currency);
        select.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(2000);

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.cssSelector("input[id='pc_amount']")).sendKeys("500");
        Thread.sleep(2000);

        //10.“US Dollars” in secilmedigini test edin
        WebElement dolar = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(dolar.isSelected());

        //11.“Selected currency” butonunu secin
        driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();
        Thread.sleep(2000);

        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        Thread.sleep(2000);

        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement yazi = driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertTrue(yazi.getText().equals("Foreign currency cash was successfully purchased."));
    }
}


//        3.Login alanina "username" yazdirin
//        4.Password alanine "password" yazdirin
//        5.Sign in buttonuna tiklayin
//        WebElement login = driver.findElement(By.cssSelector("input#user_login"));
//        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
//        Thread.sleep(2000);
//        driver.navigate().back();