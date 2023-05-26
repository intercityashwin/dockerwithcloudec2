package org.tests;
import org.initializeCleanup.initialize;
import org.pageFactory.pageFactory;
import org.pages.computer.computerPage;
import org.pages.homePage;
import org.pages.landingPage;
import org.pages.loginPage;
import org.propertyManager.initiateProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class cartTest extends initialize {

    @Test
    public void addComputerToCart() throws IOException {
        landingPage landingPage = pageFactory.getLandingPage.apply(getDriver());
        landingPage.clickLogin();
        loginPage loginPage = pageFactory.getLoginPage.apply(getDriver());
        loginPage.loginToApplication(initiateProperties.getProperty("email"),initiateProperties.getProperty("password"));
        homePage homePage = pageFactory.getHomePage.apply(getDriver());
        Assert.assertTrue(homePage.isUserDisplayed());
        computerPage computerPage = pageFactory.getComputerPage.apply(initialize.getDriver());
        computerPage.selectComputer("Computers");
        computerPage.selectComputer("Desktops");
        homePage.clickLogout();
    }
}
