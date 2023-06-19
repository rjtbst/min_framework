package com.rzt.pages.facade;

import com.rzt.pages.CustomersPage;

public class CustomerFacade {
    CustomersPage customerspage;
    public CustomerFacade(){
         customerspage = new CustomersPage();
    }

    public void addNewCustomerDetails(){
    customerspage.clickAddNewButton()
             .fillDetails();
    }

}
