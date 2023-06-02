package com.rzt.extentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rzt.constants.FrameworkConstants;

public class ExtentReports {
    private static com.aventstack.extentreports.ExtentReports extentReports;
    public static ExtentTest extentTest ;    // reports are not thread safe so made a thread local

    public static void initReport(){
        extentReports = new com.aventstack.extentreports.ExtentReports();
        ExtentSparkReporter exSpark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        extentReports.attachReporter(exSpark);
    }

    public static void flushReport(){
        extentReports.flush();
    }

   public static void createTestReport(String testName){
    extentTest = extentReports.createTest(testName);
    ReportManager.setExtentTest(extentTest);
    }
}
