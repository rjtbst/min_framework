package com.rzt.pages;

import com.rzt.utils.SeleniumUtil;
import org.openqa.selenium.By;

public class CustomersPage {

    private static final By BTN_ADD_NEW = By.xpath("//div[@class='content-header clearfix']//a");

    public AddNewCustomerPage clickAddNewButton() {
        SeleniumUtil.clickOn(BTN_ADD_NEW, "add new button");
        return new AddNewCustomerPage();
    }

}
