package techproed.day23_Log4j;

import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class C01_Log4j {

    @Test
    public void log4j() {

        /*
            Log4j system.out.println gibi her test adımında bilgilendirme yapmamıza yarayan bir api'dir.
        Log4j ile bu bilgilendirmeleri hem konsolda tarih ve saat olarak hemde src>main>resources içine
        koyduğumuz log4j.xml file da belirttiğimiz .log uzantılı dosyada yine tarih saat olarak kayıt altına almıs
        olacagız.
            Log4j kullanabilmek için öncelikle log4j-api ve log4j-core dependency lerini mvnrepository.com
        adresinden (aynı versiyon numaralarına sahip) alıp pom.xml dosyamıza koymalıyız.
            src>main>resources içine koydugumuz log4j.xml dosyasındaki kodlara pdf deki adresten ulaşabilirsiniz.
         */

        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");


    }
}
