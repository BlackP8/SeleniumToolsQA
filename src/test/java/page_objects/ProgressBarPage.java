package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.ProgressBar;
import framework.logger.Log;
import framework.logger.LogMessages;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 12.01.2023
 */
public class ProgressBarPage extends BaseForm {
    private Button startStopBtn = new Button(By.id("startStopButton"), "Start button");
    private ProgressBar progressBar = new ProgressBar(By.xpath("//*[@id='progressBar']//*[@role='progressbar']"),
            "Progress bar");
    private static final By PROGRESS_BAR_PAGE_IDENTIFIER = By.id("progressBar");
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public ProgressBarPage() {
        super(PROGRESS_BAR_PAGE_IDENTIFIER);
    }

    public boolean isProgressBarPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + ProgressBarPage.class.getName());
        return isPageAppeared();
    }

    public void clickStartBtn() {
        Log.logPages(LOG_TEXT + startStopBtn.getName());
        startStopBtn.doClick();
    }

    public boolean stopProgressBar(String value) {
        Log.logPages("Останавливаем " + progressBar.getName());
        boolean result = progressBar.isProgressBarStatusCorrect(value);
        startStopBtn.doClick();
        return result;
    }
}
