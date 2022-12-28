package framework.utilities.tab_util;

import framework.driver.DriverManager;
import framework.utilities.config_util.ConfigManager;

import java.util.concurrent.TimeUnit;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class TabUtility {
    private static String originalWindow = DriverManager.getDriver().getWindowHandle();
    private static final String WAIT = ConfigManager.getConfProperty("implicitWaitTime");

    public static void changeTab() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(WAIT), TimeUnit.SECONDS);
        for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static String getTabURL() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(WAIT), TimeUnit.SECONDS);
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void closeTab() {
        DriverManager.getDriver().close();
    }

    public static void switchTab() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(WAIT), TimeUnit.SECONDS);
        DriverManager.getDriver().switchTo().window(originalWindow);
    }
}
