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
    private static final String BUTTON_LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();

    public boolean checkMainPage() {
        Log.logPages(PAGE_LOG_TEXT + MainPage.class.getName());
        return BaseForm.checkPage(MAIN_PAGE_IDENTIFIER);
    }

    public void changeTab() {
        Log.logPages(PAGE_LOG_TEXT + LinksPage.class.getName());
        TabUtility.switchTab();
    }

    public void clickAlertsBtn() {
        btn = new Button(ALERTS_BUTTON_PATH, ALERTS_BUTTON_NAME);
        Log.logPages(BUTTON_LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }

    public void clickElementsBtn() {
        btn = new Button(ELEMENTS_BUTTON_PATH, ELEMENTS_BUTTON_NAME);
        Log.logPages(BUTTON_LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }
}
