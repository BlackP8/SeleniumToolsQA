package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class ElementsPage extends BaseForm {
    private MarkedList webTablesMenuElement = new MarkedList("//*[@id='item-3']//*[contains(text(), 'Web')]",
            "Web tables button");
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public void clickWebElementsBtn() {
        Log.logPages(LOG_TEXT + webTablesMenuElement.getName());
        webTablesMenuElement.findElement();
        webTablesMenuElement.scrollToElement();
        webTablesMenuElement.doClick();
    }
}
