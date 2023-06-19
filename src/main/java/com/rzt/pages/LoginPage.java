package com.rzt.pages;

import org.openqa.selenium.By;

import static com.rzt.utils.SeleniumUtil.*;

public class LoginPage {
    private static final By TXTBOX_USERNAME = By.xpath("//input[@type='email']");
    private static final By TXTBOX_PASSWORD = By.xpath("//input[@id='Password']");
    private static final By BTN_LOGIN = By.xpath("//button[@type='submit']");

    private LoginPage setUserName(String userName) {
        sendKeysTo(TXTBOX_USERNAME, userName, "user name input field");
        return this;
    }

    private LoginPage setPassword(String password) {
        sendKeysTo(TXTBOX_PASSWORD, password, "password input field");
        return this;     //method chaining
    }

    private DashBoardPage clickLogin() {
        clickOn(BTN_LOGIN, "login button");
        return new DashBoardPage();     //page chaining
    }

    public DashBoardPage loginToApplication(String userName, String password) {
        return setUserName(userName).
                setPassword(password).
                clickLogin();
    }


}
