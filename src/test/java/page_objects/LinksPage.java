package page_objects;

import framework.base.BaseForm;
import framework.elements.Link;
import framework.utilities.tab_util.TabUtility;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class LinksPage extends BaseForm{
    private static Link link;
    private static final String LINKS_PAGE_IDENTIFIER = "//*[@id='linkWrapper']";
    private static final String HOME_BUTTON_PATH = "//*[@id='simpleLink']";
    private static final String HOME_BUTTON_NAME = "Home button";

    public boolean checkLinksPage() {
        return BaseForm.checkPage(LINKS_PAGE_IDENTIFIER);
    }

    public void clickHomeBtn() {
        link = new Link(HOME_BUTTON_PATH, HOME_BUTTON_NAME);
        link.doClick();
    }

    public void changeTab() {
        TabUtility.changeTab();
    }
}
