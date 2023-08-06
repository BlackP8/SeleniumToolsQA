package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Span;
import org.openqa.selenium.By;
import table.Table;
import framework.logger.Log;
import framework.logger.LogMessages;
import data_model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class WebTablesPage extends BaseForm {
    private Button addBtn = new Button(By.id("addNewRecordButton"), "Add button");
    private Table usersTable = new Table(By.className("rt-table"));
    private Span deleteBtn;
    private static int usersCount;
    private static List<User> users;
    private static final By WEB_TABLES_PAGE_IDENTIFIER = By.className("web-tables-wrapper");
    private static final String TABLE_ROWS_PATH = "//*[@class='rt-tbody']//*[@class='rt-tr-group']";
    private static final String TABLE_COLUMNS_PATH = "//*[@class='rt-tr']//*[contains(@class,'th')]";
    private static final String TABLE_CELLS_PATH = "//*[@class='rt-tr-group']//*[@class='rt-td']";
    private static final String DELETE_USER_BUTTON_PATH = "//*[@id='delete-record-%s']";
    private static final String DELETE_USER_BUTTON_NAME = "Delete record button";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public WebTablesPage() {
        super(WEB_TABLES_PAGE_IDENTIFIER);
    }

    public boolean isWebTablesFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + WebTablesPage.class.getName());
        return isPageAppeared();
    }

    public void clickAddBtn() {
        Log.logPages(LOG_TEXT + addBtn.getName());
        addBtn.scrollToElement();
        addBtn.doClick();
    }

    public boolean isUserAdded(User user) {
        Log.logPages(CHECK_LOG_TEXT + "пользователь добавлен.");
        boolean result = false;
        users = new ArrayList<>();
        users = usersTable.checkData(TABLE_ROWS_PATH, TABLE_CELLS_PATH, TABLE_COLUMNS_PATH, users);

        if (users.contains(user)) {
            result = true;
            usersCount = users.size();
        }
        return result;
    }

    public void deleteData() {
        deleteBtn = new Span(By.xpath(String.format(DELETE_USER_BUTTON_PATH, usersTable.getIndex())),
                DELETE_USER_BUTTON_NAME);
        Log.logPages(LOG_TEXT + deleteBtn.getName());
        deleteBtn.scrollToElement();
        deleteBtn.doClick();
    }

    public boolean isCountCorrect() {
        Log.logPages("Сравниваем текущее число пользователей таблицы с предыдущим.");
        return usersCount == users.size();
    }
}
