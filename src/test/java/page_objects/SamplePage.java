package page_objects;

import framework.base.BaseForm;
import framework.elements.Heading;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.text_util.TextUtility;

import java.util.List;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class SamplePage extends BaseForm {
    private static Heading samplePageHeading = new Heading("//*[@id='sampleHeading']", "Sample page");

    private static final String SAMPLE_PAGE_IDENTIFIER = "//*[@id='sampleHeading']";
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();

    public boolean isSamplePageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + BrowserWindowsPage.class.getName());
        return BaseForm.isPageAppeared(SAMPLE_PAGE_IDENTIFIER);
    }

    public boolean isSamplePageTextCorrect(List<String> data, String tabURL) {
        Log.logPages(CHECK_LOG_TEXT + "текст внутри страницы и url соответствуют ожидаемым.");
        samplePageHeading.findElement();
        return TextUtility.checkTextContains(samplePageHeading.getText(), tabURL, data) == data.size();
    }
}
