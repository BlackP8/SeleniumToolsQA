package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class ElementsPage extends BaseForm {
    private static MarkedList listElement;
    private static final String WEB_TABLES_BUTTON_PATH = "//*[@id='item-3']//*[contains(text(), 'Web')]";
    private static final String WEB_TABLES_BUTTON_NAME = "Web tables button";

    public void clickWebElementsBtn() {
        listElement = new MarkedList(WEB_TABLES_BUTTON_PATH, WEB_TABLES_BUTTON_NAME);
        listElement.scrollToElement();
        listElement.doClick();
    }
}
