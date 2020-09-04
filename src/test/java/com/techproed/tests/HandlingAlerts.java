package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingAlerts extends TestBase {

    //Bir class olusturun: HandlingAlerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.



    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //locate 1. button
        WebElement button1= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button1.click();
        //Allert uzerindeki mesaji consalo yazdir.
        System.out.println("Allert mesaji: " +driver.switchTo().alert().getText());

        //uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();//accept () ==>click OK demektir.
        //result mesajının görüntülendiğini doğrulayın
        // locate result mesaji
        WebElement resulMesaj= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resulMesaj.isDisplayed());//Hard assert kulllandik.

    }

    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //2. buttonu locate edelim.
        WebElement button2= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button2.click();
        //uyarıdaki Cancel butonuna tıklayın.
        driver.switchTo().alert().dismiss();// dismiss() ===> cansel buttonuna basmak demktir.
        //result mesajının görüntülendiğini doğrulayın.
        WebElement resultMesaj= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult= resultMesaj.getText();
        String expectedResult= "You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);


    }

    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
       //locate 3. button.
        WebElement button3= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button3.click();
        //uyarıdaki metin kutusuna isminizi yazin.
        driver.switchTo().alert().sendKeys("ZAFER");
        //OK buttonuna tiklamak icin.
        driver.switchTo().alert().accept();
        //result mesajının görüntülendiğini doğrulayın
        WebElement resulMesaj= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resulMesaj.isDisplayed());

    }





}
