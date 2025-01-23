package com.google.android.calculator.setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * 2025, January 21, Tuesday, 1:27 PM
 */

public class Setup {
    public AndroidDriver androidDriver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/calculator.apk");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        androidDriver = new AndroidDriver(url, desiredCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterTest
    public void tearDown() {
        androidDriver.quit();
    }
}
