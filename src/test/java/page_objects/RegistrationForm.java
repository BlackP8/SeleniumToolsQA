package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Input;
import framework.logger.Log;
import framework.logger.LogMessages;
import data_model.User;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class RegistrationForm extends BaseForm {
    private Button submitBtn = new Button("//*[@id='userForm']//*[@id='submit']", "Submit button");
    private Input firstNameInput = new Input("//*[@id='userForm']//*[@id='firstName']", "First name field");
    private Input lastNameInput = new Input("//*[@id='userForm']//*[@id='lastName']", "Last name field");
    private Input emailInput = new Input("//*[@id='userForm']//*[@id='userEmail']", "Email field");
    private Input ageInput = new Input("//*[@id='userForm']//*[@id='age']", "Age field");
    private Input salaryInput = new Input("//*[@id='userForm']//*[@id='salary']", "Salary field");
    private Input departmentInput = new Input("//*[@id='userForm']//*[@id='department']", "Department field");

    private static final String REGISTRATION_FROM_IDENTIFIER = "//*[@class='modal-content']";
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();

    public boolean isRegistrationFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + "Registration form.");
        try {
            return BaseForm.isPageAppeared(REGISTRATION_FROM_IDENTIFIER);
        }
        catch (Exception e) {
            return true;
        }
    }

    public void clickSubmitBtn() {
        Log.logPages(LOG_TEXT + submitBtn.getName());
        submitBtn.findElement();
        submitBtn.doClick();
    }

    public void enterData(User user) {
        Log.logPages("Заполняем текстовые поля на форме.");
        firstNameInput.findElement();
        firstNameInput.enterValue(user.getFirstName());
        lastNameInput.findElement();
        lastNameInput.enterValue(user.getLastName());
        emailInput.findElement();
        emailInput.enterValue(user.getEmail());
        ageInput.findElement();
        ageInput.enterValue(user.getAge());
        salaryInput.findElement();
        salaryInput.enterValue(user.getSalary());
        departmentInput.findElement();
        departmentInput.enterValue(user.getDepartment());
    }
}
