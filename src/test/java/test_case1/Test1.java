package test_case1;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import framework.utilities.text_util.TextUtility;
import org.testng.annotations.Test;
import page_objects.AlertsPage;
import page_objects.AlertsWindowsPage;
import page_objects.MainPage;
import steps.AssertSteps;
import steps.Steps;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class Test1 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void alertsTest(String alertBtnText, String confirmAlertText, String promptBoxText, String confirmBoxText) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        MainPage mainPage = new MainPage();
        AssertSteps.checkMainPage(mainPage);

        Log.logTestSteps("Переходим на форму Alerts.");
        Steps.clickAlertsFrameWindowsBtn(mainPage);
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
        Steps.clickAlertsMenuBtn(alertsWindowsPage);
        AlertsPage alertsPage = new AlertsPage();
        AssertSteps.checkForm(alertsPage.isAlertsFormAppeared());

        Log.logTestSteps("Нажимаем на кнопку Click Button to see alert.");
        Steps.clickSeeAlertBtn(alertsPage);
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "открыт алерт с текстом " + alertBtnText);
        AssertSteps.checkAlert(alertBtnText);

        Log.logTestSteps("Закрываем алерт.");
        Steps.clickAlertOk();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "алерт закрылся.");
        AssertSteps.checkAlertClosed();

        Log.logTestSteps("Открываем алерт confirm box.");
        Steps.clickConfirmBoxBtn(alertsPage);
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "открыт алерт с текстом " + confirmAlertText);
        AssertSteps.checkAlert(confirmAlertText);

        Log.logTestSteps("Закрываем алерт.");
        Steps.clickAlertOk();
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "алерт закрылся.");
        AssertSteps.checkAlertClosed();
        AssertSteps.checkBtnText(confirmBoxText, alertsPage);

        Log.logTestSteps("Открываем алерт с текстовым полем.");
        Steps.clickPromptBtn(alertsPage);
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "открыт алерт с текстом " + promptBoxText);
        AssertSteps.checkAlert(promptBoxText);

        Log.logTestSteps("Вводим случайный текст и закрываем алерт.");
        String generatedText = TextUtility.generateText();
        Steps.enterRandomText(generatedText);
        Log.logTestSteps(LogMessages.CHECK_WHAT.getText() + "алерт закрылся.");
        AssertSteps.checkAlertClosed();
        AssertSteps.compareAlertText(alertsPage, generatedText);
    }
}
