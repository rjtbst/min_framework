package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


public class DockerDemoTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException, URISyntaxException {
        // WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // String browser = System.getProperty("browser");
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URI(" http://localhost:4444").toURL(), capabilities);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test
    public void verifyHomePageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("admin123");
        click(By.xpath("//button[@type='submit']"));
        System.out.println(driver.getTitle());
    }

    public void click(By by) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        el.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
