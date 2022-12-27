package framework.elements;

import framework.base.BaseElement;

/**
 * @author Pavel Romanov 28.12.2022
 */
public class Table extends BaseElement {
    public Table(String locator, String name) {
        super(locator, name);
    }

    public Table(String locator) {
        super(locator);
    }

    public void doSMYTH() {
        for (int i = 0; i < getList().size(); i++) {
            getList().get(i).
        }
    }
}
