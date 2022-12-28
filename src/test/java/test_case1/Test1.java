package test_case1;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.annotations.Test;
import page_objects.AlertsPage;
import steps.AssertSteps;
import steps.Steps;


/**
 * @author Pavel Romanov 22.12.2022
 */
public class Test1 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void alertsTest(String alertBtnText, String confirmAlertText, String promptBoxText, String confirmBoxText) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        AssertSteps.checkMainPage();

        Log.logTestSteps("Переходим на форму Alerts.");
        Steps.clickAlertsFrameWindowsBtn();
        AlertsPage alertsPage = new AlertsPage();
        AssertSteps.checkForm(alertsPage.checkAlertsForm());

        Log.logTestSteps("Нажимаем на кнопку Click Button to see alert.");
        Steps.clickSeeAlertBtn();
        AssertSteps.checkAlert(alertBtnText);

        Log.logTestSteps("Закрываем алерт.");
        Steps.clickAlertOk();
        AssertSteps.checkAlertClosed();

        Log.logTestSteps("Открываем алерт confirm box.");
        Steps.clickConfirmBoxBtn();
        AssertSteps.checkAlert(confirmAlertText);

        Log.logTestSteps("Закрываем алерт.");
        Steps.clickAlertOk();
        AssertSteps.checkAlertClosed();
        AssertSteps.checkBtnText(confirmBoxText);

        Log.logTestSteps("Открываем алерт с текстовым полем.");
        Steps.clickPromptBtn();
        AssertSteps.checkAlert(promptBoxText);

        Log.logTestSteps("Вводим случайный текст и закрываем алерт.");
        Steps.enterRandomText();
        AssertSteps.checkAlertClosed();
        AssertSteps.compareAlertText();
    }
}
