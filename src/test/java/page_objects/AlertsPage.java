package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Span;
import framework.logger.Log;
import framework.logger.LogMessages;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertsPage extends BaseForm {
    private Button seeAlertBtn = new Button(By.id("alertButton"), "See alert button");
    private Button confirmBoxBtn = new Button(By.id("confirmButton"), "Confirm box button");
    private Button promptBoxBtn = new Button(By.id("promtButton"), "Prompt button");
    private Span confirmBoxBtnText = new Span(By.id("confirmResult"), "Confirm box text");
    private Span promptBoxBtnText = new Span(By.id("promptResult"), "Prompt box text");
    private static final String optionalText = "You entered ";
    private static final By ALERTS_FORM_IDENTIFIER = By.id("javascriptAlertsWrapper");
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public AlertsPage() {
        super(ALERTS_FORM_IDENTIFIER);
    }

    public void clickConfirmBtn() {
        Log.logPages(LOG_TEXT + confirmBoxBtn.getName());
//        confirmBoxBtn.scrollToElement();
        confirmBoxBtn.doClick();
    }

    public void clickPromptBtn() {
        Log.logPages(LOG_TEXT + promptBoxBtn.getName());
//        promptBoxBtn.scrollToElement();
        promptBoxBtn.doClick();
    }

    public boolean isAlertsFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + AlertsPage.class.getName());
        return isPageAppeared();
    }

    public void clickSeeAlertBtn() {
        Log.logPages(LOG_TEXT + seeAlertBtn.getName());
        seeAlertBtn.doClick();
    }

    public boolean isConfirmBoxTextCorrect(String expectedText) {
        Log.logPages(CHECK_LOG_TEXT + "что появилась надпись " + expectedText);
        return expectedText.equals(confirmBoxBtnText.getText());
    }

    public boolean isPromptBoxTextCorrect(String generatedText) {
        Log.logPages(CHECK_LOG_TEXT + "появившийся текст соответствует " + generatedText);
        return generatedText.equals(promptBoxBtnText.getText().replace(optionalText, ""));
    }
}
