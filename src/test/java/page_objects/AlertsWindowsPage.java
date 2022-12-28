package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertsWindowsPage extends BaseForm {
    private static MarkedList listElement;
    private static final String ALERTS_MENU_PATH = "//*[@id='item-1']//*[contains(text(), 'Alerts')]";
    private static final String ALERTS_MENU_NAME = "Alerts button";
    private static final String NESTED_FRAMES_BUTTON_PATH = "//*[@id='item-3']//*[contains(text(), 'Nested')]";
    private static final String NESTED_FRAMES_BUTTON_NAME = "Nested frames button";
    private static final String BROWSER_WINDOWS_BUTTON_PATH = "//*[@id='item-0']//*[contains(text(), 'Browser')]";
    private static final String BROWSER_WINDOWS_BUTTON_NAME = "Browser button";
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public void clickAlertsMenuBtn() {
        listElement = new MarkedList(ALERTS_MENU_PATH, ALERTS_MENU_NAME);
        Log.logPages(LOG_TEXT + listElement.getName());
        listElement.scrollToElement();
        listElement.doClick();
    }

    public void clickNestedFramesBtn() {
        listElement = new MarkedList(NESTED_FRAMES_BUTTON_PATH, NESTED_FRAMES_BUTTON_NAME);
        Log.logPages(LOG_TEXT + listElement.getName());
        listElement.scrollToElement();
        listElement.doClick();
    }

    public void clickBrowserWindowsBtn() {
        listElement = new MarkedList(BROWSER_WINDOWS_BUTTON_PATH, BROWSER_WINDOWS_BUTTON_NAME);
        Log.logPages(LOG_TEXT + listElement.getName());
        listElement.scrollToElement();
        listElement.doClick();;
    }
}
