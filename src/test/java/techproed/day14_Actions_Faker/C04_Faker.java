package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {

    @Test
    public void faker() {

        // Faker class'ından sahte verileri kullanabilmek için obje olusturmamız gerekir.
        Faker faker = new Faker();

        // faker objesini kullanarak bir isim yazdırınız
        System.out.println("isim : " + faker.name().firstName());

        // faker objesini kullanarak bir lastName yazdırınız
        System.out.println("soyisim : " + faker.name().lastName());

        // faker objesini kullanarak bir fullName yazdırınız
        System.out.println("isim_soyisim : " + faker.name().fullName());

        // faker objesini kullanarak bir adress yazdırınız
        System.out.println("Adres : " + faker.address().fullAddress());

        // faker objesini kullanarak bir tel_no yazdırınız
        System.out.println("Cep Tel No : " + faker.phoneNumber().cellPhone());
        System.out.println("Tel No : " + faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Rastgele 15 haneli numara : " + faker.number().digits(15));

        // Meslek pozisyonu yazdıralım
        System.out.println(faker.job().position());

    }
}
