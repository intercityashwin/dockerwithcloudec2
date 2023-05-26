package org.driverfactory;
import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.HashMap;
import java.util.Map;

public class driverFactory {
    private static Map<String,Supplier<WebDriver>> webDriverFactoryMap = new HashMap<String,Supplier<WebDriver>>();

    public static WebDriver getDriver(String browser){
        return webDriverFactoryMap.get(browser).get();
    }

    static {
        webDriverFactoryMap.put("chrome",()->new ChromeDriver());
        webDriverFactoryMap.put("firefox",()->new FirefoxDriver());
        webDriverFactoryMap.put("ie",()->new InternetExplorerDriver());
    }

}

