package framework.utilities.alert_util;

import framework.driver.DriverManager;
import framework.logger.Log;
import framework.utilities.wait_util.WaitUtil;
import org.openqa.selenium.NoAlertPresentException;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertUtility {
    public static boolean isAlertTextCorrect(String expectedText) {
        Log.logUtils(AlertUtility.class.getName() + ": Сравниваем текст алерта с ожидаемым.");
        return WaitUtil.waitForAlert().getText().equals(expectedText);
    }

    public static void clickAlertOk() {
        Log.logUtils(AlertUtility.class.getName() + ": Нажимаем кнопку OK на алерте.");
        WaitUtil.waitForAlert().accept();
    }

    public static boolean isAlertClosed() {
        Log.logUtils(AlertUtility.class.getName() + ": Проверяем, что алерт закрыт.");
        boolean result = false;
        try {
             DriverManager.getDriver().switchTo().alert();
        }
        catch (NoAlertPresentException e) {
            result = true;
        }
        return result;
    }

    public static void enterText(String text) {
        Log.logUtils(AlertUtility.class.getName() + ": Записываем текст в алерт.");
        WaitUtil.waitForAlert().sendKeys(text);
    }
}
