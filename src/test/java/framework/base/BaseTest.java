package framework.base;

import framework.logger.Log;
import framework.utilities.config_util.ConfigManager;
import framework.driver.DriverManager;
import org.testng.annotations.*;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseTest {
    private static String mainPageURL;
    private static final String MAIN_PAGE_CONFIG_PROPERTY = "mainPageURL";

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        Log.logTestSteps("Инициализируем драйвер.");
        ConfigManager.setConfig();
        DriverManager.getInstance(browser);
        mainPageURL = ConfigManager.getConfProperty(MAIN_PAGE_CONFIG_PROPERTY);
        DriverManager.openURL(mainPageURL);
    }

    @AfterMethod
    public void quitBrowser() {
        Log.logTestSteps("Закрываем драйвер.");
        DriverManager.quitDriver();
    }
}
