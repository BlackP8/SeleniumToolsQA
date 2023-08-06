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
    private By locator;
    private static WebElement staticElement;
    private static final String SCROLL_SCRIPT = "arguments[0].scrollIntoView();";

    protected BaseElement(By locator, String name) {
        this.name = name;
        this.locator = locator;
    }

    protected BaseElement(By locator) {
        this.locator = locator;
    }

//    public void findElement() {
//        Log.logElements("Ищем элемент.");
//        element = WaitUtil.setPresenceWait(locator);
//        staticElement = WaitUtil.setPresenceWait(locator);
//    }

    public void doClick() {
        Log.logElements("Нажимаем кнопку.");
        WaitUtil.setPresenceWait(locator).click();
    }

    public String getName() {
        return name;
    }

    public void scrollToElement() {
        Log.logElements("Листаем страницу до элемента.");
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(SCROLL_SCRIPT, WaitUtil.setPresenceWait(locator));
    }

    protected static String getAttribute(String attributeName) {
        return staticElement.getAttribute(attributeName);
    }

    public String getText() {
        return WaitUtil.setPresenceWait(locator).getText();
    }

    protected static WebElement getElement() {
        return staticElement;
    }
}
