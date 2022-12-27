package framework.base;

import config_util.ConfigManager;
import framework.driver.BrowserFactory;
import framework.driver.DriverManager;
import org.testng.annotations.*;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseTest {
    private static String mainPageURL;
    private static String marker = "TEST_STEPS";

    @BeforeClass
    public void setup() {
        ConfigManager.setConfig();
        DriverManager.createInstance(BrowserFactory.CHROME.getBrowser());
        mainPageURL = ConfigManager.getConfProperty("mainPageURL");
        DriverManager.getDriver().get(mainPageURL);
    }

    @AfterClass
    public void quitBrowser() {
        DriverManager.quitDriver();
    }
}
