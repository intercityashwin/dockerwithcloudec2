package org.pages;
import org.baseclass.baseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.propertyManager.initiateProperties;

public class loginPage extends baseClass {

    private WebDriver driver;

    @FindBy(id = "Email")
    private WebElement txtEmail;

    @FindBy(id = "Password")
    private WebElement txtPassword;

    @FindBy(css = ".button-1.login-button")
    private WebElement btnLogin;

    public loginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void loginToApplication(String userEmail, String password){
        try{
            txtEmail.sendKeys(userEmail);
            txtPassword.sendKeys(password);
            btnLogin.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
