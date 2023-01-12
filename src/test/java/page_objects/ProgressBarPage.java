package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.ProgressBar;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 12.01.2023
 */
public class ProgressBarPage extends BaseForm {
    private Button startStopBtn = new Button("//*[@id='startStopButton']", "Start button");
    private ProgressBar progressBar = new ProgressBar("//*[@id='progressBar']//*[@role='progressbar']", "Progress bar");

    private static final String PROGRESS_BAR_PAGE_IDENTIFIER = "//*[@id='progressBar']";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();

    public boolean isProgressBarPageAppeared() {
        Log.logPages(PAGE_LOG_TEXT + ProgressBarPage.class.getName());
        return BaseForm.isPageAppeared(PROGRESS_BAR_PAGE_IDENTIFIER);
    }

    public void clickStartBtn() {
        Log.logPages(LOG_TEXT + startStopBtn.getName());
        startStopBtn.findElement();
        startStopBtn.doClick();
    }

    public boolean stopProgressBar(String value) {
        Log.logPages("Останавливаем " + progressBar.getName());
        progressBar.findElement();
        boolean result = progressBar.isProgressBarStatusCorrect(value);
        startStopBtn.findElement();
        startStopBtn.doClick();
        return result;
    }
}
