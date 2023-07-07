package techproed.day21_Excel_JSExecutor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    @Test
    public void excelWriteTest1() throws IOException {

        // Bir "Nüfus" sütunu olusturun
        // baskent nufuslarını excel dosyasına yazınız.
        // (D.C: 1100, Paris:1500, London:1200, Ankara:1300)

        String dosyaYolu = "src/test/java/resourses/Capitals (1).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        // capitals dosyasını bizim sistemimize getirdik.

        Workbook workbook = WorkbookFactory.create(fis);
        // dosyayı workbook'a atadık.

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(1500);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(1200);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(1300);
        // Excel'de bir hücre olusturmak icin createCell() methodu kullanılır.
        // hücre icine yazdıracagımız deger icin setCellValue() methodu kullanılır.

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // dataları bizim class'ımızdan Capitals dosyasına gönderecegiz

        workbook.write(fos);
        // workbook'daki dataları fos'a yazdık.


    }
}