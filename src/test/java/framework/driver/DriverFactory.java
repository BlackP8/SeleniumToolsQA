package framework.driver;

import framework.utilities.config_utility.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class DriverFactory {
    private static final String ENG_LANGUAGE = ConfigManager.getConfProperty("engLang");
    private static final String WINDOW_SIZE = ConfigManager.getConfProperty("maximizedWindow");

    public static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        if (browserName.toLowerCase().contains(BrowserFactory.FIREFOX.name())) {
            WebDriverManager.getInstance(FIREFOX).setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(ENG_LANGUAGE, WINDOW_SIZE);
            return new FirefoxDriver(options);
        }

        if (browserName.toLowerCase().contains(BrowserFactory.CHROME.name())) {
            WebDriverManager.getInstance(CHROME).setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(ENG_LANGUAGE, WINDOW_SIZE);
            return new ChromeDriver(options);
        }
        return driver;
    }
}
