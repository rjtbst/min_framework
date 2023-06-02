package com.rzt.owner;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/configuration/frameworkConfig.properties")
public interface FrameworkConfig extends Config {

    String url();
    String browser();

    int timeout();

    boolean takeScreenshotForPassed();

}
