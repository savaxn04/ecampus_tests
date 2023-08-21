package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement loginField;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    private WebElement returnButton;

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    public void fillInNicknameField(String symbols) {
        loginField.clear();
        loginField.sendKeys(symbols);
    }

    public PasswordRecoveryPage clickSubmitButton() {
        submitButton.click();
        return new PasswordRecoveryPage(driver);
    }

    public boolean checkSubmitButtonIsEnabled() {
        return submitButton.isEnabled();
    }

    public LoginPage clickReturnButton() {
        returnButton.click();
        return new LoginPage(driver);
    }

    public String getTextFromAlert(){
        return driver.switchTo().alert().getText();
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }
}
