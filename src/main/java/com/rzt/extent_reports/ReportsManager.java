package com.rzt.extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rzt.constants.FrameworkConstants;

public class ReportsManager {
    protected ReportsManager(){}
    private static ExtentReports extentReports;// reports are not thread safe so made a thread local

    protected static void initReport(){
         extentReports = new ExtentReports();
        ExtentSparkReporter exSpark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        extentReports.attachReporter(exSpark);
    }
    protected static void createTestReport(String testName){
        ExtentTest extentTest = extentReports.createTest(testName);
        ExtentReport.setExtentTest(extentTest);
    }
    protected static void flushReport(){
        extentReports.flush();
    }


}
