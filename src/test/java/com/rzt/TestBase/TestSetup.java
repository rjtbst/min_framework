package com.rzt.TestBase;

import com.rzt.drivers.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;


public class TestSetup {
    @BeforeMethod
    protected void setup(Method method) {
        Driver.initDriver();
    }

    @AfterMethod
    protected  void tearDown()
    {
        Driver.quitDriver();
    }

}
