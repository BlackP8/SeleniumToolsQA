package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.iframe_util.IframeUtility;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class NestedFramesPage extends BaseForm {
    private MarkedList framesMenuElement = new MarkedList("//*[@id='item-2']//*[contains(text(), 'Frames')]",
            "Frames button");
    private static final int CHILD_FRAME_INDEX = 0;
    private static final String NESTED_FRAMES_FORM_IDENTIFIER = "//*[@id='framesWrapper']";
    private static final String NESTED_FRAME_ID = "frame1";
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public boolean isNestedFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + NestedFramesPage.class.getName());
        return BaseForm.isPageAppeared(NESTED_FRAMES_FORM_IDENTIFIER);
    }

    public boolean isFrameTextCorrect(String expectedParentText, String expectedChildText) {
        Log.logPages(CHECK_LOG_TEXT + "во фреймах присутствуют надписи " + expectedParentText + " и "
                + expectedChildText);
        IframeUtility.switchToFrame(NESTED_FRAME_ID);
        IFramePage parentFrame = new IFramePage();
        String parentText = parentFrame.getParentText();
        IframeUtility.switchToFrame(CHILD_FRAME_INDEX);
        String childText = parentFrame.getChildText();
        IframeUtility.switchBack();

        return expectedParentText.equals(parentText) && expectedChildText.equals(childText);
    }

    public void clickFramesMenuBtn() {
        Log.logPages(LOG_TEXT + framesMenuElement.getName());
        framesMenuElement.findElement();
        framesMenuElement.scrollToElement();
        framesMenuElement.doClick();
    }
}
