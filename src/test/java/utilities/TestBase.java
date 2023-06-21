package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class TestBase {

    // TestBase class'ından obje olusturulmasını istemediğimiz için class'ı abstract yaptık.
    // Bu class'a, extends ettiğimiz test class'larından ulasabiliriz.

    protected WebDriver driver; // public yapsakta olur
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    public void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void alertPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void alertText(){
        System.out.println(driver.switchTo().alert().getText());
    }

    public void ddmVisibleText(WebElement ddm, String secenek){

        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);

    }

    public void ddmIndex(WebElement ddm, int index){

        Select select = new Select(ddm);
        select.selectByIndex(index);

    }

    public  void ddmValue(WebElement ddm, String value){

        Select select = new Select(ddm);
        select.selectByValue(value);

    }

    public void visibleWait (WebElement element, int sayi){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
