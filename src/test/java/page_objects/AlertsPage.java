package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Span;
import framework.logger.Log;
import framework.logger.LogMessages;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertsPage extends BaseForm {
    private Button seeAlertBtn = new Button("//*[@id='alertButton']", "See alert button");
    private Button confirmBoxBtn = new Button("//*[@id='confirmButton']", "Confirm box button");
    private Button promptBoxBtn = new Button("//*[@id='promtButton']", "Prompt button");
    private Span confirmBoxBtnText = new Span("//*[@id='confirmResult']", "Confirm box text");
    private Span promptBoxBtnText = new Span("//*[@id='promptResult']", "Prompt box text");

    private static final String optionalText = "You entered ";
    private static final String ALERTS_FORM_IDENTIFIER = "//*[@id='javascriptAlertsWrapper']";
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public void clickConfirmBtn() {
        Log.logPages(LOG_TEXT + confirmBoxBtn.getName());
        confirmBoxBtn.findElement();
        confirmBoxBtn.scrollToElement();
        confirmBoxBtn.doClick();
    }

    public void clickPromptBtn() {
        Log.logPages(LOG_TEXT + promptBoxBtn.getName());
        promptBoxBtn.findElement();
        promptBoxBtn.scrollToElement();
        promptBoxBtn.doClick();
    }

    public boolean isAlertsFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + AlertsPage.class.getName());
        return BaseForm.isPageAppeared(ALERTS_FORM_IDENTIFIER);
    }

    public void clickSeeAlertBtn() {
        Log.logPages(LOG_TEXT + seeAlertBtn.getName());
        seeAlertBtn.findElement();
        seeAlertBtn.doClick();
    }

    public boolean isConfirmBoxTextCorrect(String expectedText) {
        Log.logPages(CHECK_LOG_TEXT + "что появилась надпись " + expectedText);
        confirmBoxBtnText.findElement();
        return expectedText.equals(confirmBoxBtnText.getText());
    }

    public boolean isPromptBoxTextCorrect(String generatedText) {
        promptBoxBtnText.findElement();
        String spanText = promptBoxBtnText.getText();
        Log.logPages(CHECK_LOG_TEXT + "появившийся текст соответствует " + generatedText);
        spanText = spanText.replace(optionalText, "");
        return generatedText.equals(spanText);
    }
}
