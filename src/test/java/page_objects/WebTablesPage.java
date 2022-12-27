package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Input;

/**
 * @author Pavel Romanov 25.12.2022
 */
public class WebTablesPage extends BaseForm {
    private static Button btn;
    private static Input input;
    private static final String WEB_TABLES_PAGE_IDENTIFIER = "//*[@class='web-tables-wrapper']";
    private static final String ADD_BUTTON_PATH = "//*[@id='addNewRecordButton']";
    private static final String REGISTRATION_FROM_IDENTIFIER = "//*[@class='modal-content']";
    private static final String INPUTS = "//*[@id='userForm']//input";
    private static final String SUBMIT_BUTTON_PATH = "//*[@id='userForm']//*[@id='submit']";
    private static final String TABLE = "//*[@class='rt-tr-group']";
    private static final String TABLE2 = "//*[@class='rt-tbody']";
    private static final String DELETE_BUTTON_PATH = "//*[@id='delete-record-%s']";

    public boolean checkWebTablesForm() {
        return BaseForm.checkPage(WEB_TABLES_PAGE_IDENTIFIER);
    }

    public void clickAddBtn() {
        btn = new Button(ADD_BUTTON_PATH);
        btn.doClick();
    }

    public boolean checkRegistrationForm() {
        return BaseForm.checkPage(REGISTRATION_FROM_IDENTIFIER);
    }

    public void clickSubmitBtn() {
        btn = new Button(SUBMIT_BUTTON_PATH);
        btn.doClick();
    }

    public void enterData(String[] userData) {
        input = new Input(INPUTS);
        input.enterMultipleValues(userData);
    }

    public boolean checkData(String[] userData) {
        input = new Input(TABLE);
        return input.enterMasdalues(userData);
    }

    public void deleteData(String[] userData) {
        input = new Input(TABLE2);
        String index = String.valueOf(input.deletedIndex(userData));
        btn = new Button(String.format(DELETE_BUTTON_PATH, index));
        btn.doClick();
    }
}
