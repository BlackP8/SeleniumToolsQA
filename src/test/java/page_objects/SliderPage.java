package page_objects;

import framework.base.BaseForm;
import framework.elements.Input;
import framework.elements.MarkedList;
import framework.elements.Slider;
import framework.logger.Log;
import framework.logger.LogMessages;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class SliderPage extends BaseForm {
    private Input sliderInput = new Input(By.id("sliderValue"), "Slider input box");
    private Slider slider = new Slider(By.xpath("//input[contains(@class, 'range-slider')]"), "Slider");
    private MarkedList progressBarMenuElement = new MarkedList(By.xpath("//*[contains(@class, 'show')]//*[@id='item-4']"),
            "Progress bar button");

    private static final By SLIDER_PAGE_IDENTIFIER = By.id("sliderContainer");
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public SliderPage() {
        super(SLIDER_PAGE_IDENTIFIER);
    }

    public boolean isSliderPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + SliderPage.class.getName());
        return isPageAppeared();
    }

    public void moveSlider(String randomNumber) {
        Log.logPages("Двигаем слайдер на случайное значение.");
        slider.scrollToElement();
        slider.doClick();
        slider.moveSliderToRandomPoint(Integer.parseInt(randomNumber));
    }

    public boolean isSliderValueCorrect(String randomNumber) {
        Log.logPages(CHECK_LOG_TEXT + "что значение слайдера соответствует сгенерированному.");
        return sliderInput.getValue().equals(randomNumber);
    }

    public void clickProgressBarBtn() {
        Log.logPages(LOG_TEXT + progressBarMenuElement.getName());
        progressBarMenuElement.scrollToElement();
        progressBarMenuElement.doClick();
    }
}
