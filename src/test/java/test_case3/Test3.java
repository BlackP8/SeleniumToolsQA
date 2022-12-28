package test_case3;

import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.annotations.Test;
import page_objects.WebTablesPage;
import steps.AssertSteps;
import steps.Steps;


/**
 * @author Pavel Romanov 25.12.2022
 */
public class Test3 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "userData")
    public void tablesTest(User user) {
        Log.logTestSteps(LogMessages.SWITCH_TO_MAIN.getText());
        AssertSteps.checkMainPage();

        Log.logTestSteps("Переходим на форму Elements, затем на форму Web tables.");
        Steps.clickElementsBtn();
        WebTablesPage webTablesPage = new WebTablesPage();
        AssertSteps.checkForm(webTablesPage.checkWebTablesForm());

        Log.logTestSteps("Открываем форму Registration form.");
        Steps.clickAddBtn();
        AssertSteps.checkRegFormOpened(webTablesPage.checkRegistrationForm());

        Log.logTestSteps("Вводим в форму данные пользователя на нажимаем Submit.");
        Steps.enterUserData(user);
        AssertSteps.checkForm(webTablesPage.checkRegistrationForm());
        AssertSteps.checkUserData(user);

        Log.logTestSteps("Удаляем пользователя из таблицы кнопкой Delete.");
        Steps.deleteUser();
        AssertSteps.checkUserDeleted(user);

    }
}
