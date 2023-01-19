package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void excelReadTest() throws IOException {
//        WORKBOOK(EXCELL DOSYASI) > WORKSHEET/SHEET(SAYFA) > ROW(SATIR) > CELL(HÜCRE-VERİ)

        String path = "./src/test/java/resources/Capitals.xlsx";

//        DOSYAYI AÇ
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCEL DOSYASINI/WORKBOOK AÇ
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        SAYFAYI AÇ/SHEET 1
//        Sheet sheet1=workbook.getSheetAt(0);//index 0 dan başlar. İlk sayfayı aç
        Sheet sheet1 = workbook.getSheet("Sheet1");//gitmek istediğimiz sayfayı direkt açar. Sheet1 isimli sayfayı açar
//         İLK SATIRA GİT/ Row
        Row row1 = sheet1.getRow(0);//ilk satıra git
//        İLK SATIRDAKİ İLK VERİYİ AL
        Cell cell1 = row1.getCell(0);//İLK HÜCREDEKİ DATAYI VER
//        O VERİYİ YAZDIR

        System.out.println(cell1);

//        1.SATIR 2.SÜTUN
        Cell cell2=sheet1.getRow(0).getCell(1);
        System.out.println(cell2);

//        3.SATIR 1.SÜTUNU YAZDIR VE O VERİNİN FRANCE OLDUĞUNU TEST ET
        String cell3=sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell3);
        Assert.assertEquals("France",cell3);


//        EXCELDEKİ TOPLAM SATIR SAYISINI BUL
        int toplamSatirSayisi=sheet1.getLastRowNum()+1;//son satır numarası. Index sıfırdan başladığı için +1 ekledik
        System.out.println(toplamSatirSayisi);

//        KULLANILAN TOPLAM SATIR SAYISINI BUL
        int kullanilanToplamSatırSayisi=sheet1.getPhysicalNumberOfRows();//1 den başlıyor
        System.out.println(kullanilanToplamSatırSayisi);

//        COUTRY, CAPITALS key ve valueları map a aliıp print et
//        {{USA, D.C}}, {{France,Paris}}

//        Variable oluşturalım. Bu variable exceldeki country, capital verilerini tutacak
        Map<String,String> ulkeBaskentleri= new HashMap<>();

        for (int satırSayisi=1; satırSayisi<kullanilanToplamSatırSayisi; satırSayisi++){
            String country=sheet1.getRow(satırSayisi).getCell(0).toString();
            String capital=sheet1.getRow(satırSayisi).getCell(1).toString();

            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);






























    }
}
