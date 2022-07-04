package com.fidexio.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();



    static {
        try {
            FileInputStream file;
            file = new FileInputStream("configuration.properties");
            properties.load(file);
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }




}
