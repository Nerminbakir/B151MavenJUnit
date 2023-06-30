package techproed.day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    // thead; tablonun baslıgı          // tbody; tablonun içi(gövdesi)
    // tr; satır                        // tr; satır
    // th; sütun                        // td; sütun


    @Test
    public void webTablesTest01() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        // tablo1'i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo1");
        System.out.println(table1.getText());

        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");


    }

    @Test
    public void webTablesTest02() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        // 3.satır verilerini yazdırın
        List<WebElement> list = driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));
        list.stream().forEach(t-> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTablesTest03() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //  Son satırın verilerini yazdırın
        List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr[last()]//td"));
        sonSatirVerileri.stream().forEach(t-> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTablesTest04() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //  5. Sütun baslıgını yazdırın
        List<WebElement> besinciSutunBasligi = driver.findElements(By.xpath("//table[1]//thead//tr[1]//th[5]"));
        besinciSutunBasligi.stream().forEach(t-> System.out.println(t.getText()));

    }

    @Test
    public void webTablesTest05() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //  5. Sütun verilerini yazdırın
        List<WebElement> besinciSutunVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        besinciSutunVerileri.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void webTablesTest06() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        // Iki parametreli bir Java metodu oluşturalım: printData
        // Parameter 1 = satır numarası
        // Parameter 2 = sütun numarası
        // printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        printData(2,3);
        printData(2,5);
        printData(3,2);
        // printData(1,7); 7. sutun olmadıgı icin NoSuchElementException hatası alırız

    }

    public void printData(int satir, int sutun) {
    WebElement satirSutun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
    System.out.println(satirSutun.getText());

    }
}
