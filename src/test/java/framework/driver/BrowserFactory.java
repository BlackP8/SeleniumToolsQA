package framework.driver;

import framework.utilities.config_utility.ConfigManager;

/**
 * @author Pavel Romanov 22.12.2022
 */
public enum BrowserFactory {
    FIREFOX(ConfigManager.getConfProperty("firefoxBrowser")),
    CHROME(ConfigManager.getConfProperty("chromeBrowser"));

    private final String browser;

    private BrowserFactory(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
