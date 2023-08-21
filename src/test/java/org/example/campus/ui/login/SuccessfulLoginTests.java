package org.example.campus.ui.login;

import org.example.campus.utils.runners.BaseTestRunnerUI;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfulLoginTests extends BaseTestRunnerUI {

    @Test
    public void testLoginWithCorrectData() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.fillInNicknameField(valueProvider.getCorrectLogin())
                                    .fillInPasswordField(valueProvider.getCorrectPassword())
                                    .clickSubmitButton();
        String campusHomeUrl = "https://ecampus.kpi.ua/home";
        homePage.waitForRedirection(campusHomeUrl);
        Assert.assertEquals(homePage.getCurrentUrl(), campusHomeUrl);
    }
}
