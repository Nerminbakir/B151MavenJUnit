package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {

    @Test
    public void excelReadTest01() throws IOException {

        // excel dosyasından veri okuyabilmemiz için;
        // 1) dosya yolunu alırız
        String dosyaYolu = "src/test/java/resources/Excel.ods";

        // 2) Capitals dosyasını bizim sistemimize getirmeliyiz. Dosyayı okuyabilmek için akısa almalıyım
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3) dosyayı workbook'a atamalıyız. Java ortamında bir excel dosyası olusturmalıyız.
        Workbook workbook = WorkbookFactory.create(fis);

        // 4) sayfayı (sheet) secmeliyiz
        Sheet sheet = workbook.getSheet("Sayfa1");

        // 5) satırı (row) secmeliyiz
        Row row = sheet.getRow(0); // 1. satir, index 0'dan baslar

        // 6) hücreyi (cell) secmeliyiz
        Cell cell = row.getCell(0);  // 1. sütun, index 0'dan baslar

       }

    @Test
    public void readExcelTest02() throws IOException {

        // KISA YONTEM

        // 1. satir 1. sütundaki bilgiyi yazdırınız
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1Sutun1 = workbook.getSheet("Sayfa1").getRow(0).getCell(0).toString();
        System.out.println(satir1Sutun1);

    }

    @Test
    public void readExcelTest03() throws IOException {

        // 1. satir 2. sütundaki hucreyi yazdırınız
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1Sutun2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(satir1Sutun2);





    }
}
