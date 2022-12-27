package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.utilities.tab_util.TabUtil;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class BrowserWindowsPage extends BaseForm{
    private static Button btn;
    private static final String BROWSER_WINDOWS_PAGE_IDENTIFIER = "//*[@id='browserWindows']";
    private static final String NEW_TAB_BUTTON_PATH = "//*[@id='tabButton']";
    private static final String ELEMENTS_POPUP_PATH = "//div[contains(text(),'Elements')]//following-sibling::div";
    private static final String LINKS_BUTTON_PATH = "//*[contains(@class, 'show')]//*[@id='item-5']";

    public boolean checkBrowserWindowsPage() {
        return BaseForm.checkPage(BROWSER_WINDOWS_PAGE_IDENTIFIER);
    }

    public void clickNewTabBtn() {
        btn = new Button(NEW_TAB_BUTTON_PATH);
        btn.doClick();
    }

    public void closeTab() {
        TabUtil.closeTab();
        TabUtil.switchTab();
    }

    public void clickLinksBtn() {
        btn = new Button(ELEMENTS_POPUP_PATH);
        btn.doClick();

        btn = new Button(LINKS_BUTTON_PATH);
        btn.scrollToElement();
        btn.doClick();
    }
}
