package framework.driver;

import framework.utilities.config_util.ConfigManager;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class DriverManager {
    private static WebDriver webDriver;
    private static String implicitWaitTime;

    public static void getInstance(String browserName) {
        implicitWaitTime = ConfigManager.getConfProperty("implicitWaitTime");
        webDriver = DriverInitializer.createInstance(browserName);
        setTimeout();
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }

    private static void setTimeout() {
        webDriver.manage().timeouts().implicitlyWait(Long.parseLong(implicitWaitTime),
                TimeUnit.SECONDS);
    }

    public static void openURL(String url) {
        webDriver.get(url);
    }
}
