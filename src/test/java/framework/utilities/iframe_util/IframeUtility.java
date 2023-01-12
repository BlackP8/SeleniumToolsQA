package framework.utilities.iframe_util;

import framework.driver.DriverManager;
import framework.logger.Log;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class IframeUtility {

    public static void switchToFrame(String id) {
        Log.logUtils(IframeUtility.class.getName() + ": Переключаемся на фрейм.");
        DriverManager.getDriver().switchTo().frame(id);
    }

    public static void switchBack() {
        Log.logUtils(IframeUtility.class.getName() + ": Переключаемся из фрейма на страницу.");
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void switchToFrame(int index) {
        Log.logUtils(IframeUtility.class.getName() + ": Переключаемся на фрейм.");
        DriverManager.getDriver().switchTo().frame(index);
    }

    public static String getFrameText(String location) {
        Log.logUtils(IframeUtility.class.getName() + ": Получаем текст из фрейма.");
        String text = DriverManager.getDriver().findElement(By.cssSelector(location)).getText();
        return text;
    }
}
