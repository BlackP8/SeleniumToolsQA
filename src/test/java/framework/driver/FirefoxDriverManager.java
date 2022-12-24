package framework.driver;

import framework.utilities.config_utility.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class FirefoxDriverManager extends DriverManager {
    private static String ENG_LANGUAGE;
    private static String WINDOW_SIZE;

    @Override
    protected WebDriver createDriver() {
        ConfigManager.setConfig();
        ENG_LANGUAGE = ConfigManager.getConfProperty("engLang");
        WINDOW_SIZE = ConfigManager.getConfProperty("maximizedWindow");
        WebDriverManager.getInstance(FIREFOX).setup();
        return new FirefoxDriver(getFireFoxOptions());
    }

    private FirefoxOptions getFireFoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(ENG_LANGUAGE, WINDOW_SIZE);
        return options;
    }
}
