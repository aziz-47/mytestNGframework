package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestGlbSignIn {

    @Test(groups = "grouptest1")
    public void validUserName(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_trd_url"));
        GlbSignInPage glbHomePage= new GlbSignInPage();
        glbHomePage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbHomePage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        glbHomePage.signUpButton.click();

        Assert.assertTrue(glbHomePage.sorryMesaj.isDisplayed());
        System.out.println("SORRY MESAJ: "+ glbHomePage.sorryMesaj.getText());

        Driver.closeDriver();

    }

    @Test(groups = "grouptest1")
    public void validPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_trd_url"));
        GlbSignInPage glbHomePage= new GlbSignInPage();
        glbHomePage.email.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        glbHomePage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbHomePage.signUpButton.click();

        Assert.assertTrue(glbHomePage.sorryMesaj.isDisplayed());
        System.out.println("SORRY MESAJ: "+ glbHomePage.sorryMesaj.getText());

        Driver.closeDriver();


    }

    @Test
    public void invalidUserPass(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_signin_url"));
        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("gecersiz_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        glbSignInPage.signUpButton.click();

        // Assert.assertTrue(glbHomePage.sorryMesaj.getText().equals("Sorry!"));
        Assert.assertTrue(glbSignInPage.sorryMesaj.isDisplayed());
        System.out.println("SORRY MESAJ: "+ glbSignInPage.sorryMesaj.getText());

        Driver.closeDriver();
    }



}
