package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class ScrollTest {
    static WebDriver driver;
    WebDriverWait wait;
    ExtentReports ex;
    ExtentSparkReporter exSpark;
    ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        ex = new ExtentReports();
        exSpark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
        ex.attachReporter(exSpark);
    }

    @AfterSuite
    public void afterSuite() {
        ex.flush();
    }

    @BeforeMethod
    public void setup(Method method) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.get("https://www.testingbaba.com/newdemo.html");
    }

    @Test
    public void title(){
       
    }

//    @Test
//    public void scrollTest(){
//        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
//       WebElement aboutUs_btn=  driver.findElement(By.xpath("//a[text()='About Us']"));
//        jsExecuter.executeScript("arguments[0].scrollIntoView(true);",aboutUs_btn);
//        test.log(Status.INFO,"scrolled to about us link");
//        jsExecuter.executeScript("arguments[0].click();",aboutUs_btn);      //variable args
//
//        takeItsScreenshot();
//        test.pass("screenshot taken");
//    }

    public static void takeItsScreenshot() {
        try {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir" )+ "/screenshot.png");
        FileUtils.copyFile(src,target);
        }catch (Exception  e){
            System.out.println("exception occured while taking screenshot: " + e);
        }
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
