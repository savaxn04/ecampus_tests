package org.example.campus.utils.runners;

import org.example.pages.LoginPage;
import org.testng.annotations.BeforeClass;

public class LoginAsStudentRunner extends BaseTestRunnerUI {

    /**
     * This method is a precondition for tests for which we need to be registered as "User"
     */
    @BeforeClass(description = "Precondition method : login into Student account")
    public void loginPrecondition() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInNicknameField(valueProvider.getCorrectLogin())
                .fillInPasswordField(valueProvider.getCorrectPassword())
                .clickSubmitButton()
                .loginSuccess();
    }
}
