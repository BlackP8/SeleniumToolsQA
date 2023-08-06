package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class BrowserWindowsPage extends BaseForm {
    private Button newTabBtn = new Button(By.id("tabButton"), "New tab button");
    private Button elementsDropDown = new Button(By.xpath("//div[contains(text(),'Elements')]//following-sibling::div"),
            "Elements menu button");
    private MarkedList linksMenuElement = new MarkedList(By.xpath("//*[contains(@class, 'show')]//*[@id='item-5']"),
            "Links button");
    private static final By BROWSER_WINDOWS_PAGE_IDENTIFIER = By.id("browserWindows");
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public BrowserWindowsPage() {
        super(BROWSER_WINDOWS_PAGE_IDENTIFIER);
    }

    public boolean isBrowserWindowsPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + BrowserWindowsPage.class.getName());
        return isPageAppeared();
    }

    public void clickNewTabBtn() {
        Log.logPages(LOG_TEXT + newTabBtn.getName());
        newTabBtn.scrollToElement();
        newTabBtn.doClick();
    }

    public void clickLinksBtn() {
        Log.logPages(LOG_TEXT + elementsDropDown.getName());
        elementsDropDown.doClick();

        Log.logPages(LOG_TEXT + linksMenuElement.getName());
        linksMenuElement.scrollToElement();
        linksMenuElement.doClick();
    }
}
