package com.rzt.utils;


import com.rzt.Drivers.DriverManager;
import com.rzt.enums.ElementType;
import com.rzt.owner.MyConfigFactory;
import com.rzt.extentReports.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumUtil {

    public static void clickOn(By by, String elementName) {
        WebElement element = waitTillClickable(by);
        element.click();
        Logger.pass(elementName+" is clicked successfully");
    }

    public static void sendKeysTo(By by, String value, String elementName) {
        waitTillPresence(by).sendKeys(value);
        Logger.pass(value+ " is entered successfully in "+ elementName);
    }

    private static WebElement waitTillPresence(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), MyConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

//    public static List<WebElement> getElements(By by, ElementType elementType) {
//        List<WebElement> list = null;
//        if (elementType == ElementType.list) {
//            waitTillPresence(by).findElements(by);
//        }return list;
//    }

    private static WebElement waitTillClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), MyConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }


}
