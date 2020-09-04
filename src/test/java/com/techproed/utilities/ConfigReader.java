package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Bu classin amaci configuration.properties dosyaysindaki verileri(tetst datalari) okumaktir.
    //create Properties instance
    private static Properties properties;
    // FileInputStream kullanarak bir dosya aciyoruz
    //Properties bu dosyaya yukluyrouz
    //Daha sonra properties dosyasini okuyacagiz

    //Baslatmak icin static blok olusturuduk


    static{
        String path = "configuration.properties";
        try {
            FileInputStream file= new  FileInputStream(path);// FileInputStream kullanarak bir dosya aciyoruz
            properties= new Properties();
            properties.load(file);//Properties bu dosyaya yukluyrouz
        } catch (Exception e) {
            //System.out.println("fail path bulunamdi");
            e.printStackTrace();

        }
    }

    //okumak icin static bir method olusturalim
    //Bu method kullanci anhtar kelimeyi girdiginde (key) , value return eder
    public  static String getProperty(String key){
        return properties.getProperty(key);
    }

}
