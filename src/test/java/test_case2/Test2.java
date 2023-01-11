package test_case2;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.annotations.Test;
import page_objects.AlertsWindowsPage;
import page_objects.FramesPage;
import page_objects.MainPage;
import page_objects.NestedFramesPage;
import steps.AssertSteps;
import steps.Steps;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class Test2 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void iframeTest(String parentFrameText, String childFrameText) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        MainPage mainPage = new MainPage();
        AssertSteps.checkMainPage(mainPage);

        Log.logTestSteps("Переходим на форму NestedFrames. Сравниваем надписи во фреймах");
        Steps.clickAlertsFrameWindowsBtn(mainPage);
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
        Steps.clickNestedFramesBtn(alertsWindowsPage);
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        AssertSteps.checkForm(nestedFramesPage.isNestedFormAppeared());
        AssertSteps.checkFrameText(nestedFramesPage, parentFrameText, childFrameText);

        Log.logTestSteps("Переходим на форму Frames. Сравниваем надписи в верхнем и нижнем фрейме.");
        Steps.clickFramesBtn(nestedFramesPage);
        FramesPage framesPage = new FramesPage();
        AssertSteps.checkForm(framesPage.isFramesFormAppeared());
        AssertSteps.compareFramesText(framesPage);
    }
}
