package framework.driver;

import framework.utilities.config_util.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author Pavel Romanov 12.01.2023
 */
public abstract class DriverManager {
    private static final String LANGUAGE = ConfigManager.getConfProperty("engLang");;
    private static final String WINDOW_SIZE = ConfigManager.getConfProperty("maximizedWindow");
    private static WebDriver webDriver = null;

    public static void createInstance(String browserName) {
        if (webDriver == null) {
            if (browserName.toLowerCase().contains(BrowserFactory.FIREFOX.getBrowser())) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(new FirefoxOptions().addArguments(LANGUAGE, WINDOW_SIZE));
            } else if (browserName.toLowerCase().contains(BrowserFactory.CHROME.getBrowser())) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(new ChromeOptions().addArguments(LANGUAGE, WINDOW_SIZE));
            }
        }
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }

    public static void openURL(String url) {
        webDriver.get(url);
    }
}
