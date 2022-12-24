package framework.driver;

import framework.utilities.config_utility.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class ChromeDriverManager extends DriverManager {
    private static final String ENG_LANGUAGE = ConfigManager.getConfProperty("engLang");
    private static final String WINDOW_SIZE = ConfigManager.getConfProperty("maximizedWindow");

    @Override
    protected WebDriver createDriver() {
        ConfigManager.setConfig();
        WebDriverManager.getInstance(CHROME).setup();

        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(ENG_LANGUAGE, WINDOW_SIZE);
        return options;
    }
}
