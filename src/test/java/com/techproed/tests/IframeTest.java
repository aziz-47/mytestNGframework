package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    //Bir class olusturun: IframeTest
    //https://the-internet.herokuapp.com/iframe  adresine gidin.
    //Bir metod olusturun: iframeTest
    //“An IFrame containing….” textini konsolda yazdirin.
    //Text Box’a “Merhaba Dunya!” yazin.
    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.

    @Test
    public  void iframeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //“An IFrame containing….” textini konsolda yazdirin.
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //Text Box’a “Merhaba Dunya!” yazin.
       // WebElement textBox= driver.findElement(By.xpath("//p"));
        //textBox.sendKeys("Merhaba Dunya");

        //Test fail olursa ne yapmayliyiz.
        //1. olarak locetor kontrol edilmeli.
        //2. Olarak Wait(bekleme) problemi var mi yok mu kontrol edilemli
        //3. olarak sayfada iframe var mi kontrol edilmeli.

        //Bu sayfda iframe var. Dolaysisyla iframe switchTo() yapmaliyiz.
        // Bir iframe switch yapmanin 3 yolu vardir.:1. Index ile ,2 . id veya name vaule ile 3 . olarak WebElement ile
       // driver.switchTo().frame(0);//iframe de index sifirdan(0) dan baslar.index kullanarak iframe ye gidelim.
       // driver.switchTo().frame("mce_0_ifr");//id kullnarak iframe e gidelim
        WebElement frameElement= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);//webelement kullnarak iframe ye gidleim.

        //Artik iframe icindeki elemnti bulabiliriz.
        WebElement textBox= driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
        // locate Elemental selenium text
        //Parent frame geri gelelim
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();   // default page gider.
        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());

        //iframe  ==========>Buraya gelmek istiyorum. defaultContent();
        //     iframe  =====>Buraya gelmek istiyorum. parentFrame();
        //        iframe   => buradayim
        //            iframe



    }
}
