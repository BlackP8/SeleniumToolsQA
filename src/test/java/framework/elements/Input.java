package framework.elements;

import framework.base.BaseElement;
import framework.logger.Log;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class Input extends BaseElement {

    public Input(String locator, String name) {
        super(locator, name);
    }

    public Input(String locator) {
        super(locator);
    }

    public void enterValue(String value) {
        Log.logElements("Ввод данных в текстовое поле " + getName());
        getElement().sendKeys(value);
    }

}
