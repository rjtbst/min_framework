package com.rzt.owner;

import org.aeonbits.owner.Config;

@Config.Sources(value = {
        "file:${user.dir}/src/main/resources/locatorConfig.properties",
})
public interface LocatorConfig extends Config {
String[] sidebarMenus();

}
