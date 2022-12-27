package framework.utilities.alert_util;

import framework.driver.DriverManager;
import framework.utilities.wait_util.WaitUtil;
import org.openqa.selenium.Alert;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertUtil {
    private static Alert alert;

    public static boolean checkAlert(String expectedText) {
        WaitUtil.waitForAlert();
        alert = DriverManager.getDriver().switchTo().alert();
        String actualText = alert.getText();
        return actualText.equals(expectedText);
    }

    public static void clickAlertOk() {
        alert.accept();
    }

    public static boolean checkAlertClosed() {
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
        alert.sendKeys(text);
    }
}
