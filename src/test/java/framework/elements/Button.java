package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class Button extends BaseElement {

    public Button(By locator, String name) {
        super(locator, name);
    }
}
