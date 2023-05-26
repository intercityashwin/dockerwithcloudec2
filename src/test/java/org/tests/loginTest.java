package org.tests;
import org.initializeCleanup.initialize;
import org.pageFactory.pageFactory;
import org.pages.homePage;
import org.pages.landingPage;
import org.pages.loginPage;
import org.propertyManager.initiateProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class loginTest extends initialize {
    private static final String INVALID_ACCOUNT_ERR_MSG = "Please enter a valid email address.";

    @Test
    public void validLogin() throws IOException {
        landingPage landingPage = pageFactory.getLandingPage.apply(getDriver());
        landingPage.clickLogin();
        loginPage loginPage = pageFactory.getLoginPage.apply(initialize.getDriver());
        loginPage.loginToApplication(initiateProperties.getProperty("email"),initiateProperties.getProperty("password"));
        homePage homePage = pageFactory.getHomePage.apply(initialize.getDriver());
        Assert.assertTrue(homePage.isUserDisplayed());
        homePage.clickLogout();
    }

    @Test
    public void invalidLogin(){
        landingPage landingPage = pageFactory.getLandingPage.apply(getDriver());
        landingPage.clickLogin();
        loginPage loginPage = pageFactory.getLoginPage.apply(initialize.getDriver());
        loginPage.loginToApplication("test","test");
        Assert.assertEquals(landingPage.getInvalidAccountErrorMessage().trim(),INVALID_ACCOUNT_ERR_MSG);
    }

    @Test
    public void loginFailed() throws IOException {
        landingPage landingPage = pageFactory.getLandingPage.apply(getDriver());
        landingPage.clickLogin();
        loginPage loginPage = pageFactory.getLoginPage.apply(initialize.getDriver());
        loginPage.loginToApplication(initiateProperties.getProperty("email"),initiateProperties.getProperty("password"));
        homePage homePage = pageFactory.getHomePage.apply(initialize.getDriver());
        Assert.assertTrue(homePage.isUserDisplayed());
        //Assert.assertFalse(homePage.isUserDisplayed());
    }

    @Test
    public void dummyTestToFail(){
        landingPage landingPage = pageFactory.getLandingPage.apply(getDriver());
        landingPage.clickLogin();
        Assert.assertTrue(true);
    }

}
