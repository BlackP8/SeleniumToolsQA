package page_objects;

import framework.elements.Heading;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.tab_util.TabUtility;
import framework.utilities.text_util.TextUtility;

import java.util.List;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class SamplePage {
    private static Heading heading;
    private static final String NEW_TAB_TEXT_PATH = "//*[@id='sampleHeading']";
    private static final String HEADING_NAME = "Sample page";
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public boolean checkPageText(List<String> data) {
        TabUtility.changeTab();
        Log.logPages(CHECK_LOG_TEXT + "текст внутри страницы и url соответствуют ожидаемым.");
        heading = new Heading(NEW_TAB_TEXT_PATH, HEADING_NAME);
        return TextUtility.checkTextContains(heading.getText(), TabUtility.getTabURL(), data) == data.size();
    }
}
