package com.rzt.extentReports;

import com.aventstack.extentreports.ExtentTest;

public final class ReportManager {
  private ReportManager(){}

   private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
     static ExtentTest getExtentTest() {
        return threadLocal.get();
    }
     static void setExtentTest(ExtentTest testReport) {
        threadLocal.set(testReport);
    }
}
