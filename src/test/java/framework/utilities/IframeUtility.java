package framework.utilities;

import framework.base.BaseElement;
import framework.driver.DriverManager2;
import framework.elements.Heading;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class IframeUtility {
    private static String text;
    private static Heading heading;

    public static String getParentText(String id, String cssSelector) {
        DriverManager2.getDriver().switchTo().frame(id);
        text = BaseElement.findByCss(cssSelector).getText();
        DriverManager2.getDriver().switchTo().defaultContent();
        return text;
    }

    public static String getChildText(String id, String cssSelector, int index) {
        DriverManager2.getDriver().switchTo().frame(id);
        DriverManager2.getDriver().switchTo().frame(index);
        text = BaseElement.findByCss(cssSelector).getText();
        DriverManager2.getDriver().switchTo().defaultContent();
        return text;
    }

    public static String getFramesText(String id, String locator) {
        DriverManager2.getDriver().switchTo().frame(id);
        heading = new Heading(locator);
        text = heading.getText();
        DriverManager2.getDriver().switchTo().defaultContent();
        return text;
    }
}
