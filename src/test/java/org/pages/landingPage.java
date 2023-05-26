package org.pages;
import org.baseclass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class landingPage extends baseClass {
    private WebDriver driver;

    private By lnkLoginby = By.cssSelector(".ico-login");

    @FindBy(css = "span.field-validation-error")
    private WebElement errMsg;

    private By errMsgBy = By.cssSelector("span.field-validation-error");

    public landingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lnkLoginby));
        PageFactory.initElements(this.driver,this);
    }

    public void clickLogin(){
        this.driver.findElement(lnkLoginby).click();
    }

    public String getInvalidAccountErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errMsgBy));
        return errMsg.getText();
    }
}
