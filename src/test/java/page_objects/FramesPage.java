package page_objects;

import framework.base.BaseForm;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.iframe_util.IframeUtility;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class FramesPage extends BaseForm {
    private static final String FRAMES_FORM_IDENTIFIER = "//*[@id='framesWrapper']";
    private static final String HEADING_PATH = "//*[@id='sampleHeading']";
    private static final String BIG_FRAME_ID = "frame1";
    private static final String SMALL_FRAME_ID = "frame2";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public boolean checkFramesForm() {
        Log.logPages(PAGE_LOG_TEXT + FramesPage.class.getName());
        return BaseForm.checkPage(FRAMES_FORM_IDENTIFIER);
    }

    public boolean compareFramesText() {
        Log.logPages(CHECK_LOG_TEXT + "что надпись из верхнего фрейма соответствует надписи из нижнего.");
        String bigFrameText = IframeUtility.getFramesText(BIG_FRAME_ID, HEADING_PATH);
        String smallFrameText = IframeUtility.getFramesText(SMALL_FRAME_ID, HEADING_PATH);
        return bigFrameText.equals(smallFrameText);
    }
}
