package test_case1;

import framework.base.BaseTest;
import framework.logger.Log;
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
        Log.logTestSteps("Выполняем первый шаг.");
        AssertSteps.checkMainPage();

        Log.logTestSteps("Выполняем второй шаг.");
        Steps.clickAlertsFrameWindowsBtn();
        AlertsPage alertsPage = new AlertsPage();
        AssertSteps.checkForm(alertsPage.checkAlertsForm());

        Log.logTestSteps("Выполняем третий шаг.");
        Steps.clickSeeAlertBtn();
        AssertSteps.checkAlert(alertBtnText);

        Log.logTestSteps("Выполняем четвертый шаг.");
        Steps.clickAlertOk();
        AssertSteps.checkAlertClosed();

        Log.logTestSteps("Выполняем пятый шаг.");
        Steps.clickConfirmBoxBtn();
        AssertSteps.checkAlert(confirmAlertText);

        Log.logTestSteps("Выполняем шестой шаг.");
        Steps.clickAlertOk();
        AssertSteps.checkAlertClosed();
        AssertSteps.checkBtnText(confirmBoxText);

        Log.logTestSteps("Выполняем седьмой шаг.");
        Steps.clickPromptBtn();
        AssertSteps.checkAlert(promptBoxText);

        Log.logTestSteps("Выполняем восьмой шаг.");
        Steps.enterRandomText();
        AssertSteps.checkAlertClosed();
        AssertSteps.compareAlertText();
    }
}
