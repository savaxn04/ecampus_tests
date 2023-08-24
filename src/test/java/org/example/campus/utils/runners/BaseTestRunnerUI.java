package org.example.campus.utils.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.example.campus.utils.Attachments;
import org.example.campus.utils.TestValueProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTestRunnerUI {

    protected WebDriver driver;
    protected Browsers browsers = new Browsers();
    protected SoftAssert softAssert;
    protected Attachments attachment = new Attachments();
    protected static final TestValueProvider valueProvider = new TestValueProvider();

    @BeforeMethod
    public void initSoftAssert() {
        softAssert = new SoftAssert();
    }

    @Parameters("browser")
    @BeforeClass(description = "Init Driver.")
    protected void initDriver(@Optional("chrome")String browser,ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = browsers.setUpBrowser(browser);
        context.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(valueProvider.getLoginPageUrl());
        /*checkPageFor404Error();*/
    }

    @AfterMethod
    public void afterTestMethod(ITestResult result,ITestContext context) {
        if (result.getStatus() == ITestResult.FAILURE) {
            attachment.captureScreenshot(driver);
        }
    }

    @Parameters("browser")
    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    /*private void checkPageFor404Error(){
        if(driver.getTitle().equals("404 Not Found")){
            Allure.addAttachment("404 Error", "404 Error");
            attachment.captureScreenshot(driver);
            driver.quit();
        }
    }*/
}
