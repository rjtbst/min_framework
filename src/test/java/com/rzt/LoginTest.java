package com.rzt;

import com.rzt.TestBase.TestSetup;
import com.rzt.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestSetup {
//    @Test(description = "To check login functionality with valid credentials")
//    public void verifyDashboardPageTitle(){
//      String actualTitle =  new LoginPage()
//                .loginToApplication("admin@yourstore.com","admin")
//                        .getHomePageTitle();
//       Assert.assertEquals(actualTitle, "Dashboard / nopCommerce administration");
//    }

@Test()
    public void createNewCustomer(){
 new LoginPage()
               .loginToApplication("admin@yourstore.com","admin")
               .navigateToCreateNewCustomerPage()
              .addNewCustomerDetails();

//    Assert.assertEquals(actualTitle, "Add a new customer / nopCommerce administration");
    }


}
