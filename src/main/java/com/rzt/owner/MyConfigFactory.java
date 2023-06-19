package com.rzt.owner;

import org.aeonbits.owner.ConfigFactory;

public class MyConfigFactory {

    private MyConfigFactory() {
    }

    public static FrameworkConfig getConfig() {
        return ConfigFactory.create(FrameworkConfig.class);
    }

    public static LocatorConfig getLocatorConfig() {
        return ConfigFactory.create(LocatorConfig.class);
    }


}
