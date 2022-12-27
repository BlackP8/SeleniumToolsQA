package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Table;
import test_case3.User;

import java.util.HashMap;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class WebTablesPage extends BaseForm {
    private static Button btn;
    private static Input input;
    private static Table table;
    private static final String WEB_TABLES_PAGE_IDENTIFIER = "//*[@class='web-tables-wrapper']";
    private static final String ADD_BUTTON_PATH = "//*[@id='addNewRecordButton']";
    private static final String ADD_BUTTON_NAME = "Add button";
    private static final String REGISTRATION_FROM_IDENTIFIER = "//*[@class='modal-content']";
    private static final String FIRST_NAME_INPUT_PATH = "//*[@id='userForm']//*[@id='firstName']";
    private static final String LAST_NAME_INPUT_PATH = "//*[@id='userForm']//*[@id='lastName']";
    private static final String EMAIL_INPUT_PATH = "//*[@id='userForm']//*[@id='userEmail']";
    private static final String AGE_INPUT_PATH = "//*[@id='userForm']//*[@id='age']";
    private static final String SALARY_INPUT_PATH = "//*[@id='userForm']//*[@id='salary']";
    private static final String DEPARTMENT_INPUT_PATH = "//*[@id='userForm']//*[@id='department']";
    private static final String SUBMIT_BUTTON_PATH = "//*[@id='userForm']//*[@id='submit']";
    private static final String SUBMIT_BUTTON_NAME = "Submit button";
    private static final String USERS_TABLE_PATH = "//*[@class='rt-table']";
    private static final String TABLE2 = "//*[@class='rt-tbody']";
    private static final String DELETE_BUTTON_PATH = "//*[@id='delete-record-%s']";

    //*[@class='rt-tbody']//*[@class='rt-tr-group']
    //*[@class='rt-tr-group']//*[@class='rt-td']

    public boolean checkWebTablesForm() {
        return BaseForm.checkPage(WEB_TABLES_PAGE_IDENTIFIER);
    }

    public void clickAddBtn() {
        btn = new Button(ADD_BUTTON_PATH, ADD_BUTTON_NAME);
        btn.scrollToElement();
        btn.doClick();
    }

    public boolean checkRegistrationForm() {
        return BaseForm.checkPage(REGISTRATION_FROM_IDENTIFIER);
    }

    public void clickSubmitBtn() {
        btn = new Button(SUBMIT_BUTTON_PATH, SUBMIT_BUTTON_NAME);
        btn.doClick();
    }

    public void enterData(User user) {
        Input firstNameInput = new Input(FIRST_NAME_INPUT_PATH);
        firstNameInput.enterValue(user.getFirstName());
        Input lastNameInput = new Input(LAST_NAME_INPUT_PATH);
        lastNameInput.enterValue(user.getLastName());
        Input emailInput = new Input(EMAIL_INPUT_PATH);
        emailInput.enterValue(user.getEmail());
        Input ageInput = new Input(AGE_INPUT_PATH);
        ageInput.enterValue(user.getAge());
        Input salaryInput = new Input(SALARY_INPUT_PATH);
        salaryInput.enterValue(user.getSalary());
        Input departmentInput = new Input(DEPARTMENT_INPUT_PATH);
        departmentInput.enterValue(user.getDepartment());
    }

    public boolean checkData() {
        table = new Table(USERS_TABLE_PATH);
        return false;
    }

    public void deleteData(String[] userData) {
        input = new Input(TABLE2);
        String index = String.valueOf(input.deletedIndex(userData));
    }
}
