package page_objects;

import framework.elements.Button;
import framework.base.BaseForm;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.tab_util.TabUtility;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class MainPage extends BaseForm {
    private static Button btn;
    private static final String MAIN_PAGE_IDENTIFIER = "//*[@class='category-cards']";
    private static final String ALERTS_BUTTON_PATH = "//*[@class='card mt-4 top-card']//*[contains(text(),'Alerts')]";
    private static final String ELEMENTS_BUTTON_PATH = "//*[@class='card mt-4 top-card']//*[contains(text(),'Elements')]";
    private static final String ALERTS_BUTTON_NAME = "AlertsFramesWindows button";
    private static final String ELEMENTS_BUTTON_NAME = "Elements button";
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public boolean checkMainPage() {
        return BaseForm.checkPage(MAIN_PAGE_IDENTIFIER);
    }

    public void changeTab() {
        TabUtility.switchTab();
    }

    public void clickAlertsBtn() {
        btn = new Button(ALERTS_BUTTON_PATH, ALERTS_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }

    public void clickElementsBtn() {
        btn = new Button(ELEMENTS_BUTTON_PATH, ELEMENTS_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }
}
