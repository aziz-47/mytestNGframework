package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    //https://the-internet.herokuapp.com/download adresine gidin.
    //image1.jpg dosyasını indir
    //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.

    @Test
    public  void isExist(){
       String mevcutKlasor= System.getProperty("user.dir");
        System.out.println("MEVCUT KLASOR => " + mevcutKlasor);

        String userKlasor= System.getProperty("user.home");
                            //User/Dell
        System.out.println("USER KLASOR => " + userKlasor);

        String filePath = userKlasor + "/Downloads/Code Bank.xlsx";
        //String filePath= "C:\\Users\\Dell\\Downloads\\Code Bank.xlsx"; buda kullanilabilir
      boolean isFileExists=  Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExists);// eger dosya varsa (file exists) true ve pass olacak; yoksa test
         // fail olacak yani false olacak



    }

    @Test
    public  void downloadTest(){
        //https://the-internet.herokuapp.com/download adresine gidin.
        //image1.jpg dosyasını indir
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın
        driver.get("https://the-internet.herokuapp.com/download");
        //image1.jpg dosyasını indir
        WebElement image1= driver.findElement(By.linkText("image1.jpg"));
        image1.click();
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın
        // kullanici klasoru
       String userKlasor=  System.getProperty("user.home");
       // indirilen dosyanin konumunu yada yolunu(path) buluyoruz
       String filePath= userKlasor + "/Downloads/image1.jpg";
        //String filePath= "C:\\Users\\Dell\\Downloads\\image1.jpg"; burda kullanilabilir

        // burda da dosya var mi yokmu kontrol ediyoruz
       boolean isDownloaded= Files.exists(Paths.get(filePath));
       Assert.assertTrue(isDownloaded);// dosya yuklendiyse test pass olur degilse fail olur.


    }

}
