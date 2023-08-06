package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 24.12.2022
 */
public class Heading extends BaseElement {

    public Heading(By locator, String name) {
        super(locator, name);
    }

    public Heading(By locator) {
        super(locator);
    }
}
