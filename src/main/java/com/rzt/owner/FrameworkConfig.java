package com.rzt.owner;

import org.aeonbits.owner.Config;

@Config.Sources(value = {
        "file:${user.dir}/src/test/resources/configuration/frameworkConfig.properties",

})
public interface FrameworkConfig extends Config {
    String url();
    String browser();
    boolean runHeadlessMode();
    int timeout();
    boolean takeScreenshotForPassed();
    String runner();
}
