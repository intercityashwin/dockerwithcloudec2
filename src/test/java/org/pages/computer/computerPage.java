package org.pages.computer;
import org.baseclass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class computerPage extends baseClass {
    private WebDriver driver;

    public computerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void selectComputer(String computerType){
        String lnkCompType = "//ul[@class='list']//a[normalize-space(text())='"+computerType+"']";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(lnkCompType)));
        this.driver.findElement(By.xpath(lnkCompType)).click();
    }

}
