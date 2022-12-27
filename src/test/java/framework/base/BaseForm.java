package framework.base;

import framework.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class BaseForm {

    public BaseForm() {
    }

    protected static boolean checkPage(String identifier) {
        WebElement expectedEl = DriverManager.getDriver().findElement(By.xpath(identifier));
        return expectedEl.isDisplayed();
    }
}
