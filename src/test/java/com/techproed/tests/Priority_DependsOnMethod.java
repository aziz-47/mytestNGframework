package com.techproed.tests;

import org.testng.annotations.Test;

public class Priority_DependsOnMethod {

    @Test(priority = 1)
    public  void login(){
        System.out.println("Bu method login methodudur");

    }

    @Test(priority = 2, dependsOnMethods = "login")
    public void homePage(){
        System.out.println("Bu method homePage methodudur");
    }

    @Test(priority = 3)
    public void search(){
        System.out.println("Bu method saerch methodudur");

    }

    @Test(priority = 4, dependsOnMethods = "search")
    public  void result(){
        System.out.println("Bu method result methodudur");
    }

}
