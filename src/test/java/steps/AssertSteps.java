package steps;

import framework.utilities.alert_util.AlertUtility;
import org.testng.Assert;
import page_objects.*;
import data_model.User;

import java.util.List;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class AssertSteps {

    public static void checkForm(boolean checkResult) {
        Assert.assertTrue(checkResult, "Требуемая форма не открылась.");
    }

    public static void checkRegFormOpened(boolean checkResult) {
        Assert.assertTrue(checkResult, "На странице не появилась форма Registrarion Form.");
    }

    public static void checkSamplePageText(List<String> data, SamplePage samplePage, String tabURL) {
        Assert.assertTrue(samplePage.isSamplePageTextCorrect(data, tabURL),
                "Новая вкладка /sample со страницей sample page не открылась.");
    }

    public static void checkUserData(User user, WebTablesPage webTablesPage) {
        Assert.assertTrue(webTablesPage.isUserAdded(user), "Данные пользователя не были добавлены.");
    }

    public static void checkUserDeleted(User user, WebTablesPage webTablesPage) {
        Assert.assertFalse(webTablesPage.isUserAdded(user), "Пользователь User № не удалился из таблицы");
        Assert.assertFalse(webTablesPage.isCountCorrect(), "Количество записей в таблице не изменилось.");
    }

    public static void checkSliderValue(SliderPage sliderPage, String randomNumber) {
        Assert.assertTrue(sliderPage.isSliderValueCorrect(randomNumber),
                "Значение рядом со слайдером не соответствует случайному.");
    }

    public static void checkProgressBar(ProgressBarPage progressBarPage, String value) {
        Assert.assertTrue(progressBarPage.stopProgressBar(value),
                "Значение на полосе загрузки не соответствует возрасту инженера.");
    }
}
