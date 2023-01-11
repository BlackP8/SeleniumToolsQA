package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class BrowserWindowsPage extends BaseForm {
    private Button newTabBtn = new Button("//*[@id='tabButton']", "New tab button");
    private Button elementsDropDown = new Button("//div[contains(text(),'Elements')]//following-sibling::div",
            "Elements menu button");
    private MarkedList linksMenuElement = new MarkedList("//*[contains(@class, 'show')]//*[@id='item-5']", "Links button");

    private static final String BROWSER_WINDOWS_PAGE_IDENTIFIER = "//*[@id='browserWindows']";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public boolean isBrowserWindowsPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + BrowserWindowsPage.class.getName());
        return BaseForm.isPageAppeared(BROWSER_WINDOWS_PAGE_IDENTIFIER);
    }

    public void clickNewTabBtn() {
        Log.logPages(LOG_TEXT + newTabBtn.getName());
        newTabBtn.findElement();
        newTabBtn.scrollToElement();
        newTabBtn.doClick();
    }

    public void clickLinksBtn() {
        Log.logPages(LOG_TEXT + elementsDropDown.getName());
        elementsDropDown.findElement();
        elementsDropDown.doClick();

        Log.logPages(LOG_TEXT + linksMenuElement.getName());
        linksMenuElement.findElement();
        linksMenuElement.scrollToElement();
        linksMenuElement.doClick();
    }
}
