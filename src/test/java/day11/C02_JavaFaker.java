package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest() {
//        1.Faker Objesi Oluşturulur
        Faker faker=new Faker();
//        2.Faker objesi ile fake data oluştur
        String firstName=faker.name().firstName();
        System.out.println("FirstName: "+firstName);

//        last name datası
        String lName=faker.name().lastName();
        System.out.println("lastname: "+lName);

//       kullanıcı adı
        String fUsername=faker.name().username();
        System.out.println("UserName: "+fUsername);

//        Maselek İsmi
        System.out.println("Meslek İsmi: "+faker.name().title());

//        Sehir İsmi
        System.out.println("Şehir İsmi: "+faker.address().city());

//        Eyalet İsmi
        System.out.println("Eyalet İsmi: "+faker.address().state());

//        Full Adress
        System.out.println("Full Adress: "+faker.address().fullAddress());

//        Cep telefon numarası
        System.out.println("Phone Number: "+faker.phoneNumber().cellPhone());

//        Email
        System.out.println("Email: "+faker.internet().emailAddress());

//        rastgele 15 haneli numara
        System.out.println("Faker Number "+faker.number().digits(15));

        /*
        Test Data: Kullanıcı adı, şifre, tel no,email, sehir,kredi kart no...

        Test dataları kimden alınır?
        1.BA-Business Analyst(Acceptance Criterialari yazar)
        2.Test Lead
        3.Manuel Tester
        4.Tech Lead &Team Lead &Dev Lead
        5.Developer
        6.Database
        7.API Call'lar
        8.Documantasyonlar. Orneğin API Swagger documanı
        9.Java Faker da fake data almak için kulllanıyoruz

        Nereden Gelmez:kullanıcıdan,scrum master
         */
    }
}


