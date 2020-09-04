package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.pages.FHCRezervasyonPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCRezervasyonTest extends TestBase {

    @Test
    public void rezervasyonTest() throws InterruptedException {//http://www.fhctrip.com/admin/RoomReservationAdmin/Create
        driver.get("http://www.fhctrip.com/admin/RoomReservationAdmin/Create");
        //FHCLoginPage de bulunan login2() methodunu cagirmak icin obje olusturduk
        FHCLoginPage fhcLoginPage= new FHCLoginPage(driver);

        //fhcRezervasyonPage objesini olusturduk
        FHCRezervasyonPage fhcRezervasyonPage= new FHCRezervasyonPage(driver);
        //olusturdugumuz fhcLoginPage objesi ile login2() methodnuu cagir
        fhcLoginPage.login2();

        // fhcRezervasyon objesini kullanarak clastaki elemanlri cagir
        Select idUserSelect= new Select(fhcRezervasyonPage.idUser);//dropdown
        idUserSelect.selectByIndex(1);

        Select idHotelRoomSelect= new Select(fhcRezervasyonPage.idHotelRoom);//dropdawn(idhotelroom
        idHotelRoomSelect.selectByIndex(5);

        fhcRezervasyonPage.price.sendKeys("500");
        fhcRezervasyonPage.dateStart.sendKeys("08/15/2020");
        fhcRezervasyonPage.dateEnd.sendKeys("08/20/2020");
        fhcRezervasyonPage.adultAmount.sendKeys("2");
        fhcRezervasyonPage.childrenAmount.sendKeys("3");
        fhcRezervasyonPage.surname.sendKeys("EKE");
        fhcRezervasyonPage.phone.sendKeys("12345678901");
        fhcRezervasyonPage.email.sendKeys("abc@hotmail.com");
        fhcRezervasyonPage.notes.sendKeys("Gelsene buralar cok guzel");
        fhcRezervasyonPage.isApproved.click();
        fhcRezervasyonPage.isPaid.click();
        fhcRezervasyonPage.saveButton.click();

        Thread.sleep(3000);

     Assert.assertTrue(fhcRezervasyonPage.success_mesaj.isDisplayed());// 1 yol

     // String mesaj= fhcRezervasyonPage.success_mesaj.getText();
      //Assert.assertTrue(mesaj.equals("RoomReservation was inserted successfully"));//2 yol

        //ok buttonuna tiklayin

        fhcRezervasyonPage.OKButton.click();


    }
}
