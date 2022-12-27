package test_case2;

import framework.base.BaseTest;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.AlertsWindowsPage;
import page_objects.FramesPage;
import page_objects.MainPage;
import page_objects.NestedFramesPage;

import java.util.HashMap;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class Test2 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void iframeTest(HashMap<String, String> hashMap) {
//        ConfigManager.setTestData(ConfigManager.getConfProperty("testcase2_data"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkMainPage(), "Главная страница не открылась.");

        mainPage.clickAlertsBtn();
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
        alertsWindowsPage.clickNestedFramesBtn();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.checkNestedForm(),
                "Cтраница с формой Nested Frames не открыта.");

        Assert.assertTrue(nestedFramesPage.checkFrameText(hashMap.get("parentFrameText"), hashMap.get("childFrameText")),
                "В центре страницы отсутствуют надписи \"Parent frame\" и \"Child Iframe\"");

        nestedFramesPage.clickFramesMenuBtn();
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.checkFramesForm(), "Cтраница с формой Frames не открыта.");
        Assert.assertTrue(framesPage.compareFramesText(), "Надпись из верхнего фрейма не соответствует надписи из нижнего.");
    }
}
