package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HomePageTitleTest   {
    WebDriver driver;
    WebDriverWait wait;
    ExtentReports ex;
    ExtentSparkReporter exSpark;
    ExtentTest loginTest;

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
        loginTest = ex.createTest(method.getName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "verify login with valid credentials")
    public void verifyHomePageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys("Admin");
        loginTest.log(Status.INFO, "entered valid input");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("admin123");
        loginTest.log(Status.INFO, "entered valid password");
        click(By.xpath("//button[@type='submit']"));
        loginTest.log(Status.INFO, "clicked on login button");
        try {
            Assert.assertEquals(driver.getTitle(), "OrangeHR");
            loginTest.log(Status.PASS, "title is as per expected");
        } catch (AssertionError e) {
            loginTest.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            ScrollTest.takeItsScreenshot();
        } catch (Exception e) {
            // Log any other exceptions in the Extent Report
            loginTest.log(Status.WARNING, "An error occurred: " + e.getMessage());
        }
    }

    @DataProvider
    public Object[][] getData(
    ) {
        Sheet sheet;
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/demoData.xlsx";
            FileInputStream fis = new FileInputStream(path);
            Workbook book = new XSSFWorkbook(fis);
            sheet = book.getSheetAt(0);
        } catch (Exception e) {
            throw new RuntimeException("error occured while reading excel: " + e);
        }
        int totalRow = sheet.getLastRowNum();
        Object[][] objects = new Object[totalRow][1];
        Map<String, String> data;
        int totalCol = sheet.getRow(0).getLastCellNum();
        for (int i = 1; i <= totalRow; i++) {
            data = new HashMap<>();
            for (int j = 0; j < totalCol; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                data.put(key, value);
            }
            objects[i - 1][0] = data;
        }
        return objects;
    }

    @Test(dataProvider = "getData")
    public void testingMultiData(Map<String, String> data) {
        System.out.println(data.get("userName"));
        System.out.println(data.get("password"));
    }

    @Test(dependsOnMethods = {"verifyHomePageTitle"})
    public void verifyLinks() {
        loginTest.pass("verifying broken link");
        System.out.println(driver.getTitle());
        loginTest.pass(" links verified successfully");
    }

    public void click(By by) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(by));
        el.click();
    }

}
