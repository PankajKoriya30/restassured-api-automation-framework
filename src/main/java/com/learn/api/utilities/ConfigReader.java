package com.learn.api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties(String environment){

        try {
            String filePath = "src/test/resources/config/"+environment+".properties";
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(environment + ".properties file not found.");
        }
    }
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}

