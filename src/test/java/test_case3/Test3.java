package test_case3;

import framework.base.BaseTest;
import framework.utilities.data_provider.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ElementsPage;
import page_objects.MainPage;
import page_objects.WebTablesPage;

import java.util.HashMap;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class Test3 extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "userData")
    public void tablesTest(User user, HashMap<String, String> userData) {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkMainPage(), "Главная страница не открылась.");

        mainPage.clickElementsBtn();
        ElementsPage elementsPage = new ElementsPage();
        elementsPage.clickWebElementsBtn();
        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.checkWebTablesForm(), "Страница с формой WebTables не открылась.");

        webTablesPage.clickAddBtn();
        Assert.assertTrue(webTablesPage.checkRegistrationForm(), "На странице не появилась форма Registrarion Form.");

        webTablesPage.enterData(user);
        webTablesPage.clickSubmitBtn();
        Assert.assertTrue(webTablesPage.checkRegistrationForm(), "Форма регистрации не закрыта.");
        Assert.assertTrue(webTablesPage.checkData(), "Данные пользователя не были добавлены.");
//
//        webTablesPage.deleteData(userData);
    }
}
