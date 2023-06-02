package com.rzt.pages;

import com.rzt.extentReports.Logger;
import org.openqa.selenium.By;
import static com.rzt.utils.SeleniumUtil.*;

public class LoginPage {
    private static final By TXTBOX_USERNAME = By.xpath("//input[@name='username']");
    private static final By TXTBOX_PASSWORD = By.xpath("//input[@name='password']");
    private static final By BTN_LOGIN = By.xpath("//button[@type='submit']");

    private LoginPage setUserName(String userName) {
        sendKeysTo(TXTBOX_USERNAME, userName, "user name input field");
        Logger.pass("entered "+ userName);
        return this;
    }

    private LoginPage setPassword( String password) {
     sendKeysTo(TXTBOX_PASSWORD, password,"password input field");
        return this;     //method chaining
    }

    private HomePage clickLogin() {
     clickOn(BTN_LOGIN,"login button");
        return new HomePage();     //page chaining
    }

    public HomePage loginToApplication(String userName, String password) {
        return setUserName(userName).
                setPassword(password).
                clickLogin();
    }


}
