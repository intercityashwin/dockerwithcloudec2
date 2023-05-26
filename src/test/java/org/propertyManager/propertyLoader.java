package org.propertyManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyLoader {

    public static propertyLoader propertyLoader;
    public static Properties prop;

    private propertyLoader() throws IOException {
        prop = new Properties();
        FileInputStream fis;
        try{
            fis = new FileInputStream("libs//Automation.properties");
        }catch (Exception e){
            fis = new FileInputStream("Automation.properties");
        }

        prop.load(fis);
    }

    public static Properties getPropertyLoader() throws IOException {
        if(propertyLoader == null) {
            propertyLoader = new propertyLoader();
        }
        return prop;
    }

}
