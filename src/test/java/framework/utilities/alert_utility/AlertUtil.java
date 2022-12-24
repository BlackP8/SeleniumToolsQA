package framework.utilities.alert_utility;

import framework.driver.DriverManager2;
import org.openqa.selenium.Alert;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertUtil {
    private static Alert alert = DriverManager2.getDriver().switchTo().alert();

    public static boolean checkAlert(String expectedText) {
        String actualText = alert.getText();
        return actualText.equals(expectedText);
    }

    public static void clickAlertOk() {
        alert.accept();
    }

    public static boolean checkAlertClosed() {
        boolean result = false;
        try {
            alert = DriverManager2.getDriver().switchTo().alert();
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
