package org.example.campus.ui.recoveryPassword;

import org.example.campus.utils.runners.BaseTestRunnerUI;
import org.example.pages.LoginPage;
import org.example.pages.PasswordRecoveryPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTestRunnerUI {

    private PasswordRecoveryPage passwordRecoveryPage;

    @Test
    void navigateToPasswordRecoveryPage(){
        attachment.captureScreenshot(driver);
        String title = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(title, " Ми скоро повернемося!".trim());
        /*passwordRecoveryPage = new LoginPage(driver)
                .clickPasswordRecoveryButton();
    }

    @Test(priority = 1)
    public void checkSubmitButtonIsDisabledWithoutEnteringData(){
        Assert.assertFalse(passwordRecoveryPage.checkSubmitButtonIsEnabled());
    }

    @Test(priority = 2)
    public void checkSubmitButtonIsEnabledAfterEnteringData(){
        passwordRecoveryPage.fillInNicknameField(valueProvider.getCorrectLogin());
        Assert.assertTrue(passwordRecoveryPage.checkSubmitButtonIsEnabled());*/
    }
}
