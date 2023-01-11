package page_objects;

import framework.base.BaseForm;
import framework.elements.Link;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class LinksPage extends BaseForm{
    private Link homeLink = new Link("//*[@id='simpleLink']", "Home button");

    private static final String LINKS_PAGE_IDENTIFIER = "//*[@id='linkWrapper']";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public boolean isLinksPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + LinksPage.class.getName());
        return BaseForm.isPageAppeared(LINKS_PAGE_IDENTIFIER);
    }

    public void clickHomeBtn() {
        Log.logPages(LOG_TEXT + homeLink.getName());
        homeLink.findElement();
        homeLink.scrollToElement();
        homeLink.doClick();
    }
}
