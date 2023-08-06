package test_case2;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.annotations.Test;
import steps.Steps;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class Test2 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void iframeTest(String expParentFrameText, String expChildFrameText) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        Steps.checkMainPage();

        Log.logTestSteps("Переходим на форму NestedFrames. Сравниваем надписи во фреймах");
        Steps.clickAlertsFrameWindowsBtn();
        Steps.clickNestedFramesBtn();
        Steps.checkNestedFramesForm();
        Steps.checkParentChildFramesText(expParentFrameText, expChildFrameText);

        Log.logTestSteps("Переходим на форму Frames. Сравниваем надписи в верхнем и нижнем фрейме.");
        Steps.clickFramesBtn();
        Steps.checkFramesForm();
        Steps.compareFramesText();
    }
}
