package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {


    @BeforeMethod //Her test methodundan once calisir
    public  void beforMethod(){
        System.out.println("======Before Method=====");
    }

    @BeforeClass //Sadece classin basinda bir defa calisir.
    public  void beforeClass(){
        System.out.println("======Before Class====");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("====Before Test====");
    }

    @Test   // olmayan dependeysi eksik
    public  void  test1(){
        System.out.println("BU TEST1 METHODUDUR");

    }

    @Test
    public  void test2(){
        System.out.println("BU TEST2 METHODUDUR");

    }


    @Ignore// Sadece test anntational larda calsiri. test methodlarini goremzden gelir ve
    // @Test annitationu yoksa Ignore calismaz
    @Test
    public  void test3(){
        System.out.println("BU TEST3 METHODUDUR");

    }

    @AfterMethod// her test methodundan sonra calisir. 3 dafa calsiri
    public  void afterMethod(){
        System.out.println("=====After Method====");
    }

    @AfterClass // Clasiin sonunda sadece 1 defa calsir.
    public  void afterClas(){
        System.out.println("=====After Class======");
    }


    @AfterTest
    public  void afterTest(){
        System.out.println("=====After Test====");
    }
}
