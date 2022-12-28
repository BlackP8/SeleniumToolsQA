package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Span;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.text_util.TextUtility;
import framework.utilities.alert_util.AlertUtility;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class AlertsPage extends BaseForm {
    private static Button btn;
    private static Span span;
    private static String generatedText;
    private static final String optionalText = "You entered ";
    private static final String ALERTS_FORM_IDENTIFIER = "//*[@id='javascriptAlertsWrapper']";
    private static final String SEE_ALERT_BUTTON_PATH = "//*[@id='alertButton']";
    private static final String SEE_ALERT_BUTTON_NAME = "See alert button";
    private static final String CONFIRM_BOX_BUTTON_PATH = "//*[@id='confirmButton']";
    private static final String CONFIRM_BOX_BUTTON_NAME = "Confirm box button";
    private static final String CONFIRM_TEXT_PATH = "//*[@id='confirmResult']";
    private static final String CONFIRM_TEXT_NAME = "Confirm box text";
    private static final String PROMPT_BUTTON_PATH = "//*[@id='promtButton']";
    private static final String PROMPT_BUTTON_NAME = "Prompt button";
    private static final String PROMPT_TEXT_PATH = "//*[@id='promptResult']";
    private static final String PROMPT_TEXT_NAME = "Prompt box text";
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public void clickConfirmBtn() {
        btn = new Button(CONFIRM_BOX_BUTTON_PATH, CONFIRM_BOX_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }

    public void clickPromptBtn() {
        btn = new Button(PROMPT_BUTTON_PATH, PROMPT_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }

    public boolean checkAlertsForm() {
        Log.logPages(PAGE_LOG_TEXT + AlertsPage.class.getName());
        return BaseForm.checkPage(ALERTS_FORM_IDENTIFIER);
    }

    public void clickSeeAlertBtn() {
        btn = new Button(SEE_ALERT_BUTTON_PATH, SEE_ALERT_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.doClick();
    }

    public boolean checkAlertText(String expectedText) {
        Log.logPages(CHECK_LOG_TEXT + "открыт алерт с текстом " + expectedText);
        return AlertUtility.checkAlert(expectedText);
    }

    public void clickOk() {
        Log.logPages(LOG_TEXT + "Ok в алерте.");
        AlertUtility.clickAlertOk();
    }

    public boolean checkClosed() {
        Log.logPages(CHECK_LOG_TEXT + "алерт закрылся.");
        return AlertUtility.checkAlertClosed();
    }

    public boolean checkButtonInscription(String expectedText) {
        span = new Span(CONFIRM_TEXT_PATH, CONFIRM_TEXT_NAME);
        Log.logPages(CHECK_LOG_TEXT + "что появилась надпись " + expectedText);
        return expectedText.equals(span.getText());
    }

    public void enterRandomText() {
        Log.logPages("Вводим случайно сгенерированный текст в алерт.");
        generatedText = TextUtility.generateText();
        AlertUtility.enterText(generatedText);
    }

    public boolean compareText() {
        span = new Span(PROMPT_TEXT_PATH, PROMPT_TEXT_NAME);
        String spanText = span.getText();
        Log.logPages(CHECK_LOG_TEXT + "появившийся текст соответствует " + generatedText);
        spanText = spanText.replace(optionalText, "");
        return generatedText.equals(spanText);
    }
}
