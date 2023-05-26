package org.pages.computer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class notebookPage extends computerPage {
    private WebDriver driver;
    public notebookPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
}
