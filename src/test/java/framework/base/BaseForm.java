package framework.base;

import framework.utilities.wait_util.WaitUtil;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseForm {
    private By locator;

    protected BaseForm(By locator) {this.locator = locator; }

    protected BaseForm() {}

    protected boolean isPageAppeared() {
        return WaitUtil.setPresenceWait(locator).isDisplayed();
    }
}
