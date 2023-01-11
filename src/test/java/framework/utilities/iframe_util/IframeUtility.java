package framework.utilities.iframe_util;

import framework.driver.DriverManager;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class IframeUtility {

    public static void switchToFrame(String id) {
        DriverManager.getDriver().switchTo().frame(id);
    }

    public static void switchBack() {
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void switchToFrame(int index) {
        DriverManager.getDriver().switchTo().frame(index);
    }
}
