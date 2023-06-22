package techproed.day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class C03_NullPointerException {

    /*
    NullPointerException;
    değişken ya da obje olusturup bu degişkene atama yapmadıgımızda ya da esitlemediğimizde
    NullPointerException hatası alırız.
     */

        WebDriver driver;

        Faker faker;

        Actions actions;

        Integer sayi;

        String isim;

    @Test
    public void NullPointerExceptionTest01() {
        // driver = new ChromeDriver(); atamasını yapmadıgımız için NullPointerException hatasını aldık.
        driver.get("https://amazon.com");
    }

    @Test
    public void NullPointerExceptionTest02() {
        //  Faker faker = new Faker(); atamasını yapmadıgımız için NullPointerException hatasını aldık.
        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest03() {
        //  Actions actions = new Actions(); atamasını yapmadıgımız için NullPointerException hatasını aldık.
        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest04() {
        //  Integer sayi; atamasını yapmadıgımız için NullPointerException hatasını aldık.
        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest05() {
        //  String isim; atamasını yapmadıgımız için NullPointerException hatasını aldık.
        System.out.println(faker.name().firstName());
    }


}
