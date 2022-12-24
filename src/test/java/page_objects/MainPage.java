package page_objects;

import framework.elements.Button;
import framework.base.BaseForm;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class MainPage {
    private static Button btn;
    private static final String MAIN_PAGE_IDENTIFIER = "//*[@class='category-cards']";
    private static final String ALERTS_BUTTON_PATH = "//*[@class='card mt-4 top-card']//*[contains(text(),'Alerts')]";

    public boolean checkMainPage() {
        return BaseForm.checkPage(MAIN_PAGE_IDENTIFIER);
    }

    public void clickAlertsBtn() {
        btn = new Button(ALERTS_BUTTON_PATH);
        btn.scrollToElement();
        btn.doClick();
    }
}
