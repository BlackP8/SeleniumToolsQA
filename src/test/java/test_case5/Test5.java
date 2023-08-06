package test_case5;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import framework.utilities.text_util.TextUtility;
import org.testng.annotations.Test;
import page_objects.*;
import steps.AssertSteps;
import steps.Steps;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class Test5 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "dp", enabled = false)
    public void handlesTest(String age) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        Steps.checkMainPage();

        Log.logTestSteps("Переходим на форму Slider.");
        Steps.clickWidgetsBtn();
        WidgetsPage widgetsPage = new WidgetsPage();
        Steps.clickSliderBtn(widgetsPage);
        SliderPage sliderPage = new SliderPage();
        AssertSteps.checkForm(sliderPage.isSliderPageAppeared());

        Log.logTestSteps("Устанавливаем слайдеру корректное случайное значение.");
        String randomNumber = String.valueOf(TextUtility.generateNumber());
        Steps.setSlider(sliderPage, randomNumber);
        AssertSteps.checkSliderValue(sliderPage, randomNumber);

        Log.logTestSteps("Переходим на форму Progress bar.");
        Steps.goToProgressBar(sliderPage);
        ProgressBarPage progressBarPage = new ProgressBarPage();
        AssertSteps.checkForm(progressBarPage.isProgressBarPageAppeared());

        Log.logTestSteps("Нажимаем кнопку старта.");
        Steps.clickStart(progressBarPage);
        Log.logTestSteps("Останавиваем полосу загрузки на нужном значении.");
        AssertSteps.checkProgressBar(progressBarPage, age);
    }
}
