package page_objects;

import framework.elements.Heading;
import framework.utilities.iframe_util.IframeUtility;

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
        return IframeUtility.getFrameText(PARENT_FRAME_TEXT_PATH);
    }

    public String getChildText() {
        return IframeUtility.getFrameText(CHILD_FRAME_TEXT_PATH);
    }
}
