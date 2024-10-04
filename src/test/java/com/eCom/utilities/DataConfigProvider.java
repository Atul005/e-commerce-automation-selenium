package com.eCom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class DataConfigProvider {

    Properties properties;

    public DataConfigProvider() {
        File src = new File("./Configurations/config.properties");
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(src);
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser(){
        return (String) properties.get("browser");
    }

    public String getUrl(){
        return (String) properties.get("url");
    }

}
