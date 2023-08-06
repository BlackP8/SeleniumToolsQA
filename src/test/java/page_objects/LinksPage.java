package page_objects;

import framework.base.BaseForm;
import framework.elements.Link;
import framework.logger.Log;
import framework.logger.LogMessages;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class LinksPage extends BaseForm{
    private Link homeLink = new Link(By.id("simpleLink"), "Home button");
    private static final By LINKS_PAGE_IDENTIFIER = By.id("linkWrapper");
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public LinksPage() {
        super(LINKS_PAGE_IDENTIFIER);
    }

    public boolean isLinksPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + LinksPage.class.getName());
        return isPageAppeared();
    }

    public void clickHomeBtn() {
        Log.logPages(LOG_TEXT + homeLink.getName());
        homeLink.scrollToElement();
        homeLink.doClick();
    }
}
