package framework.utilities.tab_util;

import framework.driver.DriverManager;
import framework.logger.Log;
import framework.utilities.config_util.ConfigManager;

import java.util.concurrent.TimeUnit;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class TabUtility {
    private static String originalWindow = DriverManager.getDriver().getWindowHandle();
    private static final String WAIT = ConfigManager.getConfProperty("implicitWaitTime");

    public static void changeTab() {
        Log.logUtils(TabUtility.class.getName() + ": Переключаемся на другую вкладку.");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(WAIT), TimeUnit.SECONDS);
        for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static String getTabURL() {
        Log.logUtils(TabUtility.class.getName() + ": Получаем URL текущей вкладки.");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(WAIT), TimeUnit.SECONDS);
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void closeTab() {
        Log.logUtils(TabUtility.class.getName() + ": Закрываем вкладу.");
        DriverManager.getDriver().close();
    }

    public static void switchTab() {
        Log.logUtils(TabUtility.class.getName() + ": Переключаемся на другую вкладку.");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(WAIT), TimeUnit.SECONDS);
        DriverManager.getDriver().switchTo().window(originalWindow);
    }
}
