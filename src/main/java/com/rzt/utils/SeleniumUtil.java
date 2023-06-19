package com.rzt.utils;

import com.rzt.drivers.DriverManager;
import com.rzt.owner.MyConfigFactory;
import com.rzt.extent_reports.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
    private SeleniumUtil(){}

    public static void clickOn(By by, String elementName) {
       waitTillClickable(by).click();
        Logger.info(elementName+" is clicked successfully");
    }

    public static void sendKeysTo(By by, String value, String elementName) {
      WebElement el =  waitTillPresence(by);
      el.clear();
      el.sendKeys(value);
        Logger.info(value+ " is entered successfully in "+ elementName);
    }

    public static WebElement waitTillPresence(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), MyConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static WebElement waitTillClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), MyConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void dragAndDrop(WebElement desiredElement, WebElement targetElement){
        Actions builder = new Actions(DriverManager.getDriver());
        builder.clickAndHold(desiredElement);
        builder.moveToElement(targetElement);
        builder.release(targetElement);
        Action build = builder.build();
        build.perform();
    }

    public static void selectDropdown(WebElement el,int value){
        Select select = new Select(el);
        select.selectByIndex(value);
    }
}
