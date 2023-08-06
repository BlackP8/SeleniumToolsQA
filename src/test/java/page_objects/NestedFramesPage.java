package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.iframe_util.IframeUtility;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class NestedFramesPage extends BaseForm {
    private MarkedList framesMenuElement = new MarkedList(By.xpath("//*[@id='item-2']//*[contains(text(), 'Frames')]"),
            "Frames button");
    private static final By NESTED_FRAMES_FORM_IDENTIFIER = By.id("framesWrapper");
    private static final String PARENT_FRAME_ID = "frame1";
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public NestedFramesPage() {
        super(NESTED_FRAMES_FORM_IDENTIFIER);
    }

    public boolean isNestedFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + NestedFramesPage.class.getName());
        return isPageAppeared();
    }

    public boolean isFrameTextCorrect(String expectedParentText, String expectedChildText) {
        Log.logPages(CHECK_LOG_TEXT + "во фреймах присутствуют надписи " + expectedParentText + " и "
                + expectedChildText);
        return expectedParentText.equals(getParentFrameText()) &&
                expectedChildText.equals(new IFramePage().getChildFrameText());
    }

    private String getParentFrameText() {
        IframeUtility.switchToFrame(PARENT_FRAME_ID);
        return new IFramePage().getParentFrameText();
    }

    public void clickFramesMenuBtn() {
        Log.logPages(LOG_TEXT + framesMenuElement.getName());
        framesMenuElement.doClick();
    }
}
