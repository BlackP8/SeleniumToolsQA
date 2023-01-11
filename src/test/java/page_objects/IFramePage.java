package page_objects;

import framework.base.BaseElement;
import framework.elements.Heading;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class IFramePage {
    private static String text;
    private static Heading heading = new Heading("//*[@id='sampleHeading']");
    private static final String PARENT_FRAME_TEXT_PATH = "body";
    private static final String CHILD_FRAME_TEXT_PATH = "p";

    public String getFrameText() {
        heading.findElement();
        text = heading.getText();
        return text;
    }

    public String getParentText() {
        text = BaseElement.findByCss(PARENT_FRAME_TEXT_PATH).getText();
        return text;
    }

    public String getChildText() {
        text = BaseElement.findByCss(CHILD_FRAME_TEXT_PATH).getText();
        return text;
    }
}
