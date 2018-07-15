package com.automationcalling.driverfactory;

import com.automationcalling.commonutil.SeleniumCommon;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitalization extends SeleniumCommon {

    protected WebDriver driver;

    public WebDriver getDriver() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    protected synchronized void destroyDriver() {
        try {
            driver.quit();
            driver = null;
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

}
