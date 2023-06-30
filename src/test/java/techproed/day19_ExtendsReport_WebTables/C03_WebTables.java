package techproed.day19_ExtendsReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    /*
    WEBTABLE;
        <table> tagı ile baslar.
            <thead> başlıklar için bu tag ile devam eder.
                <tr> başlıkların satırı
                <th> table head
                    <td> baslıktaki veriler
                <tbody> başlıklar altındaki verileri temsil eder.
                    <tr> table row(satır)
                        <td> table data (tablodaki veri)
     */
    @Test
    public void test01() {

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo1");
        System.out.println(table1.getText());

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("************************************");
        System.out.println(ucuncuSatir.getText());

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//table)[1]//tr[4]"));
        System.out.println("************************************");
        System.out.println(sonSatir.getText());

        //    Task 4 : 5. Sütun verilerini yazdırın
        List<WebElement> besinciSutunVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        besinciSutunVerileri.stream().forEach(t-> System.out.println(t.getText()));

        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.






    }
}
