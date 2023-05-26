package org.pages;
import org.baseclass.baseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends baseClass {

    private WebDriver driver;

    @FindBy(css = ".ico-logout")
    private WebElement lnlLogout;

    @FindBy(css = "div.header-links ul a.account")
    private WebElement lnkUserEmail;


    public homePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void clickLogout(){
        lnlLogout.click();
    }

    public boolean isUserDisplayed(){
        return lnkUserEmail.isDisplayed();
    }

}
