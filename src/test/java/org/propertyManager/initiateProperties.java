package org.propertyManager;
import java.io.IOException;

public class initiateProperties{

    public static String getProperty(String property) throws IOException {
        return propertyLoader.getPropertyLoader().get(property).toString();
    }
}
