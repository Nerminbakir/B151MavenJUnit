package techproed.day15_FileExist;

import org.junit.Test;
import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test
    public void fileExist() {

        System.out.println(System.getProperty("user.dir")); //C:\Users\nrmn_\IdeaProjects\B151MavenJUnit
        // System.getProperty("user.dir"); içinde oldugumuz projenin dosya yolunu (path) verir

        System.out.println(System.getProperty("user.home")); //C:\Users\nrmn_
        // System.getProperty("user.home"); herkesin bilgisayarında farklı olan kısmı verir

        // SORU
        // Desktop(masaustu)'da bir text dosyası olusturun
        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin


        /*
        Dosyanın bilgisayarımda desktop'ta olup olmadıgını java ile test ederiz. Cunku selenium web sayfalarını test ettiğinden bilgisayarımdaki
        desktop'a mudahale edemez.
         */

        //  "C:\Users\nrmn_\OneDrive\Masaüstü\text.txt"

        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\nrmn_\\OneDrive\\Masaüstü\\text.txt")));

        // Daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home"); // herkesin bilgisayarında farklı olan kısımdır.
        String ortakKisim = "\\OneDrive\\Masaüstü\\text.txt"; // herkesin bilgisayarında ortak olan kısımdır.

        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
