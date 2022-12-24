package framework.utilities.wait_utility;

import framework.utilities.config_utility.ConfigManager;
import framework.driver.DriverManager2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class WaitUtil {
    private static WebDriverWait wait = new WebDriverWait(DriverManager2.getDriver(), Long.parseLong(ConfigManager.getConfProperty("explicitWaitTime")));;

    public WaitUtil() { }

    public static WebElement setPresenceWait(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static List<WebElement> setAllPresenceWait(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }
}
