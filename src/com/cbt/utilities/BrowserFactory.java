package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Dependencies\\Drivers\\chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Dependencies\\Drivers\\geckodriver.exe");
                return new FirefoxDriver();
            case "edge":
//                if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
//                    System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium Dependencies\\Drivers\\MicrosoftWebDriver.exe"); return new EdgeDriver();
//                } else return null;
                if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
                    System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium Dependencies\\Drivers\\MicrosoftWebDriver.exe"); return new EdgeDriver();
                } else return null;
//            case "safari":
//                if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
//                    System.setProperty("webdriver.safari.driver", "C:\\Program Files\\Selenium Dependencies\\Drivers\\chromedriver.exe");
//                } else return null;
            default: return null;
        }
    }
}
