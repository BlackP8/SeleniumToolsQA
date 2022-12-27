package framework.base;

import framework.driver.DriverManager;
import framework.utilities.wait_util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseElement {
    private static WebElement element;
    private static String locator;
    private static JavascriptExecutor executor;
    private static List<WebElement> list;
    private static final String SCROLL_SCRIPT = "arguments[0].scrollIntoView();";

    public BaseElement(String locator) {
        this.locator = locator;
        element = WaitUtil.setPresenceWait(locator);
        executor = (JavascriptExecutor) DriverManager.getDriver();
    }

    public void doClick() {
        element.click();
    }

    public boolean checkDisplayed() {
        return element.isDisplayed();
    }

    public boolean checkClosed() {
        return WaitUtil.waitForClose(element);
    }

    public void scrollToElement() {
        executor.executeScript(SCROLL_SCRIPT, element);
    }

    public String getText() {
        return element.getText();
    }

    protected static void setList() {
        list = DriverManager.getDriver().findElements(By.xpath(locator));
    }
    protected static List<WebElement> getList() {
        return list;
    }

    public static WebElement findByCss(String selector) {
        element = DriverManager.getDriver().findElement(By.cssSelector(selector));
        return element;
    }

    protected static WebElement getElement() {
        return element;
    }
}
