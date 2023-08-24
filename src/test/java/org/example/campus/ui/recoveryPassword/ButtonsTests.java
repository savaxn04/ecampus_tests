package org.example.campus.ui.recoveryPassword;

import org.example.campus.utils.runners.BaseTestRunnerUI;
import org.example.pages.LoginPage;
import org.example.pages.PasswordRecoveryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTestRunnerUI {

    private PasswordRecoveryPage passwordRecoveryPage;

    @BeforeClass
    void navigateToPasswordRecoveryPage() {
        passwordRecoveryPage = new LoginPage(driver)
                .clickPasswordRecoveryButton();
    }

    @Test(priority = 1)
    public void checkSubmitButtonIsDisabledWithoutEnteringData() {
        Assert.assertFalse(passwordRecoveryPage.checkSubmitButtonIsEnabled());
    }

    @Test(priority = 2)
    public void checkSubmitButtonIsEnabledAfterEnteringData() {
        passwordRecoveryPage.fillInNicknameField(valueProvider.getCorrectLogin());
        Assert.assertTrue(passwordRecoveryPage.checkSubmitButtonIsEnabled());
    }
}
