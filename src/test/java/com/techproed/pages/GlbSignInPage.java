package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignInPage {

    //Driver===>Driver.getDriver()

    public GlbSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[@value='Login']")
    public WebElement signUpButton;

    @FindBy(xpath = "//div[@class='my_account_header']")
    public WebElement MyAccount;

    @FindBy(xpath = "//strong")
    public WebElement sorryMesaj;

}
