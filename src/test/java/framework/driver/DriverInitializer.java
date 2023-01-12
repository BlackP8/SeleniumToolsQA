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
public abstract class DriverInitializer {
    private static String language = ConfigManager.getConfProperty("engLang");;
    private static String windowSize = ConfigManager.getConfProperty("maximizedWindow");

    protected static WebDriver createInstance(String browserName) {
        WebDriver webDriver = null;

        if (browserName.toLowerCase().contains(BrowserFactory.FIREFOX.getBrowser())) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(language, windowSize);
            webDriver = new FirefoxDriver(options);
        }
        else if (browserName.toLowerCase().contains(BrowserFactory.CHROME.getBrowser())) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(language, windowSize);
            webDriver = new ChromeDriver(options);
        }
        return webDriver;
    }
}
