package techproed.day21_Excel_JSExecutor;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {

        /*
        Eger bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak olusturulduysa,
        o sayfayla etkilesimde bulunmak icin standart WebDriver komutları yetersiz kalabilir.

        Bu durumda sayfayla etkilesime gecebilmek icin JavaScriptExecuter arayuzunu kullanmak gerekir.
        JavaScriptExecuter arayuzu sayfaya dogrudan erisebilir.

        Ancak, mümkünse WebDriver'ın sundugu standart yöntemlerle sayfayla etkilesime gecmek her zaman daha iyidir.
        Cünkü JS kullanımı sayfanın daha yavas yuklenmesine neden olabilir.

         */
    @Test
    public void jsExecuterClick() {

        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");

        // returns kısmına tıklayın
        WebElement returns = driver.findElement(By.xpath("//a[@id='nav-orders']"));
        //returns.click();

        /*
        ilgili webElementin HTML kodu, JavaScript kullanılarak olusturulduysa,
        standart WebDriver komutu olan click() yetersiz kalabilir.
        Böyle durumlarda JavaScriptExecuter kullanılarak sayfayla etkilesime gecilebilir.
         */

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();",returns);

        click(returns);

    }
}