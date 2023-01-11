package test_case3;

import data_model.User;
import framework.base.BaseTest;
import framework.logger.Log;
import framework.logger.LogMessages;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.annotations.Test;
import page_objects.ElementsPage;
import page_objects.MainPage;
import page_objects.RegistrationForm;
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
        MainPage mainPage = new MainPage();
        AssertSteps.checkMainPage(mainPage);

        Log.logTestSteps("Переходим на форму Elements, затем на форму Web tables.");
        Steps.clickElementsBtn(mainPage);
        ElementsPage elementsPage = new ElementsPage();
        Steps.clickWebElementsBtn(elementsPage);
        WebTablesPage webTablesPage = new WebTablesPage();
        AssertSteps.checkForm(webTablesPage.isWebTablesFormAppeared());

        Log.logTestSteps("Открываем форму Registration form.");
        Steps.clickAddBtn(webTablesPage);
        RegistrationForm registrationForm = new RegistrationForm();
        AssertSteps.checkRegFormOpened(registrationForm.isRegistrationFormAppeared());

        Log.logTestSteps("Вводим в форму данные пользователя на нажимаем Submit.");
        Steps.enterUserData(user, registrationForm);
        AssertSteps.checkForm(registrationForm.isRegistrationFormAppeared());
        AssertSteps.checkUserData(user, webTablesPage);

        Log.logTestSteps("Удаляем пользователя из таблицы кнопкой Delete.");
        Steps.deleteUser(webTablesPage);
        AssertSteps.checkUserDeleted(user, webTablesPage);
    }
}
