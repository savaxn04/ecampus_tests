package org.example.campus.ui.login;

import org.example.campus.utils.runners.BaseTestRunnerUI;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UnsuccessfulLoginTests extends BaseTestRunnerUI {

    @BeforeMethod
    private void refreshPage(){
        driver.navigate().refresh();
    }

    @Test(priority = 1)
    public void testLoginWithoutData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Перевірте корректність логіну та паролю.");
    }

    @Test(priority = 2)
    public void testLoginWithIncorrectData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInNicknameField(valueProvider.getInCorrectLogin())
                .fillInPasswordField(valueProvider.getIncorrectPassword())
                .clickSubmitButton();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Перевірте корректність логіну та паролю.");
    }
}
