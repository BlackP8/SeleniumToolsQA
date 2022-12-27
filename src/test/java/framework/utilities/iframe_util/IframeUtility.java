package framework.utilities.iframe_util;

import framework.base.BaseElement;
import framework.driver.DriverManager;
import framework.elements.Heading;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class IframeUtility {
    private static String text;
    private static Heading heading;

    public static String getParentText(String id, String cssSelector) {
        DriverManager.getDriver().switchTo().frame(id);
        text = BaseElement.findByCss(cssSelector).getText();
        DriverManager.getDriver().switchTo().defaultContent();
        return text;
    }

    public static String getChildText(String id, String cssSelector, int index) {
        DriverManager.getDriver().switchTo().frame(id);
        DriverManager.getDriver().switchTo().frame(index);
        text = BaseElement.findByCss(cssSelector).getText();
        DriverManager.getDriver().switchTo().defaultContent();
        return text;
    }

    public static String getFramesText(String id, String locator) {
        DriverManager.getDriver().switchTo().frame(id);
        heading = new Heading(locator);
        text = heading.getText();
        DriverManager.getDriver().switchTo().defaultContent();
        return text;
    }
}
