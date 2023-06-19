package com.rzt.pages;

import com.rzt.drivers.DriverManager;
import com.rzt.pages.facade.CustomerFacade;
import com.rzt.pages.page_components.SideBarComponent;


public class DashBoardPage {
    private final SideBarComponent sideBarComponent;

    public DashBoardPage() {
        sideBarComponent = new SideBarComponent();
    }

    public String getDashboardPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public CustomerFacade navigateToCreateNewCustomerPage() {
        return sideBarComponent
                .clickSideBarMenu("Customers")
                .clickSubMenu("Customers", CustomerFacade.class);
    }


}
