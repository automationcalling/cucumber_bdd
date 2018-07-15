package com.automationcalling.commonutil;

import org.openqa.selenium.WebDriver;

public class SeleniumCommon {

    private WebDriver driver;

    public void initalizeDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void launchURL() {
        driver.get("http://google.com");
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}
