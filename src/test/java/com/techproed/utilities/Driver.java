package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //Driver class driver insctance i baslatmak icin kullanilri.(Sinngleton Driver)
    //ihtiyacimiz oldugunda driveri kurmak ve baslatmak icin kullaniyrouz.
    //driver null oldugunda create edip baslatacagiz.(if driver ==null)
    //Driver classi farkli browserlar(tarayici) ile kullanacagimiz sekilde olustruacagiz.

    private Driver(){
        //Baska obje olustrulmasini istemedgimiz icin create ediyrouz.
    }


    //driver instance olusturalim
    static WebDriver driver;

    //Driver i baslatmak icin sattic bir method olusturalim
    public static WebDriver getDriver(){
        if(driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver= new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){//eger driver choreme u isaret ediyorsa driveri kapat
            driver.quit();
            driver=null;//driverin null oldugundan emin olmak icin tekrar null olarak atayalim.Boyleikle driveri tekrar
                        // baslatabilrim.
                       //Multi browser test(chrome, firefox,ie....) yaparken bu onemli olacaktir.
        }
    }

}
