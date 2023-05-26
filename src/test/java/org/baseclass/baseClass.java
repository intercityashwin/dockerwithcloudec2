package org.baseclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class baseClass {
    private static final int DURATION_WAIT = 50;
    protected WebDriverWait wait;
    private WebDriver driver;

    public baseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(DURATION_WAIT));
    }

}
