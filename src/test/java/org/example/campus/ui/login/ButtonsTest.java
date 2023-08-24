package org.example.campus.ui.login;

import org.example.campus.utils.runners.BaseTestRunnerUI;
import org.example.pages.LoginPage;
import org.example.pages.PasswordRecoveryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTestRunnerUI {

    @Test
    public void testRedirectingToRecoveryPasswordPageAfterClickingTheButton() {
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = loginPage.clickPasswordRecoveryButton();
        String campusHomeUrl = "https://ecampus.kpi.ua/restore-password";
        passwordRecoveryPage.waitForRedirection(campusHomeUrl);
        Assert.assertEquals(passwordRecoveryPage.getCurrentUrl(),campusHomeUrl);
    }
}
