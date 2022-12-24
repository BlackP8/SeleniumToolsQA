package page_objects;

import framework.elements.Button;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertsWindowsPage {
    private static Button btn;
    private static final String ALERTS_MENU_PATH = "//*[@id='item-1']//*[contains(text(), 'Alerts')]";
    private static final String NESTED_FRAMES_BUTTON_PATH = "//*[@id='item-3']//*[contains(text(), 'Nested')]";

    public void clickAlertsMenuBtn() {
        btn = new Button(ALERTS_MENU_PATH);
        btn.scrollToElement();
        btn.doClick();
    }

    public void clickNestedFramesBtn() {
        btn = new Button(NESTED_FRAMES_BUTTON_PATH);
        btn.scrollToElement();
        btn.doClick();
    }
}
