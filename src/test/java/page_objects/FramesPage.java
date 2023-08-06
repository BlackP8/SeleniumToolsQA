package page_objects;

import framework.base.BaseForm;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.iframe_util.IframeUtility;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class FramesPage extends BaseForm {
    private static final By FRAMES_FORM_IDENTIFIER = By.id("framesWrapper");
    private static final String BIG_FRAME_ID = "frame1";
    private static final String SMALL_FRAME_ID = "frame2";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();

    public FramesPage() {
        super(FRAMES_FORM_IDENTIFIER);
    }

    public boolean isFramesFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + FramesPage.class.getName());
        return isPageAppeared();
    }

    public String getBigFrameText() {
        IframeUtility.switchToFrame(BIG_FRAME_ID);
        String bigFrameText = new IFramePage().getFrameHeadingText();
        IframeUtility.switchBack();
        return bigFrameText;
    }

    public String getSmallFrameText() {
        IframeUtility.switchToFrame(SMALL_FRAME_ID);
        String smallFrameText = new IFramePage().getFrameHeadingText();
        IframeUtility.switchBack();
        return smallFrameText;
    }
}
