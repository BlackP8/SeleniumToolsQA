package test_case4;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import framework.utilities.tab_util.TabUtility;
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
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp", enabled = false)
    public void handlesTest(String urlText, String samplePageText) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        Steps.checkMainPage();

        Log.logTestSteps("Переходим на форму Alerts, затем на форму Browser Windows.");
        Steps.clickAlertsFrameWindowsBtn();
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
        Steps.clickBrowserBtn(alertsWindowsPage);
        BrowserWindowsPage windowsPage = new BrowserWindowsPage();
        AssertSteps.checkForm(windowsPage.isBrowserWindowsPageAppeared());

        Log.logTestSteps("Нажимаем кнопку New tab, открываем новую вкладку.");
        Steps.clickNewTabBtn(windowsPage);
        List<String> listValues = new ArrayList<>();
        listValues.add(urlText);
        listValues.add(samplePageText);
        SamplePage samplePage = new SamplePage();
        TabUtility.changeTab();
        AssertSteps.checkForm(samplePage.isSamplePageAppeared());
        AssertSteps.checkSamplePageText(listValues, samplePage, TabUtility.getTabURL());

        Log.logTestSteps("Закрываем вкладку " + SamplePage.class.getName() + "и переходим на форму "
                + BrowserWindowsPage.class.getName());
        Steps.closeSamplePage();
        AssertSteps.checkForm(windowsPage.isBrowserWindowsPageAppeared());

        Log.logTestSteps(" В левом меню выбираем Elements → Links и переходим на форму Links.");
        Steps.clickLinksButton(windowsPage);
        LinksPage linksPage = new LinksPage();
        AssertSteps.checkForm(linksPage.isLinksPageAppeared());

        Log.logTestSteps("Переходим по ссылке Home, переходим на вкладку главной страницы.");
        Steps.goHomeLink(linksPage);
        Steps.checkMainPage();

        Log.logTestSteps("Переходим на вкладку с формой Links.");
        Log.logTestSteps(LogMessages.CHECK_PAGE.getText() + LinksPage.class.getName());
        Steps.switchOnMainPage();
        AssertSteps.checkForm(linksPage.isLinksPageAppeared());
    }
}
