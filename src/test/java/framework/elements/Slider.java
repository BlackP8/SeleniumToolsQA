package framework.elements;

import framework.base.BaseElement;
import framework.logger.Log;
import org.openqa.selenium.Keys;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class Slider extends BaseElement {
    private static final String VALUE_ATTRIBUTE = "value";

    public Slider(String locator, String name) {
        super(locator, name);
    }

    public void moveSliderToRandomPoint(int randomNumber) {
        Log.logElements("Перемещение " + getName() + " на случайное значение.");
        int value = Integer.parseInt(BaseElement.getAttribute(VALUE_ATTRIBUTE));
        int range = 0;

        if (value < randomNumber) {
            range = randomNumber - value;
            for (int i = 0; i < range; i++) {
                getElement().sendKeys(Keys.ARROW_RIGHT);
            }
        }
        else if (value > randomNumber) {
            range = value - randomNumber;
            for (int i = range; i > 0; i--) {
                getElement().sendKeys(Keys.ARROW_LEFT);
            }
        }
    }
}
