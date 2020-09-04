package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor {

    @Test
    public void javascriptExecutorTest(){
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        WebElement loginButton= Driver.getDriver().findElement(By.id("btnSubmit"));
        WebElement createButton= Driver.getDriver().findElement(By.xpath("//span[@class='btn btn-primary py-3 px-5']"));
       // clickElementByJS(createButton);
        //clickElementByJS(loginButton);
       // System.out.println(getTitleByJS());
       // scrollDownByJS();
       // WebElement instegram= Driver.getDriver().findElement(By.xpath("//*[.='Instagram']"));
        //scrollInToViewJS(instegram);

      //  WebElement image = Driver.getDriver().findElement(By.xpath("(//a[@class='blog-img mr-4'])[4]"));
       // scrollInToViewJS(image);

        //flash(loginButton);
        generateAlert("Evin kedisi buraya gelecek...");


    }

   //Bu method bir parametre alir (WebElement element)
    //elementi methodun icine yazdigimizda js bu elemnte tiklar
    public  void clickElementByJS(WebElement element){
        JavascriptExecutor jsExecutor= ((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("arguments[0].click();",element);
    }

    // sayfa basligini javascript ile alma methodu
    public String getTitleByJS(){
        JavascriptExecutor jsExecutor= ((JavascriptExecutor)Driver.getDriver());
        String title= jsExecutor.executeScript("return document.title;").toString();
        return title;
    }

    //Scrol down (sayfada asagi kaydirma ).Bu method sayfada en alt kimsa kadar kaydirir.
    public void scrollDownByJS(){
        JavascriptExecutor jsExecutor= ((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    //js ile bir elemente kadar kaydirma(scrolldown )
    public  void scrollInToViewJS(WebElement element){
        JavascriptExecutor jsExecutor= ((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",element);

    }

    //Secilen elementin background rengini degistirmek icin kullnadigimiz yontem.

    public void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0", element);
            changeColor(bgColor, element);
        }
    }
    public void changeColor(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   //Gerektiginde bir uyari(alert) olusturma
    public void generateAlert(String message){
        JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("alert('"+ message + "')");



    }

}
