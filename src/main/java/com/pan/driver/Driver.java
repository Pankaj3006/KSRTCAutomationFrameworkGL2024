package com.pan.driver;

import com.pan.enums.PropertyType;
import com.pan.utilities.PropertyReaderUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    public static void initDriver() {

        String browser = PropertyReaderUtils.getProperty(PropertyType.BROWSER);

        if(Objects.isNull(driver)) {
            selectBrowser(browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void quitDriver() {
        if(Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }

    private static void selectBrowser(String browser) {

        switch(browser) {

            case "firefox":
               driver = new FirefoxDriver();
//                DesiredCapabilities capabilities = new DesiredCapabilities();
//                capabilities.setCapability("browserName", "firefox");
//                try {
//                    driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "chrome":
            default:
                driver = new ChromeDriver();
//                DesiredCapabilities cap = new DesiredCapabilities();
//                cap.setCapability("browserName", "chrome");
//                try {
//                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
                break;
        }
    }
}
