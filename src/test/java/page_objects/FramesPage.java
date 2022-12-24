package page_objects;

import framework.elements.Form;
import framework.utilities.IframeUtility;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class FramesPage {
    private static Form form;
    private static final String FRAMES_FORM_PATH = "//*[@id='framesWrapper']";
    private static final String HEADING_PATH = "//*[@id='sampleHeading']";
    private static final String BIG_FRAME_ID = "frame1";
    private static final String SMALL_FRAME_ID = "frame2";

    public boolean checkFramesForm() {
        form = new Form(FRAMES_FORM_PATH);
        return form.checkDisplayed();
    }

    public boolean compareFramesText() {
        String bigFrameText = IframeUtility.getFramesText(BIG_FRAME_ID, HEADING_PATH);
        String smallFrameText = IframeUtility.getFramesText(SMALL_FRAME_ID, HEADING_PATH);
        return bigFrameText.equals(smallFrameText);
    }
}
