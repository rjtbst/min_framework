package com.rzt.extent_reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.rzt.owner.MyConfigFactory;
import com.rzt.utils.ScreenshotUtil;

public class Logger {
    private Logger(){}

    public static void pass(String msg){
       if (MyConfigFactory.getConfig().takeScreenshotForPassed()) {
           ExtentReport.getExtentTest().fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getScreenshot()).build());
       } else {
           ExtentReport.getExtentTest().pass(msg);
       }
    }

    public static void fail(String msg){
        ExtentReport.getExtentTest().fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getScreenshot()).build());

    }
  public static void skip(String msg){
        ExtentReport.getExtentTest().skip(msg);
  }
    public static void info(String msg){
        ExtentReport.getExtentTest().info(msg);
    }
}
