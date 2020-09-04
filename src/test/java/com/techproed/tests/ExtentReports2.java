package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReports2 extends TestBaseFinal {

    @Test
    public  void negativeTest(){
        extentTest= extentReports.createTest("FHC LOGIN TEST","FHC Login fonksiyonunu testi");
        extentTest.info("Url e git");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        extentTest.info("Gecersiz username gonder");
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        extentTest.info("Gecersiz password gonder");
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        extentTest.info("Login buttonuna tikla");
        fhcLoginPage.loginButton.click();

        extentTest.info("Assertion yap");
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
       extentTest.pass("PASSED: Try again plase");
        Driver.closeDriver();
        extentTest.pass("Driver kapatildi");
        ;
    }
}
