package framework.driver;

import framework.utilities.config_util.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class DriverManager {
    private static WebDriver webDriver;
    private static String language;
    private static String implicitWaitTime;
    private static String windowSize;

    public static void createInstance(String browserName) {
            language = ConfigManager.getConfProperty("engLang");
            implicitWaitTime = ConfigManager.getConfProperty("implicitWaitTime");
            windowSize = ConfigManager.getConfProperty("maximizedWindow");

            if (browserName.toLowerCase().contains(BrowserFactory.FIREFOX.getBrowser())) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments(language, windowSize);
                webDriver = new FirefoxDriver(options);
                setTimeout();
            }
            else if (browserName.toLowerCase().contains(BrowserFactory.CHROME.getBrowser())) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments(language, windowSize);
                webDriver = new ChromeDriver(options);
                setTimeout();
            }
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
}
