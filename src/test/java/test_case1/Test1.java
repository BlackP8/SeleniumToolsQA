package test_case1;

import framework.base.BaseTest;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.AlertsPage;
import page_objects.AlertsWindowsPage;
import page_objects.MainPage;

import java.util.HashMap;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class Test1 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp")
    public void alertsTest(HashMap<String, String> hashMap) {
//        ConfigManager.setTestData(ConfigManager.getConfProperty("test_case1_data"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkMainPage(), "Главная страница не открылась.");

        mainPage.clickAlertsBtn();
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
        alertsWindowsPage.clickAlertsMenuBtn();
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.checkAlertsForm(), "Форма Alerts не появилась.");

        alertsPage.clickSeeAlertBtn();
        Assert.assertTrue(alertsPage.checkAlertText(hashMap.get("clickAlertBtnText")),
                "Алерт с текстом \"You clicked a button\" не открылся.");

        alertsPage.clickOk();
        Assert.assertTrue(alertsPage.checkClosed(), "Alert не закрылся.");

        alertsPage.clickConfirmBtn();
        Assert.assertTrue(alertsPage.checkAlertText(hashMap.get("confirmAlertText")),
                "Алерт с текстом \"Do you confirm action?\" не открылся.");

        alertsPage.clickOk();
        Assert.assertTrue(alertsPage.checkClosed(), "Alert не закрылся.");
        Assert.assertTrue(alertsPage.checkButtonInscription(hashMap.get("buttonInscription")),
                "Рядом с кнопкой не появилась надпись \"You selected Ok\"");

        alertsPage.clickPromptBtn();
        Assert.assertTrue(alertsPage.checkAlertText(hashMap.get("promptAlertText")),
                "Алерт с текстом \"Please enter your name\" не открылся.");

        alertsPage.enterRandomText();
        alertsPage.clickOk();
        Assert.assertTrue(alertsPage.checkClosed(), "Alert не закрылся.");
        Assert.assertTrue(alertsPage.compareText(), "Рядом с кнопкой не появилась надпись.");
    }
}
