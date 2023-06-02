package com.rzt.Drivers;

import com.rzt.owner.MyConfigFactory;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver() {
    }
    public static void initDriver() {
        if (DriverManager.getDriver() == null) {
            String browser = MyConfigFactory.getConfig().browser();
            System.out.println(browser);
            WebDriver driver = DriverFactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            //DriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            DriverManager.getDriver().get(MyConfigFactory.getConfig().url());
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(5000,TimeUnit.MILLISECONDS);
        }
    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }

    }
}
