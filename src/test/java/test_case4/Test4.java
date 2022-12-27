package test_case4;

import framework.base.BaseTest;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.annotations.Test;
import page_objects.*;
import steps.AssertSteps;
import steps.Steps;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class Test4 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void handlesTest(String urlText, String samplePageText) {
        AssertSteps.checkMainPage();

        Steps.clickAlertsFrameWindowsBtn();
        Steps.clickBrowserBtn();
        BrowserWindowsPage windowsPage = new BrowserWindowsPage();
        AssertSteps.checkForm(windowsPage.checkBrowserWindowsPage());

        Steps.clickNewTabBtn();
        List<String> listValues = new ArrayList<>();
        listValues.add(urlText);
        listValues.add(samplePageText);
        AssertSteps.checkSamplePageText(listValues);

        Steps.closeSamplePage();
        AssertSteps.checkForm(windowsPage.checkBrowserWindowsPage());

        Steps.clickLinksButton();
        LinksPage linksPage = new LinksPage();
        AssertSteps.checkForm(linksPage.checkLinksPage());

        Steps.goHomeLink();
        AssertSteps.checkMainPage();

        Steps.switchOnMainPage();
        AssertSteps.checkForm(linksPage.checkLinksPage());
    }
}
