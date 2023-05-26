package org.pages.computer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class desktopPage extends computerPage {
    private WebDriver driver;
    public desktopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
}
