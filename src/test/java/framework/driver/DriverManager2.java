package framework.driver;

import framework.utilities.config_utility.ConfigManager;
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
public class DriverManager2 {
    private static WebDriver webDriver;
    private static String language;
    private static String implicitWaitTime;
    private static String windowSize;

    public DriverManager2() {}

    public static WebDriver createInstance(String browserName) {
        if(webDriver == null) {
            language = ConfigManager.getConfProperty("engLang");
            implicitWaitTime = ConfigManager.getConfProperty("implicitWaitTime");
            windowSize = ConfigManager.getConfProperty("maximizedWindow");

            if (browserName.toLowerCase().contains("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments(language, windowSize);
                webDriver = new FirefoxDriver(options);
            }
            else if (browserName.toLowerCase().contains("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments(language, windowSize);
                webDriver = new ChromeDriver(options);
            }
            webDriver.manage().timeouts().implicitlyWait(Long.parseLong(implicitWaitTime),
                    TimeUnit.SECONDS);
        }
        return getDriver();
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
