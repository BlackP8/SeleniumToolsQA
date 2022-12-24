package page_objects;

import framework.elements.Button;
import framework.elements.Form;
import framework.utilities.IframeUtility;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class NestedFramesPage {
    private static Button btn;
    private static Form form;
    private static final String NESTED_FRAMES_FORM_PATH = "//*[@id='framesWrapper']";
    private static final String NESTED_FRAME_ID = "frame1";
    private static final String PARENT_FRAME_TEXT_PATH = "body";
    private static final String CHILD_FRAME_TEXT_PATH = "p";
    private static final int CHILD_FRAME_INDEX = 0;
    private static final String FRAMES_MENU_BUTTON_PATH = "//*[@id='item-2']//*[contains(text(), 'Frames')]";

    public boolean checkNestedForm() {
        form = new Form(NESTED_FRAMES_FORM_PATH);
        return form.checkDisplayed();
    }

    public boolean checkFrameText(String expectedParentText, String expectedChildText) {
        String parentText = IframeUtility.getParentText(NESTED_FRAME_ID, PARENT_FRAME_TEXT_PATH);
        String childText = IframeUtility.getChildText(NESTED_FRAME_ID, CHILD_FRAME_TEXT_PATH, CHILD_FRAME_INDEX);
        return expectedParentText.equals(parentText) && expectedChildText.equals(childText);
    }

    public void clickFramesMenuBtn() {
        btn = new Button(FRAMES_MENU_BUTTON_PATH);
        btn.scrollToElement();;
        btn.doClick();
    }
}
