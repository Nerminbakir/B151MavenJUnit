package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    @Test
    public void windowHandle() {

        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        bekle(2);

        /*
        Techpro Education sayfasının handle degerini getWindowHandle() methodu ile elde edebiliriz.
         */

        String techproWindowHandle = driver.getWindowHandle();
        System.out.println("Techpro Education Handle Degeri : " + techproWindowHandle); //7B90D385C22B6058A805508906C2C5AE

        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";

        Assert.assertEquals(actualTitle,expectedTitle);

        //  Yeni bir pencere acıp, https://www.youtube.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencereye drive'ı taşır.
        // WindowType.TAB ==>yeni sekmede acar.

        driver.get("https://www.youtube.com");
        bekle(2);

        String youTubeWindowHandle = driver.getWindowHandle();
        System.out.println("YouTube Handle Degeri : " + youTubeWindowHandle); // 902A9A394D68DED101A80DD3F71BBC05


        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        bekle(2);

        /*
        Linkedin sayfasının handle degerini getWindowHandle() methodu ile elde edebiliriz.
         */

        String linkedinWindowHandle = driver.getWindowHandle();
        System.out.println("Linkedin Handle Degeri : " + linkedinWindowHandle); // EF081BA8CEA38DD69355E344ED11B81D

        //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        bekle(2);

        //  youtube sayfasına geçiniz
        driver.switchTo().window(youTubeWindowHandle);
        bekle(2);

        //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(2);
    }
}
