package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Span;
import framework.utilities.text_generator.TextGenerator;
import framework.utilities.alert_util.AlertUtil;

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
    private static final String CONFIRM_BOX_BUTTON_PATH = "//*[@id='confirmButton']";
    private static final String CONFIRM_TEXT_PATH = "//*[@id='confirmResult']";
    private static final String PROMPT_BUTTON_PATH = "//*[@id='promtButton']";
    private static final String PROMPT_TEXT_PATH = "//*[@id='promptResult']";

    public void clickConfirmBtn() {
        btn = new Button(CONFIRM_BOX_BUTTON_PATH);
        btn.scrollToElement();
        btn.doClick();
    }

    public void clickPromptBtn() {
        btn = new Button(PROMPT_BUTTON_PATH);
        btn.scrollToElement();
        btn.doClick();
    }

    public boolean checkAlertsForm() {
        return BaseForm.checkPage(ALERTS_FORM_IDENTIFIER);
    }

    public void clickSeeAlertBtn() {
        btn = new Button(SEE_ALERT_BUTTON_PATH);
        btn.doClick();
    }

    public boolean checkAlertText(String expectedText) {
        return AlertUtil.checkAlert(expectedText);
    }

    public void clickOk() {
        AlertUtil.clickAlertOk();
    }

    public boolean checkClosed() {
        return AlertUtil.checkAlertClosed();
    }

    public boolean checkButtonInscription(String expectedText) {
        span = new Span(CONFIRM_TEXT_PATH);
        return expectedText.equals(span.getText());
    }

    public void enterRandomText() {
        generatedText = TextGenerator.generateText();
        AlertUtil.enterText(generatedText);
    }

    public boolean compareText() {
        span = new Span(PROMPT_TEXT_PATH);
        String spanText = span.getText();
        spanText = spanText.replace(optionalText, "");
        return generatedText.equals(spanText);
    }
}
