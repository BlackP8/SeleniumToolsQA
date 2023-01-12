package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class WidgetsPage extends BaseForm {
    private MarkedList sliderMenuElement = new MarkedList("//*[contains(@class, 'show')]//*[@id='item-3']",
            "Slider button");

    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public void clickSliderBtn() {
        Log.logPages(LOG_TEXT + sliderMenuElement.getName());
        sliderMenuElement.findElement();
        sliderMenuElement.scrollToElement();
        sliderMenuElement.doClick();
    }
}
