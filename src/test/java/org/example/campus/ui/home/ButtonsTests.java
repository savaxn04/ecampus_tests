package org.example.campus.ui.home;

import org.example.campus.utils.runners.LoginWithStudentRunner;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends LoginWithStudentRunner {

    @BeforeMethod
    void refreshPage(){
        driver.navigate().refresh();
    }

    @Test
    public void testRedirectionToCurrentSiteVersionByClickingButton(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.clickToCurrentVersionButton());
    }
}
