package com.rzt.constants;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    public static final String ROOT_PATH = System.getProperty("user.dir");
    private static final String REPORT_PATH = ROOT_PATH + "/test reports/index.html";
    // english language dynamic locators property file path
    private static final String ENGLISH_PATH = ROOT_PATH + "/src/main/resource/locators/EngLocator.properties";
    private static final String FRENCH_PATH = ROOT_PATH + "/src/main/resource/locators/FrenchLocator.properties";

    //TODO: make random path for each test. keep different folders depend on group name
    public static String getReportPath() {
        //create timestamp and append in report path so that every test case will have unique reports
        return REPORT_PATH;
    }

    public static String getLangPath(String lang) {
        if (lang.equalsIgnoreCase("french")) {
            return FRENCH_PATH;
        } else {
            return ENGLISH_PATH;
        }
    }


}
