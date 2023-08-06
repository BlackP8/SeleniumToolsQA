package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class WidgetsPage extends BaseForm {
    private MarkedList sliderMenuElement = new MarkedList(By.xpath("//*[contains(@class, 'show')]//*[@id='item-3']"),
            "Slider button");
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public void clickSliderBtn() {
        Log.logPages(LOG_TEXT + sliderMenuElement.getName());
        sliderMenuElement.scrollToElement();
        sliderMenuElement.doClick();
    }
}
