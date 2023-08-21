package org.example.campus.utils.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.campus.utils.TestValueProvider;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTestRunnerUI {

    protected WebDriver driver;
    protected Browsers browsers = new Browsers();

    protected static final TestValueProvider valueProvider = new TestValueProvider();

    @Parameters("browser")
    @BeforeClass(description = "Init Driver.")
    protected void initDriver(@Optional("chrome")String browser,ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = browsers.setUpBrowser(browser);
        context.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(valueProvider.getLoginPageUrl());
    }

    @Parameters("browser")
    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
