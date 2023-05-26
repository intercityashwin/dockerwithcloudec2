package org.initializeCleanup;
import org.driverfactory.driverFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.propertyManager.initiateProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.URL;


public class initialize {
    protected static ThreadLocal<WebDriver> wbDriver = new ThreadLocal<WebDriver>();
    @BeforeMethod
    public void initilization() throws IOException {
        String host = "localhost";
        if(initiateProperties.getProperty("remoteServer").toLowerCase().equals("true")){
            if(System.getProperty("HUB_HOST")!=null)
                host = System.getProperty("HUB_HOST");
            String url = "http://" + host +":4444/wd/hub";
            MutableCapabilities dc;
            System.out.println("BROWSER VALUE IS : " + System.getProperty("BROWSER"));
            if(System.getProperty("BROWSER")==null){
                dc = initiateProperties.getProperty("browser").toLowerCase().equals("chrome")?new ChromeOptions():new FirefoxOptions();
                /*if(initiateProperties.getProperty("browser").toLowerCase().equals("chrome"))
                    dc = new ChromeOptions();
                else
                    dc = new FirefoxOptions();*/
            }else{
                dc = System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").toString().toLowerCase().equals("chrome")?new ChromeOptions():new FirefoxOptions();
                /*if(System.getProperty("browser")!=null && System.getProperty("browser").toString().toLowerCase().equals("chrome"))
                    dc = new ChromeOptions();
                else
                    dc = new FirefoxOptions();*/
            }
            wbDriver.set(new RemoteWebDriver(new URL(url),dc));
        }else{
            wbDriver.set(driverFactory.getDriver(initiateProperties.getProperty("browser")));
        }
        wbDriver.get().manage().window().maximize();
        wbDriver.get().get(initiateProperties.getProperty("url"));
        //wbDriver.set(driverFactory.getDriver(initiateProperties.getProperty("browser")));
        //wbDriver.get().manage().window().maximize();
        //wbDriver.get().get(initiateProperties.getProperty("url"));
    }

    public static WebDriver getDriver(){
       return wbDriver.get();
    }
    @AfterMethod
    public void tearDown(){
        wbDriver.get().quit();
    }

}
