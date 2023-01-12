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
    private WebElement element;
    private String name;
    private String locator;
    private static WebElement staticElement;
    private static JavascriptExecutor executor;
    private static final String SCROLL_SCRIPT = "arguments[0].scrollIntoView();";

    protected BaseElement(String locator, String name) {
        this.name = name;
        this.locator = locator;
    }

    protected BaseElement(String locator) {
        this.locator = locator;
    }

    public void findElement() {
        Log.logElements("Ищем элемент.");
        element = WaitUtil.setPresenceWait(locator);
        staticElement = WaitUtil.setPresenceWait(locator);
    }

    public void doClick() {
        Log.logElements("Нажимаем кнопку.");
        element.click();
    }

    public String getName() {
        return name;
    }

    public void scrollToElement() {
        Log.logElements("Листаем страницу до элемента.");
        executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript(SCROLL_SCRIPT, element);
    }

    protected static String getAttribute(String attributeName) {
        return staticElement.getAttribute(attributeName);
    }

    public String getText() {
        return element.getText();
    }

    protected static WebElement getElement() {
        return staticElement;
    }
}
