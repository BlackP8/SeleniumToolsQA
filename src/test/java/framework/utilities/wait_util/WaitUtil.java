package framework.utilities.wait_util;

import framework.utilities.config_util.ConfigManager;
import framework.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class WaitUtil {
    private static WebDriverWait wait;
    private static final String WAIT_TIME = ConfigManager.getConfProperty("explicitWaitTime");

    public WaitUtil() { }

    public static WebElement setPresenceWait(String locator) {
        wait = new WebDriverWait(DriverManager.getDriver(), Long.parseLong(WAIT_TIME));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static List<WebElement> setAllPresenceWait(String locator) {
        wait = new WebDriverWait(DriverManager.getDriver(), Long.parseLong(WAIT_TIME));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public static void waitForAlert() {
        wait = new WebDriverWait(DriverManager.getDriver(), Long.parseLong(WAIT_TIME));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
