package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase {
    @Test
    public void RoomCreateTest() throws InterruptedException {
        //http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
        WebElement usernameBox = driver.findElement(By.id("UserName"));
        WebElement passwordBox = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        usernameBox.sendKeys("manager2");     //Username : manager2
        passwordBox.sendKeys("Man1ager2!");   //Password : Man1ager2!
        loginButton.click();
        //Add Hotel room butonuna tiklayin
        WebElement addHotelRoomButton = driver.findElement(By.className("hidden-480"));
        addHotelRoomButton.click();
        //Acilan sayfadaki butun textboxlara istediginiz verileri girin
        WebElement idHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(idHotel);
        select.selectByIndex(9);
        driver.findElement(By.id("Code")).sendKeys("King");
        driver.findElement(By.id("Name")).sendKeys("112");
        driver.findElement(By.id("Location")).sendKeys("City center");
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Deniz manzarali");

        Thread.sleep(3000);
        //price
        WebElement kaynak=driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement hedef= driver.findElement(By.id("Price"));
        actions.dragAndDrop(kaynak,hedef).perform();

        WebElement roomType= driver.findElement(By.id("IDGroupRoomType"));
        Select options= new Select(roomType);
        options.selectByIndex(7);

        WebElement adultCount= driver.findElement(By.id("MaxAdultCount"));
        adultCount.sendKeys("4");

        WebElement childCount= driver.findElement(By.id("MaxChildCount"));
        childCount.sendKeys("2");

        WebElement saveButton= driver.findElement(By.id("btnSubmit"));
        saveButton.click();
        //Save butonuna basin.
        WebElement saveButton1 = driver.findElement(By.xpath("//button[.='Save']"));
        saveButton.click();

        // explicty wait
        //“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
        WebDriverWait wait= new WebDriverWait(driver,20);
        boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);//true ise pass olur.

        WebElement okButton= driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        okButton.click();

         actions.sendKeys(Keys.HOME).perform();
        //Save butonuna basin.
        //“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
        //OK butonuna tiklayin.
        //Hotel rooms linkine tiklayin.
        WebElement hotelRoomsLink= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
       // actions.doubleClick(hotelRoomsLink).perform();
         hotelRoomsLink.click();

        //"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin
        WebElement lisOfHotel= driver.findElement(By.xpath("//span[.='List Of Hotelrooms']"));
        Assert.assertTrue(lisOfHotel.isDisplayed());
    }
}
