package com.rzt.drivers;

import com.rzt.owner.MyConfigFactory;
import org.openqa.selenium.WebDriver;

public class Driver {
    private Driver() {
    }
    public static void initDriver() {
        if (DriverManager.getDriver() == null) {
            String browser = MyConfigFactory.getConfig().browser();
            WebDriver driver = DriverFactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().get(MyConfigFactory.getConfig().url());
        }
    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }

}
