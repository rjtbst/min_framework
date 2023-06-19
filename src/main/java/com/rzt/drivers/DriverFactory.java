package com.rzt.drivers;
import com.rzt.extent_reports.Logger;
import com.rzt.owner.MyConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URI;


class DriverFactory {
    private DriverFactory(){}
    private static WebDriver driver;


    static WebDriver getDriver(String browser) {
        String runner = MyConfigFactory.getConfig().runner();
        if (runner.equalsIgnoreCase("local")){
            if (browser.equalsIgnoreCase("chrome")) {
              driver =  initChromeDriver();
            }else{
              driver =  initFirefoxDriver();
            }
        }
        if (runner.equalsIgnoreCase("remote")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            try {
            driver = new RemoteWebDriver(new URI(" http://localhost:4444").toURL(), capabilities);
            }catch (Exception e){
                Logger.info("error in launching in remote");
                e.printStackTrace();
            }
        }
    return driver;
}
    private static WebDriver initChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        if (MyConfigFactory.getConfig().runHeadlessMode()){
            chromeOptions.addArguments("--headless");
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }
    private static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return  driver;
    }
}
