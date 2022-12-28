package steps;

import org.testng.Assert;
import page_objects.*;
import test_case3.User;

import java.util.List;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class AssertSteps {
    private static MainPage mainPage = new MainPage();
    private static AlertsPage alertsPage = new AlertsPage();
    private static NestedFramesPage nestedFramesPage = new NestedFramesPage();
    private static FramesPage framesPage = new FramesPage();
    private static SamplePage samplePage = new SamplePage();
    private static WebTablesPage webTablesPage = new WebTablesPage();

    public static void checkForm(boolean checkResult) {
        Assert.assertTrue(checkResult, "Требуемая форма не открылась.");
    }

    public static void checkMainPage() {
        Assert.assertTrue(mainPage.checkMainPage(), "Главная страница не открылась.");
    }

    public static void checkRegFormOpened(boolean checkResult) {
        Assert.assertTrue(checkResult, "На странице не появилась форма Registrarion Form.");
    }

    public static void checkAlert(String expectedText) {
        Assert.assertTrue(alertsPage.checkAlertText(expectedText),
                "Алерт с текстом " + expectedText +" не открылся.");
    }

    public static void checkAlertClosed() {
        Assert.assertTrue(alertsPage.checkClosed(), "Alert не закрылся.");
    }

    public static void checkBtnText(String expectedText) {
        Assert.assertTrue(alertsPage.checkButtonInscription(expectedText),
                "Рядом с кнопкой не появилась надпись " + expectedText + ".");
    }

    public static void compareAlertText() {
        Assert.assertTrue(alertsPage.compareText(), "Рядом с кнопкой не появилась надпись.");
    }

    public static void checkFrameText(String parentFrameText, String childFrameText) {
        Assert.assertTrue(nestedFramesPage.checkFrameText(parentFrameText, childFrameText),
                "В центре страницы отсутствуют надписи" + parentFrameText + " и " + childFrameText + ".");
    }

    public static void compareFramesText() {
        Assert.assertTrue(framesPage.compareFramesText(),
                "Надпись из верхнего фрейма не соответствует надписи из нижнего.");
    }

    public static void checkSamplePageText(List<String> data) {
        Assert.assertTrue(samplePage.checkPageText(data), "Новая вкладка /sample со страницей sample page не открылась.");
    }

    public static void checkUserData(User user) {
        Assert.assertTrue(webTablesPage.checkUser(user), "Данные пользователя не были добавлены.");
    }

    public static void checkUserDeleted(User user) {
        Assert.assertFalse(webTablesPage.checkUser(user), "Пользователь User № не удалился из таблицы");
        Assert.assertFalse(webTablesPage.compareCount(), "Количество записей в таблице не изменилось.");
    }
}
