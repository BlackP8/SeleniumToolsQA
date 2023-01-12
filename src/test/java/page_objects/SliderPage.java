package page_objects;

import framework.base.BaseForm;
import framework.elements.Input;
import framework.elements.MarkedList;
import framework.elements.Slider;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class SliderPage extends BaseForm {
    private Input sliderInput = new Input("//*[@id='sliderValue']", "Slider input box");
    private Slider slider = new Slider("//input[contains(@class, 'range-slider')]", "Slider");
    private MarkedList progressBarMenuElement = new MarkedList("//*[contains(@class, 'show')]//*[@id='item-4']",
            "Progress bar button");

    private static final String SLIDER_PAGE_IDENTIFIER = "//*[@id='sliderContainer']";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public boolean isSliderPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + SliderPage.class.getName());
        return BaseForm.isPageAppeared(SLIDER_PAGE_IDENTIFIER);
    }

    public void moveSlider(String randomNumber) {
        Log.logPages("Двигаем слайдер на случайное значение.");
        slider.findElement();
        slider.scrollToElement();
        slider.doClick();
        slider.moveSliderToRandomPoint(Integer.parseInt(randomNumber));
    }

    public boolean isSliderValueCorrect(String randomNumber) {
        Log.logPages(CHECK_LOG_TEXT + "что значение слайдера соответствует сгенерированному.");
        sliderInput.findElement();
        return sliderInput.getValue().equals(randomNumber);
    }

    public void clickProgressBarBtn() {
        Log.logPages(LOG_TEXT + progressBarMenuElement.getName());
        progressBarMenuElement.findElement();
        progressBarMenuElement.scrollToElement();
        progressBarMenuElement.doClick();
    }
}
