package framework.base;

import framework.logger.Log;
import framework.utilities.config_util.ConfigManager;
import framework.driver.BrowserFactory;
import framework.driver.DriverManager;
import org.testng.annotations.*;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseTest {
    private static String mainPageURL;

    @BeforeMethod
    public void setup() {
        Log.logTestSteps("Инициализируем драйвер.");
        ConfigManager.setConfig();
        DriverManager.createInstance(BrowserFactory.CHROME.getBrowser());
        mainPageURL = ConfigManager.getConfProperty("mainPageURL");
        DriverManager.getDriver().get(mainPageURL);
    }

    @AfterMethod
    public void quitBrowser() {
        Log.logTestSteps("Закрываем драйвер.");
        DriverManager.quitDriver();
    }
}
