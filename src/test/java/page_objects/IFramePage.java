package page_objects;

import framework.elements.Body;
import framework.elements.Heading;
import framework.elements.Paragraph;
import framework.utilities.iframe_util.IframeUtility;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class IFramePage {
    private Body frameBody = new Body(By.cssSelector("body"));
    private Paragraph frameParagraph = new Paragraph(By.cssSelector("p"));
    private static Heading heading = new Heading(By.id("sampleHeading"));
    private static final int CHILD_FRAME_INDEX = 0;

    public String getFrameHeadingText() {
        return heading.getText();
    }

    public String getChildFrameText() {
        IframeUtility.switchToFrame(CHILD_FRAME_INDEX);
        String childFrameText = frameParagraph.getText();
        IframeUtility.switchBack();
        return childFrameText;
    }

    public String getParentFrameText() {
        return frameBody.getText();
    }
}
