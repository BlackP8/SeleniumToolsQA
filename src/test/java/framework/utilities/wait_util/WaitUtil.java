package framework.utilities.wait_util;

import framework.driver.DriverManager;
import framework.logger.Log;
import framework.utilities.config_util.ConfigManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class WaitUtil {
    private static final String WAIT_TIME = ConfigManager.getConfProperty("explicitWaitTime");
    private static final int WAIT_ATTRIBUTE_TIME = 50;

    public WaitUtil() { }

    public static WebElement setPresenceWait(By locator) {
        Log.logUtils(WaitUtil.class.getName() + ": Ждем элемент.");
        return new WebDriverWait(DriverManager.getDriver(), Long.parseLong(WAIT_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static Alert waitForAlert() {
        Log.logUtils(WaitUtil.class.getName() + ": Ждем алерт.");
        return new WebDriverWait(DriverManager.getDriver(), Long.parseLong(WAIT_TIME))
                .until(ExpectedConditions.alertIsPresent());
    }

    public static boolean waitForAttribute(WebElement element, String attribute, String value) {
        Log.logUtils(WaitUtil.class.getName() + ": Ждем progress bar.");
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Long.parseLong(WAIT_TIME));
        wait.pollingEvery(Duration.ofMillis(WAIT_ATTRIBUTE_TIME));
        return wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }
}
