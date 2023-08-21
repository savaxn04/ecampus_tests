package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class BasePage extends Base {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
