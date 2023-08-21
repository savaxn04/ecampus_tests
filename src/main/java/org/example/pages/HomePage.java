package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//p/button[@class='btn btn-primary btn-lg']")
    private WebElement toCurrentVersionButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean clickToCurrentVersionButton(){
        waitForElementToBeClickable(toCurrentVersionButton);
        toCurrentVersionButton.click();
        return driver.getCurrentUrl().contains("https://campus.kpi.ua/student/index.php?session=");
    }
}
