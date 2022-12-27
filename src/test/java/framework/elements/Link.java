package framework.elements;

import framework.base.BaseElement;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class Link extends BaseElement {
    private static String locator;

    public Link(String locator) {
        super(locator);
    }
}
