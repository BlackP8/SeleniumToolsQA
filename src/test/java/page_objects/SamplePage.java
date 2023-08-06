package page_objects;

import framework.base.BaseForm;
import framework.elements.Heading;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.text_util.TextUtility;
import org.openqa.selenium.By;

import java.util.List;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class SamplePage extends BaseForm {
    private static Heading samplePageHeading = new Heading(By.id("sampleHeading"), "Sample page");
    private static final By SAMPLE_PAGE_IDENTIFIER = By.id("sampleHeading");
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();

    public SamplePage() {
        super(SAMPLE_PAGE_IDENTIFIER);
    }

    public boolean isSamplePageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + BrowserWindowsPage.class.getName());
        return isPageAppeared();
    }

    public boolean isSamplePageTextCorrect(List<String> data, String tabURL) {
        Log.logPages(CHECK_LOG_TEXT + "текст внутри страницы и url соответствуют ожидаемым.");
        return TextUtility.checkTextContains(samplePageHeading.getText(), tabURL, data) == data.size();
    }
}
