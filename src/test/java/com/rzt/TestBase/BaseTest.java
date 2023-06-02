package com.rzt.TestBase;

import com.rzt.Drivers.Driver;

import com.rzt.extentReports.ExtentReports;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {
   protected WebDriverWait wait;
    @BeforeSuite
    protected void beforeSuite() {
     ExtentReports.initReport();
    }

    @AfterSuite
    protected void afterSuite() {
    ExtentReports.flushReport();
    }

    @BeforeMethod
    protected void setup(Method method) {
     ExtentReports.createTestReport(method.getName());
        Driver.initDriver();
    }

    @AfterMethod
    protected  void tearDown()
    {
        Driver.quitDriver();
    }

}
