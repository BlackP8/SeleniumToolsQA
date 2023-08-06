package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class Link extends BaseElement {

    public Link(By locator, String name) {
        super(locator, name);
    }
}
