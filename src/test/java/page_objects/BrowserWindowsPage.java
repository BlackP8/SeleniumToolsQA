package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.tab_util.TabUtility;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class BrowserWindowsPage extends BaseForm{
    private static Button btn;
    private static MarkedList listElement;
    private static final String BROWSER_WINDOWS_PAGE_IDENTIFIER = "//*[@id='browserWindows']";
    private static final String NEW_TAB_BUTTON_PATH = "//*[@id='tabButton']";
    private static final String NEW_TAB_BUTTON_NAME = "New tab button";
    private static final String ELEMENTS_POPUP_PATH = "//div[contains(text(),'Elements')]//following-sibling::div";
    private static final String ELEMENTS_POPUP_NAME = "Elements menu button";
    private static final String LINKS_BUTTON_PATH = "//*[contains(@class, 'show')]//*[@id='item-5']";
    private static final String LINKS_BUTTON_NAME = "Links button";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public boolean checkBrowserWindowsPage() {
        Log.logPages(PAGE_LOG_TEXT + BrowserWindowsPage.class.getName());
        return BaseForm.checkPage(BROWSER_WINDOWS_PAGE_IDENTIFIER);
    }

    public void clickNewTabBtn() {
        btn = new Button(NEW_TAB_BUTTON_PATH, NEW_TAB_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }

    public void closeTab() {
        Log.logPages("Закрываем вкладку " + SamplePage.class.getName() + "и переходим на форму "
                + BrowserWindowsPage.class.getName());
        TabUtility.closeTab();
        TabUtility.switchTab();
    }

    public void clickLinksBtn() {
        btn = new Button(ELEMENTS_POPUP_PATH, ELEMENTS_POPUP_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.doClick();

        listElement = new MarkedList(LINKS_BUTTON_PATH, LINKS_BUTTON_NAME);
        Log.logPages(LOG_TEXT + listElement.getName());
        listElement.scrollToElement();
        listElement.doClick();
    }
}
