package page_objects;

import framework.base.BaseForm;
import framework.elements.MarkedList;
import framework.utilities.iframe_util.IframeUtility;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class NestedFramesPage extends BaseForm {
    private static MarkedList listElement;
    private static final String NESTED_FRAMES_FORM_IDENTIFIER = "//*[@id='framesWrapper']";
    private static final String NESTED_FRAME_ID = "frame1";
    private static final String PARENT_FRAME_TEXT_PATH = "body";
    private static final String CHILD_FRAME_TEXT_PATH = "p";
    private static final int CHILD_FRAME_INDEX = 0;
    private static final String FRAMES_MENU_BUTTON_PATH = "//*[@id='item-2']//*[contains(text(), 'Frames')]";
    private static final String FRAMES_MENU_BUTTON_NAME = "Frames button";

    public boolean checkNestedForm() {
        return BaseForm.checkPage(NESTED_FRAMES_FORM_IDENTIFIER);
    }

    public boolean checkFrameText(String expectedParentText, String expectedChildText) {
        String parentText = IframeUtility.getParentText(NESTED_FRAME_ID, PARENT_FRAME_TEXT_PATH);
        String childText = IframeUtility.getChildText(NESTED_FRAME_ID, CHILD_FRAME_TEXT_PATH, CHILD_FRAME_INDEX);
        return expectedParentText.equals(parentText) && expectedChildText.equals(childText);
    }

    public void clickFramesMenuBtn() {
        listElement = new MarkedList(FRAMES_MENU_BUTTON_PATH, FRAMES_MENU_BUTTON_NAME);
        listElement.scrollToElement();
        listElement.doClick();
    }
}
