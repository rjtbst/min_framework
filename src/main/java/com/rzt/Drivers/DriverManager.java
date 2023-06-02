package com.rzt.Drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadDriver.set(driver);
    }
}
