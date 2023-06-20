package techproed.odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class Cookies extends TestBase {

    @Test
    public void cookies() {
        //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://amazon.com");

        //1.toplam cookie sayisini bul
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w : cookieSet) {
            System.out.println(sayac + ". Cookie : " + w);
            sayac++;
        }
        System.out.println("Sayfadaki cookie sayısı : " + (sayac-1));

        //3. Bir Cookie yi ismiyle bul
        Cookie cookie = driver.manage().getCookieNamed("ubid-main");
        System.out.println(cookie);

        //4. Yeni bir cookie ekle
        Cookie c = new Cookie("yeni cookie", "yeniler iyidir");
        driver.manage().addCookie(c);

        cookieSet = driver.manage().getCookies();
        for (Cookie each :cookieSet) {
            System.out.println(each);

        }
        Assert.assertEquals("yeniler iyidir", driver.manage().getCookieNamed("yeni cookie").getValue());
        System.out.println("Cookie'lerin Sayısı : " + Arrays.stream(driver.manage().getCookies().toArray()).count());


        //5. Bir Cookie yi ismiyle sil
        int silinmedenOnce = cookieSet.size();
        System.out.println("Silinmeden önceki cookie sayısı : " + silinmedenOnce);
        bekle(2);

        driver.manage().deleteCookieNamed("sp-cdn");
        bekle(2);

        cookieSet = driver.manage().getCookies();
        int silindiktenSonra = cookieSet.size();
        System.out.println("Silindikten sonraki cookie sayısı : " + silindiktenSonra);
        Assert.assertEquals(1, (silinmedenOnce - silindiktenSonra));

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());

    }
}
