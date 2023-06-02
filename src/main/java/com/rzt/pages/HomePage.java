package com.rzt.pages;

import com.rzt.Drivers.DriverManager;
import com.rzt.pages.pageComponents.SideBarComponent;


public class HomePage {
    private final SideBarComponent sideBarComponent;
    public HomePage() {
        sideBarComponent = new SideBarComponent();
    }

    public String getHomePageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    // find the menu in sidebar and click with wait type
    public void clickSidebarAdmin() {
        sideBarComponent.clickSideBarMenu("Admin");

    }


}
