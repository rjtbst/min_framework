package com.rzt;

import com.rzt.TestBase.BaseTest;
import com.rzt.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "To check login functionality with valid credentials")
    public void verifyHomePageTitle(){
        LoginPage loginPage = new LoginPage();
        String actualTitle = loginPage
                .loginToApplication("Admin","admin123")
                .getHomePageTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM");
    }

//    @Test
//    public void verifyAdminPage(){
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginToApplication("","")
//                .clickSidebarAdmin();
//    }


}
