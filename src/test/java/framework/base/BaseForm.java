package framework.base;

import framework.utilities.wait_util.WaitUtil;
import org.openqa.selenium.WebElement;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseForm {

    public BaseForm() { }

    protected static boolean checkPage(String identifier) {
        WebElement expectedEl = WaitUtil.setPresenceWait(identifier);
        return expectedEl.isDisplayed();
    }
}
