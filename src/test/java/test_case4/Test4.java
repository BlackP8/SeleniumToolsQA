package test_case4;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
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
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        AssertSteps.checkMainPage();

        Log.logTestSteps("Переходим на форму Alerts, затем на форму Browser Windows.");
        Steps.clickAlertsFrameWindowsBtn();
        Steps.clickBrowserBtn();
        BrowserWindowsPage windowsPage = new BrowserWindowsPage();
        AssertSteps.checkForm(windowsPage.checkBrowserWindowsPage());

        Log.logTestSteps("Нажимаем кнопку New tab, открываем новую вкладку.");
        Steps.clickNewTabBtn();
        List<String> listValues = new ArrayList<>();
        listValues.add(urlText);
        listValues.add(samplePageText);
        AssertSteps.checkSamplePageText(listValues);

        Log.logTestSteps("Закрываем текущую вкладку, переходим на форму Browser Windows.");
        Steps.closeSamplePage();
        AssertSteps.checkForm(windowsPage.checkBrowserWindowsPage());

        Log.logTestSteps(" В левом меню выбираем Elements → Links и переходим на форму Links.");
        Steps.clickLinksButton();
        LinksPage linksPage = new LinksPage();
        AssertSteps.checkForm(linksPage.checkLinksPage());

        Log.logTestSteps("Переходим по ссылке Home, переходим на вкладку главной страницы.");
        Steps.goHomeLink();
        AssertSteps.checkMainPage();

        Log.logTestSteps("Переходим на вкладку с формой Links.");
        Steps.switchOnMainPage();
        AssertSteps.checkForm(linksPage.checkLinksPage());
    }
}
