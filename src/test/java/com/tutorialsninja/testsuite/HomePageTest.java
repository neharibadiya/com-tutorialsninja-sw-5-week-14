package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooks;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktops;
    LaptopsAndNotebooks laptopsAndNotebooks;

    ///Homepage
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktops = new DesktopsPage();
        laptopsAndNotebooks = new LaptopsAndNotebooks();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnDesktopLink();
        homePage.selectMenu("Show All Desktops");
        // String expectedMessage = "Desktops";
        Assert.assertEquals(homePage.getVerifyText(), "Desktops", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.clickOnLaptopNotebooksLink();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedMessage = "Laptops & Notebooks";
        Assert.assertEquals(homePage.getVerifyText1(), expectedMessage, "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.clickOnComponentsLink();
        homePage.selectMenu("Show All Components");
        String expectedMessage = "Components";
        Assert.assertEquals(homePage.getVerifyText2(), expectedMessage, "Error Message not displayed");

    }
}
