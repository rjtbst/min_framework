package com.rzt.extentReports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.rzt.owner.MyConfigFactory;
import com.rzt.utils.ScreenshotUtil;

public class Logger {
    private Logger(){}

    public static void pass(String msg){
       if (MyConfigFactory.getConfig().takeScreenshotForPassed()) {
           ReportManager.getExtentTest().fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getScreenshot()).build());
       } else {
           ReportManager.getExtentTest().pass(msg);
       }
    }

    public static void fail(String msg){
        ReportManager.getExtentTest().fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getScreenshot()).build());

    }

    public static void info(String msg){
        ReportManager.getExtentTest().info(msg);
    }
}
