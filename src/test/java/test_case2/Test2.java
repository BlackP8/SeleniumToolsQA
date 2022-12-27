package test_case2;

import framework.base.BaseTest;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.annotations.Test;
import page_objects.FramesPage;
import page_objects.NestedFramesPage;
import steps.AssertSteps;
import steps.Steps;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class Test2 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void iframeTest(String parentFrameText, String childFrameText) {
        AssertSteps.checkMainPage();

        Steps.clickAlertsFrameWindowsBtn();
        Steps.clickNestedFramesBtn();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        AssertSteps.checkForm(nestedFramesPage.checkNestedForm());
        AssertSteps.checkFrameText(parentFrameText, childFrameText);

        Steps.clickFramesBtn();
        FramesPage framesPage = new FramesPage();
        AssertSteps.checkForm(framesPage.checkFramesForm());
        AssertSteps.compareFramesText();
    }
}
