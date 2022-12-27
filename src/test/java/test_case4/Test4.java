package test_case4;

import framework.base.BaseTest;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class Test4 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void handlesTest(HashMap<String, String> hashMap) {
//        ConfigManager.setTestData(ConfigManager.getConfProperty("testcase2_data"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkMainPage(), "Главная страница не открылась.");

        mainPage.clickAlertsBtn();
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
        alertsWindowsPage.clickBrowserWindowsBtn();
        BrowserWindowsPage windowsPage = new BrowserWindowsPage();
        Assert.assertTrue(windowsPage.checkBrowserWindowsPage(), "Страница с формой Browser Windows не открылась.");

        windowsPage.clickNewTabBtn();
        List<String> list = new ArrayList<>(hashMap.values());
        SamplePage samplePage = new SamplePage();
        Assert.assertTrue(samplePage.checkPageText(list), "Новая вкладка /sample со страницей sample page не открылась.");

        windowsPage.closeTab();
        Assert.assertTrue(windowsPage.checkBrowserWindowsPage(), "Страница с формой Browser Windows не открылась.");

        windowsPage.clickLinksBtn();
        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.checkLinksPage(), "Страница с формой Links не открыта.");

        linksPage.clickHomeBtn();
        linksPage.changeTab();
        Assert.assertTrue(mainPage.checkMainPage(), "Новая вкладка с главной страницей не открыта.");

        mainPage.changeTab();
        Assert.assertTrue(linksPage.checkLinksPage(), "Страница с формой Links не открыта.");
    }
}
