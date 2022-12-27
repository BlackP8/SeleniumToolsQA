package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class ElementsPage extends BaseForm {
    private static Button btn;
    private static final String WEB_TABLES_BUTTON_PATH = "//*[@id='item-3']//*[contains(text(), 'Web')]";

    public void clickWebElementsBtn() {
        btn = new Button(WEB_TABLES_BUTTON_PATH);
        btn.scrollToElement();
        btn.doClick();
    }
}
