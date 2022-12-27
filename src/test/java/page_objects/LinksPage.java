package page_objects;

import framework.base.BaseForm;
import framework.elements.Link;
import framework.utilities.tab_util.TabUtil;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class LinksPage extends BaseForm{
    private static Link link;
    private static final String LINKS_PAGE_IDENTIFIER = "//*[@id='linkWrapper']";
    private static final String HOME_BUTTON_PATH = "//*[@id='simpleLink']";

    public boolean checkLinksPage() {
        return BaseForm.checkPage(LINKS_PAGE_IDENTIFIER);
    }

    public void clickHomeBtn() {
        link = new Link(HOME_BUTTON_PATH);
        link.doClick();
    }

    public void changeTab() {
        TabUtil.changeTab();
    }
}
