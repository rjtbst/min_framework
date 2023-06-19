package com.rzt.extent_reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReport {
  private ExtentReport(){}
   private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
     static ExtentTest getExtentTest() {
        return threadLocal.get();
    }
     static void setExtentTest(ExtentTest testReport) {
        threadLocal.set(testReport);
    }
    static void removeExtentThread(){
         threadLocal.remove();
    }
}
