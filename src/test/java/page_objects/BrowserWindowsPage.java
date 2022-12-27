package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.MarkedList;
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

    public boolean checkBrowserWindowsPage() {
        return BaseForm.checkPage(BROWSER_WINDOWS_PAGE_IDENTIFIER);
    }

    public void clickNewTabBtn() {
        btn = new Button(NEW_TAB_BUTTON_PATH, NEW_TAB_BUTTON_NAME);
        btn.doClick();
    }

    public void closeTab() {
        TabUtility.closeTab();
        TabUtility.switchTab();
    }

    public void clickLinksBtn() {
        btn = new Button(ELEMENTS_POPUP_PATH, ELEMENTS_POPUP_NAME);
        btn.doClick();

        listElement = new MarkedList(LINKS_BUTTON_PATH, LINKS_BUTTON_NAME);
        listElement.scrollToElement();
        listElement.doClick();
    }
}
