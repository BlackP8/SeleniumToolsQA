package framework.elements;

import framework.base.BaseElement;
import framework.logger.Log;
import framework.utilities.wait_util.WaitUtil;

/**
 * @author Pavel Romanov 12.01.2023
 */
public class ProgressBar extends BaseElement {
    private static final String CURRENT_VALUE = "aria-valuenow";

    public ProgressBar(String locator, String name) {
        super(locator, name);
    }

    public boolean isProgressBarStatusCorrect(String value) {
        Log.logElements("Проверка " + getName() + " на загрузку требуемого значения.");
        return WaitUtil.waitForAttribute(getElement(), CURRENT_VALUE, value);
    }
}
