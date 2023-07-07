package techproed.day21_Excel_JSExecutor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class C01_ExcelRead {

    @Test
    public void readExcelTest1() throws IOException {

        // 3. Satir 1. Sutun degerini yazdırın ve "France" oldugunu test edin.

        // Excel dosyasından veri okuyabilmemiz icin;
        // 1- Dosya yolunu alırız.
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        // 2- Capitals dosyasını bizim sistemimize getirmeliyiz.Dosyayı okuyabilmek icin akısa almalıyız.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- Dosyayı workbook'a atamalıyız. Java ortamında bir excel dosyası olusturmalıyız.
        Workbook workbook = WorkbookFactory.create(fis);
        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3Sutun1);
        Assert.assertEquals("France",satir3Sutun1);

        // Son satır sayısını bulunuz

        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("SON SATIR SAYISI : " + sonSatirSayisi);

        // excel tablosundaki son satır sayısını getLastRowNum() methodu ile alabiliriz
        // (index olarak verir)

        // Kullanılan satır sayısını bulunuz
        int kullanilanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("KULLANILAN SATIR SAYISI : " + kullanilanSatirSayisi);

        // Excel tablosundaki kullanılan satır sayısını getPhysicalNumberOfRows() methodu ile alabiliriz.
        // (index olarak vermez)
    }

    @Test
    public void readExcelTest2() throws IOException {

        // Capitals dosyasındaki tüm verileri yazdırınız.
        Map<String,String> capitalsMap = new HashMap<>();
        // Capitals dosyasındaki tüm verileri koyabilecegimiz en uygun java objesi map'dir.

        String dosyaYolu = "src/test/java/resourses/Capitals (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i <sonSatirSayisi ; i++) {
            String key =  workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            capitalsMap.put(key,value);

            //System.out.println(key+"/"+value);

        }
        System.out.println(capitalsMap);
    }
}
