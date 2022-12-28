package framework.base;

import framework.driver.DriverManager;
import framework.logger.Log;
import framework.utilities.wait_util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseElement {
    private static WebElement element;
    private static String locator;
    private static String name;
    private static JavascriptExecutor executor;
    private static final String SCROLL_SCRIPT = "arguments[0].scrollIntoView();";

    protected BaseElement(String locator, String name) {
        this.name = name;
        this.locator = locator;
        element = WaitUtil.setPresenceWait(locator);
    }

    protected BaseElement(String locator) {
        this.locator = locator;
        element = WaitUtil.setPresenceWait(locator);
    }

    public void doClick() {
        Log.logElements("Нажатие кнопки.");
        element.click();
    }

    public String getName() {
        return name;
    }

    public void scrollToElement() {
        executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript(SCROLL_SCRIPT, element);
    }

    public String getText() {
        return element.getText();
    }

    public static WebElement findByCss(String selector) {
        element = DriverManager.getDriver().findElement(By.cssSelector(selector));
        return element;
    }

    protected static WebElement getElement() {
        return element;
    }

}
