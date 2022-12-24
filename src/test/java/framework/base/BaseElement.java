package framework.base;

import framework.driver.DriverManager;
import framework.driver.DriverManager2;
import framework.utilities.wait_utility.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseElement {
    private static WebElement element;
    private static final String SCROLL_SCRIPT = "arguments[0].scrollIntoView();";
    private static JavascriptExecutor executor ;

    public BaseElement(String locator) {
        element = WaitUtil.setPresenceWait(locator);
        executor = (JavascriptExecutor) DriverManager2.getDriver();
    }

    public void doClick() {
        element.click();
    }

    public boolean checkDisplayed() {
        return element.isDisplayed();
    }

    public void scrollToElement() {
        executor.executeScript(SCROLL_SCRIPT, element);
    }

    public String getText() {
        return element.getText();
    }

    public static WebElement findByCss(String selector) {
        element = DriverManager2.getDriver().findElement(By.cssSelector(selector));
        return element;
    }
}
