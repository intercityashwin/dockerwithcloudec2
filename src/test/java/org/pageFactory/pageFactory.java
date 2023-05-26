package org.pageFactory;
import org.openqa.selenium.WebDriver;
import org.pages.computer.computerPage;
import org.pages.homePage;
import org.pages.landingPage;
import org.pages.loginPage;
import java.util.function.Function;

public class pageFactory {

    public static Function<WebDriver,landingPage> getLandingPage = (driver)->new landingPage(driver);
    public static Function<WebDriver,loginPage> getLoginPage = (driver)->new loginPage(driver);
    public static Function<WebDriver,homePage> getHomePage = (driver)->new homePage(driver);
    public static Function<WebDriver,computerPage> getComputerPage = (driver) -> new computerPage(driver);

}
