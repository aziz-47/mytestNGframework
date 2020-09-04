package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCLoginPositiveTest extends TestBase {

    @Test
    public  void positiveTestLogin(){//http://www.fhctrip.com/Account/Logon
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage= new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton.click();


    }
}
