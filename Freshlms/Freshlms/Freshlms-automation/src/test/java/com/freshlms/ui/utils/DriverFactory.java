package com.freshlms.ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.thoughtworks.xstream.InitializationException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverFactory extends staticData {
    static String Scenario_Name;
    public static WebDriver createAndGetDeviceDriver(String browserName) throws MalformedURLException {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
           driver = chooseDriver(browserName,options);
            driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                    TimeUnit.SECONDS);
            //driver.manage().window().maximize();

        } catch (Exception e) {

        }
        return driver;

    }

    private static WebDriver chooseDriver(String browser,ChromeOptions options) {
        String preferredDriver = System.getProperty("browser", browser);
        boolean headless = System.getProperty("Headless", "true").equals("false");

        switch (preferredDriver.toLowerCase()) {
            case "chrome":
                final ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                if (driver != null) {
                    return driver;
                }
                System.setProperty(
                        "webdriver.chrome.driver",
                        driver_path);
                System.out.println("********************* before driver created");
                driver = new ChromeDriver();
                System.out.println("********************* after driver created");
        }
        return driver;
    }



    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit();
            }
            catch (NoSuchMethodError nsme) {

            }
            catch (NoSuchSessionException nsse) {

            }
            catch (SessionNotCreatedException snce) {

            }
            driver = null;
        }
    }

}
