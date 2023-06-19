package com.rzt.pages;

import com.rzt.drivers.DriverManager;
import com.rzt.utils.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddNewCustomerPage {

    private static final By SELECT_VENDOR = By.xpath("//label[text()='Manager of vendor']/../../following-sibling::div//select[@id='VendorId']");

    public String getAddNewCustomerPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public void fillDetails() {
        enterField("Email", "abc@xyz.com")
                .enterField("Password", "Password")
                .enterField("First name", "abc")
                .enterField("Last name", "xyz")
                .selectGender("Male")
                .enterField("Date of birth", "6/2/2023")
                .enterField("Company name", "c company")
                .enterField("Is tax exempt", true)
                .enterField("Newsletter", "not posting any news letter for now")
                .setSelectVendor(1);
    }

    private AddNewCustomerPage enterField(String txtFieldName, String txtValue) {
        By inputBy = By.xpath("//label[text()='" + txtFieldName + "']/../../following-sibling::div//input");
        SeleniumUtil.sendKeysTo(inputBy, txtValue, txtFieldName);
        return this;
    }

    private AddNewCustomerPage enterField(String txtFieldName, boolean isIt) {
        By inputBy = By.xpath("//label[text()='" + txtFieldName + "']/../../following-sibling::div//input");
        if (isIt) {
            SeleniumUtil.clickOn(inputBy, txtFieldName);
        }
        return this;
    }

    public AddNewCustomerPage selectGender(String gender) {
        By genderBy = By.xpath("//label[contains(text(),'" + gender + "')]/preceding-sibling::input");
        SeleniumUtil.clickOn(genderBy, gender);
        return this;
    }

    public void setSelectVendor(int index) {
        WebElement el = SeleniumUtil.waitTillPresence(SELECT_VENDOR);
        SeleniumUtil.selectDropdown(el, index);
    }
}
