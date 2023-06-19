package com.rzt.listeners;

import com.rzt.extent_reports.ReportsManager;
import com.rzt.extent_reports.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends ReportsManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ReportsManager.createTestReport(result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.pass(result.getName() + " is Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        Logger.fail(result.getName() + " is Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.skip(result.getName() + " is skipped");
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ReportsManager.initReport();
    }
    @Override
    public void onFinish(ITestContext context) {
        ReportsManager.flushReport();
    }

}
