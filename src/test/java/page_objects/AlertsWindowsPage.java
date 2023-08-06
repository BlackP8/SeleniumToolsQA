package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertsWindowsPage extends BaseForm {
    private MarkedList alertsMenuElement = new MarkedList(By.xpath("//*[@id='item-1']//*[contains(text(), 'Alerts')]"),
            "Alerts button");
    private MarkedList nestedFramesMenuElement = new MarkedList(By.xpath("//*[@id='item-3']//*[contains(text(), 'Nested')]"),
            "Nested frames button");
    private MarkedList browserWindowsMenuElement = new MarkedList(By.xpath("//*[@id='item-0']//*[contains(text(), 'Browser')]"),
            "Browser button");

    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public void clickAlertsMenuBtn() {
        Log.logPages(LOG_TEXT + alertsMenuElement.getName());
        alertsMenuElement.scrollToElement();
        alertsMenuElement.doClick();
    }

    public void clickNestedFramesBtn() {
        Log.logPages(LOG_TEXT + nestedFramesMenuElement.getName());
        nestedFramesMenuElement.scrollToElement();
        nestedFramesMenuElement.doClick();
    }

    public void clickBrowserWindowsBtn() {
        Log.logPages(LOG_TEXT + browserWindowsMenuElement.getName());
        browserWindowsMenuElement.scrollToElement();
        browserWindowsMenuElement.doClick();;
    }
}
