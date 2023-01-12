package framework.utilities.alert_util;

import framework.driver.DriverManager;
import framework.logger.Log;
import framework.utilities.wait_util.WaitUtil;
import org.openqa.selenium.Alert;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertUtility {
    private static Alert alert;

    public static void switchToAlert() {
        Log.logUtils(AlertUtility.class.getName() + ": Переключаемся на алерт.");
        WaitUtil.waitForAlert();
        alert = DriverManager.getDriver().switchTo().alert();
    }

    public static boolean isAlertTextCorrect(String expectedText) {
        Log.logUtils(AlertUtility.class.getName() + ": Сравниваем текст алерта с ожидаемым.");
        String actualText = alert.getText();
        return actualText.equals(expectedText);
    }

    public static void clickAlertOk() {
        Log.logUtils(AlertUtility.class.getName() + ": Нажимаем кнопку OK на алерте.");
        alert.accept();
    }

    public static boolean isAlertClosed() {
        Log.logUtils(AlertUtility.class.getName() + ": Проверяем, что алерт закрыт.");
        boolean result = false;
        try {
            alert = DriverManager.getDriver().switchTo().alert();
        }
        catch (Exception e) {
            result = true;
        }
        return result;
    }

    public static void enterText(String text) {
        Log.logUtils(AlertUtility.class.getName() + ": Записываем текст в алерт.");
        alert.sendKeys(text);
    }
}
