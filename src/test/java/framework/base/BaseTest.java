package framework.base;

import framework.utilities.config_utility.ConfigManager;
import framework.driver.BrowserFactory;
import framework.driver.DriverManager2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseTest {
    private static String mainPageURL;

    @BeforeClass
    public void setup() {
        ConfigManager.setConfig();
        DriverManager2.createInstance(BrowserFactory.CHROME.getBrowser());
        mainPageURL = ConfigManager.getConfProperty("mainPageURL");
        DriverManager2.getDriver().get(mainPageURL);
    }

    @AfterClass
    public void quitBrowser() {
        DriverManager2.quitDriver();
    }
}
