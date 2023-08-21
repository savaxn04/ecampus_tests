package org.example.pages;

import org.example.base.Base;
import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how =  How.XPATH, using = "//input[@type='text']")
    private WebElement nicknameField;

    @FindBy(how =  How.XPATH, using = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(how =  How.XPATH, using = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(how =  How.XPATH, using = "//a[@href='/restore-password']")
    private WebElement passwordRecoveryButton;

    @FindBy(how =  How.XPATH, using = "//div[@class='alert alert-danger']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillInNicknameField(String symbols) {
        nicknameField.clear();
        nicknameField.sendKeys(symbols);
        return this;
    }

    public LoginPage fillInPasswordField(String symbols) {
        passwordField.clear();
        passwordField.sendKeys(symbols);
        return this;
    }

    public HomePage clickSubmitButton() {
        submitButton.click();
        return new HomePage(driver);
    }

    public PasswordRecoveryPage clickPasswordRecoveryButton() {
        passwordRecoveryButton.click();
        return new PasswordRecoveryPage(driver);
    }

    public String getErrorMessage() {
        return errorMessage.getText().replace("×", "").trim();
    }
}
