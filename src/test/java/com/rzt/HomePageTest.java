package com.rzt;

import com.rzt.Drivers.DriverManager;
import com.rzt.TestBase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(description = "verify login with valid credentials")
    public void verifyTitle() {

        DriverManager.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        DriverManager.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        click(By.xpath("//button[@type='submit']"));
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");
    }

    public void click(By by) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(by));
        el.click();
    }

}
