package framework.base;

import org.openqa.selenium.WebElement;
import framework.utilities.wait_utility.WaitUtil;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseForm {

    public BaseForm() {
    }

    public static boolean checkPage(String identifier) {
        WebElement expectedEl = WaitUtil.setPresenceWait(identifier);
        return expectedEl.isDisplayed();
    }
}
