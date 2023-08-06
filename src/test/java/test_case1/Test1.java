package test_case1;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.alert_util.AlertUtility;
import framework.utilities.data_provider.DataProviderUtil;
import framework.utilities.text_util.TextUtility;
import org.testng.annotations.Test;
import steps.Steps;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class Test1 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void alertsTest(String alertBtnText, String confirmAlertText, String promptBoxText, String confirmBoxText) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        Steps.checkMainPage();

        Log.logTestSteps("Переходим на форму Alerts.");
        Steps.clickAlertsFrameWindowsBtn();
        Steps.clickAlertsMenuBtn();
        Steps.checkAlertForm();

        Log.logTestSteps("Нажимаем на кнопку Click Button to see alert.");
        Steps.clickSeeAlertBtn();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "открыт алерт с текстом " + alertBtnText);
        Steps.checkAlertText(AlertUtility.isAlertTextCorrect(alertBtnText));

        Log.logTestSteps("Закрываем алерт.");
        AlertUtility.clickAlertOk();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "алерт закрылся.");
        Steps.checkAlertClosed(AlertUtility.isAlertClosed());

        Log.logTestSteps("Открываем алерт confirm box.");
        Steps.clickConfirmBoxBtn();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "открыт алерт с текстом " + confirmAlertText);
        Steps.checkAlertText(AlertUtility.isAlertTextCorrect(confirmAlertText));

        Log.logTestSteps("Закрываем алерт.");
        AlertUtility.clickAlertOk();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "алерт закрылся.");
        Steps.checkAlertClosed(AlertUtility.isAlertClosed());
        Steps.checkBtnText(confirmBoxText);

        Log.logTestSteps("Открываем алерт с текстовым полем.");
        Steps.clickPromptBtn();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "открыт алерт с текстом " + promptBoxText);
        Steps.checkAlertText(AlertUtility.isAlertTextCorrect(promptBoxText));

        Log.logTestSteps("Вводим случайный текст и закрываем алерт.");
        String generatedText = TextUtility.generateText();
        AlertUtility.enterText(generatedText);
        AlertUtility.clickAlertOk();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "алерт закрылся.");
        Steps.checkAlertClosed(AlertUtility.isAlertClosed());
        Steps.compareAlertText(generatedText);
    }
}
