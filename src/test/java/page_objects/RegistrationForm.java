package page_objects;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Input;
import framework.logger.Log;
import framework.logger.LogMessages;
import data_model.User;
import org.openqa.selenium.By;

/**
 * @author Pavel Romanov 11.01.2023
 */
public class RegistrationForm extends BaseForm {
    private Button submitBtn = new Button(By.xpath("//*[@id='userForm']//*[@id='submit']"), "Submit button");
    private Input firstNameInput = new Input(By.xpath("//*[@id='userForm']//*[@id='firstName']"),
            "First name field");
    private Input lastNameInput = new Input(By.xpath("//*[@id='userForm']//*[@id='lastName']"),
            "Last name field");
    private Input emailInput = new Input(By.xpath("//*[@id='userForm']//*[@id='userEmail']"), "Email field");
    private Input ageInput = new Input(By.xpath("//*[@id='userForm']//*[@id='age']"), "Age field");
    private Input salaryInput = new Input(By.xpath("//*[@id='userForm']//*[@id='salary']"), "Salary field");
    private Input departmentInput = new Input(By.xpath("//*[@id='userForm']//*[@id='department']"), "Department field");

    private static final By REGISTRATION_FROM_IDENTIFIER = By.className("modal-content");
    private static final String LOG_TEXT = LogMessages.PRESS_BUTTON.getText();
    private static final String PAGE_LOG_TEXT = LogMessages.CHECK_PAGE.getText();

    public RegistrationForm() {
        super(REGISTRATION_FROM_IDENTIFIER);
    }

    public boolean isRegistrationFormAppeared() {
        Log.logPages(PAGE_LOG_TEXT + "Registration form.");
        try {
            return isPageAppeared();
        }
        catch (Exception e) {
            return true;
        }
    }

    public void clickSubmitBtn() {
        Log.logPages(LOG_TEXT + submitBtn.getName());
        submitBtn.doClick();
    }

    public void enterData(User user) {
        Log.logPages("Заполняем текстовые поля на форме.");
        firstNameInput.enterValue(user.getFirstName());
        lastNameInput.enterValue(user.getLastName());
        emailInput.enterValue(user.getEmail());
        ageInput.enterValue(user.getAge());
        salaryInput.enterValue(user.getSalary());
        departmentInput.enterValue(user.getDepartment());
    }
}
