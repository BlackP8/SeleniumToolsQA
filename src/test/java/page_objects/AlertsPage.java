package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Span;
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

    public void clickConfirmBtn() {
        btn = new Button(CONFIRM_BOX_BUTTON_PATH, CONFIRM_BOX_BUTTON_NAME);
        btn.scrollToElement();
        btn.doClick();
    }

    public void clickPromptBtn() {
        btn = new Button(PROMPT_BUTTON_PATH, PROMPT_BUTTON_NAME);
        btn.scrollToElement();
        btn.doClick();
    }

    public boolean checkAlertsForm() {
        return BaseForm.checkPage(ALERTS_FORM_IDENTIFIER);
    }

    public void clickSeeAlertBtn() {
        btn = new Button(SEE_ALERT_BUTTON_PATH, SEE_ALERT_BUTTON_NAME);
        btn.doClick();
    }

    public boolean checkAlertText(String expectedText) {
        return AlertUtility.checkAlert(expectedText);
    }

    public void clickOk() {
        AlertUtility.clickAlertOk();
    }

    public boolean checkClosed() {
        return AlertUtility.checkAlertClosed();
    }

    public boolean checkButtonInscription(String expectedText) {
        span = new Span(CONFIRM_TEXT_PATH, CONFIRM_TEXT_NAME);
        return expectedText.equals(span.getText());
    }

    public void enterRandomText() {
        generatedText = TextUtility.generateText();
        AlertUtility.enterText(generatedText);
    }

    public boolean compareText() {
        span = new Span(PROMPT_TEXT_PATH, PROMPT_TEXT_NAME);
        String spanText = span.getText();
        spanText = spanText.replace(optionalText, "");
        return generatedText.equals(spanText);
    }
}
