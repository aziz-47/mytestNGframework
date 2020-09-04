package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends TestBase {
    //Tests packagenin altina bir class oluşturun : UploadFile
    //Bir metod oluşturun : uploadFileMethod
    //Yuklemek istediginiz dosyayi secin.
    //Upload butonuna basin.
    //“File Uploaded!” textinin goruntulendigini dogrulayin.

    @Test
    public  void UploadFile(){
        //https://the-internet.herokuapp.com/upload bu adrese gidin
        driver.get("https://the-internet.herokuapp.com/upload");
        //choosFile bittonunu bulalim
        WebElement choosFileButton= driver.findElement(By.id("file-upload"));
        //Yuklemek istediginiz dosyayi secin.
        String filePath="C:\\Users\\Dell\\Downloads\\Code Bank.xlsx";
        //sendKeys() kullanabilmek icin choosfileEmentinin tagi = input ve type = "file" olmali
        choosFileButton.sendKeys(filePath);
        //Upload butonuna basin
        WebElement uploadbutton= driver.findElement(By.id("file-submit"));
        uploadbutton.click();
        //“File Uploaded!” textinin goruntulendigini dogrulayin.
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");
    }

}
