package page_objects;

import framework.elements.Button;
import framework.base.BaseForm;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class MainPage extends BaseForm {
    private Button alertsFramesWindowsBtn = new Button("//*[@class='category-cards']//*[contains(text(),'Alerts')]",
            "AlertsFramesWindows button");
    private Button elementsBtn = new Button("//*[@class='category-cards']//*[contains(text(),'Elements')]",
            "Elements button");

    private static final String MAIN_PAGE_IDENTIFIER = "//*[@class='category-cards']";
    private static final String BUTTON_LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();

    public boolean isMainPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + MainPage.class.getName());
        return BaseForm.isPageAppeared(MAIN_PAGE_IDENTIFIER);
    }

    public void clickAlertsFramesWindowsBtn() {
        Log.logPages(BUTTON_LOG_TEXT + alertsFramesWindowsBtn.getName());
        alertsFramesWindowsBtn.findElement();
        alertsFramesWindowsBtn.scrollToElement();
        alertsFramesWindowsBtn.doClick();
    }

    public void clickElementsBtn() {
        Log.logPages(BUTTON_LOG_TEXT + elementsBtn.getName());
        elementsBtn.findElement();
        elementsBtn.scrollToElement();
        elementsBtn.doClick();
    }
}
