package com.rzt.constants;

public final class FrameworkConstants {
    private FrameworkConstants(){}

    private static final String REPORT_PATH = System.getProperty("user.dir") + "/test reports/index.html";


public static String getReportPath(){
    //create timestamp and append in report path so that every test case will have unique reports
String newTimeStamp = "";
   // REPORT_PATH.replaceAll("timestamp",newTimeStamp);
    return REPORT_PATH;
}

}
