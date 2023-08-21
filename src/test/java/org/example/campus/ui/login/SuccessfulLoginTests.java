package org.example.campus.ui.login;

import org.example.campus.utils.runners.BaseTestRunnerUI;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLoginTests extends BaseTestRunnerUI {

    @Test
    public void testLoginWithCorrectData() {
        LoginPage loginPage = new LoginPage(driver);
        boolean loginSuccess = loginPage.fillInNicknameField(valueProvider.getCorrectLogin())
                                    .fillInPasswordField(valueProvider.getCorrectPassword())
                                    .clickSubmitButton()
                                    .loginSuccess();

        Assert.assertTrue(loginSuccess);
    }
}
