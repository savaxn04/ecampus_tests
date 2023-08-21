package org.example.campus.ui.recoveryPassword;

import org.example.campus.utils.runners.BaseTestRunnerUI;
import org.example.pages.LoginPage;
import org.example.pages.PasswordRecoveryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTestRunnerUI {

    private PasswordRecoveryPage passwordRecoveryPage;

    @BeforeMethod
    void navigateToPasswordRecoveryPage(){
        driver.navigate().refresh();
        passwordRecoveryPage = new LoginPage(driver)
                .clickPasswordRecoveryButton();
    }

    @Test(dependsOnMethods={"org.example.campus.ui.login.ButtonsTest.testRedirectingToRecoveryPasswordPageAfterClickingTheButton"})
    public void checkSubmitButtonIsDisabledWithoutEnteringData(){
        Assert.assertFalse(passwordRecoveryPage.checkSubmitButtonIsEnabled());
    }

    @Test(dependsOnMethods={"org.example.campus.ui.login.ButtonsTest.testRedirectingToRecoveryPasswordPageAfterClickingTheButton"})
    public void checkSubmitButtonIsEnabledAfterEnteringData(){
        passwordRecoveryPage.fillInNicknameField(valueProvider.getCorrectLogin());
        Assert.assertTrue(passwordRecoveryPage.checkSubmitButtonIsEnabled());
    }
}
