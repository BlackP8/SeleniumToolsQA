package framework.elements;

import framework.base.BaseElement;
import framework.logger.Log;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class Input extends BaseElement {
    private static final String VALUE_ATTRIBUTE = "value";

    public Input(By locator, String name) {
        super(locator, name);
    }

    public void enterValue(String value) {
        Log.logElements("Ввод данных в текстовое поле " + getName());
        getElement().sendKeys(value);
    }

    public String getValue() {
        return BaseElement.getAttribute(VALUE_ATTRIBUTE);
    }
}
