package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Span;
import framework.elements.Table;
import framework.logger.Log;
import framework.logger.LogMessages;
import test_case3.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class WebTablesPage extends BaseForm {
    private static Button btn;
    private static int usersCount;
    private static Table table;
    private static Span span;
    private static List<User> users;
    private static final String WEB_TABLES_PAGE_IDENTIFIER = "//*[@class='web-tables-wrapper']";
    private static final String ADD_BUTTON_PATH = "//*[@id='addNewRecordButton']";
    private static final String ADD_BUTTON_NAME = "Add button";
    private static final String REGISTRATION_FROM_IDENTIFIER = "//*[@class='modal-content']";
    private static final String FIRST_NAME_INPUT_PATH = "//*[@id='userForm']//*[@id='firstName']";
    private static final String FIRST_NAME_INPUT_NAME = "First name field";
    private static final String LAST_NAME_INPUT_PATH = "//*[@id='userForm']//*[@id='lastName']";
    private static final String LAST_NAME_INPUT_NAME = "Last name field";
    private static final String EMAIL_INPUT_PATH = "//*[@id='userForm']//*[@id='userEmail']";
    private static final String EMAIL_INPUT_NAME = "Email field";
    private static final String AGE_INPUT_PATH = "//*[@id='userForm']//*[@id='age']";
    private static final String AGE_INPUT_NAME = "Age field";
    private static final String SALARY_INPUT_PATH = "//*[@id='userForm']//*[@id='salary']";
    private static final String SALARY_INPUT_NAME = "Salary field";
    private static final String DEPARTMENT_INPUT_PATH = "//*[@id='userForm']//*[@id='department']";
    private static final String DEPARTMENT_INPUT_NAME = "Department field";
    private static final String SUBMIT_BUTTON_PATH = "//*[@id='userForm']//*[@id='submit']";
    private static final String SUBMIT_BUTTON_NAME = "Submit button";
    private static final String USERS_TABLE_PATH = "//*[@class='rt-table']";
    private static final String TABLE_ROWS_PATH = "//*[@class='rt-tbody']//*[@class='rt-tr-group']";
    private static final String TABLE_COLUMNS_PATH = "//*[@class='rt-tr']//*[contains(@class,'th')]";
    private static final String TABLE_CELLS_PATH = "//*[@class='rt-tr-group']//*[@class='rt-td']";
    private static final String DELETE_BUTTON_PATH = "//*[@id='delete-record-%s']";
    private static final String DELETE_BUTTON_NAME = "Delete user button";
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String CHECK_LOG_TEXT = LogMessages.CHECK_WHAT.getText();

    public boolean checkWebTablesForm() {
        Log.logPages(PAGE_LOG_TEXT + WebTablesPage.class.getName());
        return BaseForm.checkPage(WEB_TABLES_PAGE_IDENTIFIER);
    }

    public void clickAddBtn() {
        btn = new Button(ADD_BUTTON_PATH, ADD_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.scrollToElement();
        btn.doClick();
    }

    public boolean checkRegistrationForm() {
        Log.logPages(PAGE_LOG_TEXT + "Registration form.");
        try {
            return BaseForm.checkPage(REGISTRATION_FROM_IDENTIFIER);
        }
        catch (Exception e) {
            return true;
        }
    }

    public void clickSubmitBtn() {
        btn = new Button(SUBMIT_BUTTON_PATH, SUBMIT_BUTTON_NAME);
        Log.logPages(LOG_TEXT + btn.getName());
        btn.doClick();
    }

    public void enterData(User user) {
        Log.logPages("Заполняем текстовые поля на форме.");
        Input firstNameInput = new Input(FIRST_NAME_INPUT_PATH, FIRST_NAME_INPUT_NAME);
        firstNameInput.enterValue(user.getFirstName());
        Input lastNameInput = new Input(LAST_NAME_INPUT_PATH, LAST_NAME_INPUT_NAME);
        lastNameInput.enterValue(user.getLastName());
        Input emailInput = new Input(EMAIL_INPUT_PATH, EMAIL_INPUT_NAME);
        emailInput.enterValue(user.getEmail());
        Input ageInput = new Input(AGE_INPUT_PATH, AGE_INPUT_NAME);
        ageInput.enterValue(user.getAge());
        Input salaryInput = new Input(SALARY_INPUT_PATH, SALARY_INPUT_NAME);
        salaryInput.enterValue(user.getSalary());
        Input departmentInput = new Input(DEPARTMENT_INPUT_PATH, DEPARTMENT_INPUT_NAME);
        departmentInput.enterValue(user.getDepartment());
    }

    public boolean checkUser(User user) {
        Log.logPages(CHECK_LOG_TEXT + "пользователь добавлен.");
        boolean result = false;
        table = new Table(USERS_TABLE_PATH);
        users = new ArrayList<>();
        users = table.checkData(TABLE_ROWS_PATH, TABLE_CELLS_PATH, TABLE_COLUMNS_PATH, users);

        if (users.contains(user)) {
            result = true;
            usersCount = users.size();
        }
        return result;
    }

    public void deleteData() {
        span = new Span(String.format(DELETE_BUTTON_PATH, table.getIndex()), DELETE_BUTTON_NAME);
        Log.logPages(LOG_TEXT + span.getName());
        span.scrollToElement();
        span.doClick();
    }

    public boolean compareCount() {
        Log.logPages("Сравниваем текущее число пользователей таблицы с предыдущим.");
        return usersCount == users.size();
    }
}
