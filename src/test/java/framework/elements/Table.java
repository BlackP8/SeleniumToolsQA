package framework.elements;

import framework.base.BaseElement;
import framework.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_case3.User;

import java.util.List;

/**
 * @author Pavel Romanov 28.12.2022
 */
public class Table extends BaseElement {
    private static int index;
    private static List<WebElement> rowsList;

    public Table(String locator, String name) {
        super(locator, name);
    }

    public Table(String locator) {
        super(locator);
    }

    public List<User> checkData(String rowsLocator, String columnsLocator, String cellsLocator, List<User> users) {
        Log.logElements("Перенос данных из таблицы в список.");
        rowsList = getElement().findElements(By.xpath(rowsLocator));
        List<WebElement> columnsList = getElement().findElements(By.xpath(cellsLocator));
        String[] rowValues = new String[columnsList.size()];
        List<WebElement> cellsList = getElement().findElements(By.xpath(columnsLocator));
        int count = rowsList.size() * columnsList.size();
        int cellIndex = 0;

        for (int i = 0; i < rowsList.size(); i++) {
            for (int j = 0; j < columnsList.size(); j++) {
                cellIndex = rowsList.size() * columnsList.size() - (count - cellIndex);
                if((!cellsList.get(cellIndex).getText().equals("")) && (!cellsList.get(cellIndex).getText().equals(" "))) {
                    rowValues[j] = cellsList.get(cellIndex).getText();
                }
                cellIndex++;
            }
            User user = new User();
            user.setFirstName(rowValues[0]);
            user.setLastName(rowValues[1]);
            user.setAge(rowValues[2]);
            user.setEmail(rowValues[3]);
            user.setSalary(rowValues[4]);
            user.setDepartment(rowValues[5]);
            if (!users.contains(user)) {
                users.add(user);
                index = i + 1;
            }
        }
        return users;
    }

    public int getIndex() {
        Log.logElements("Получение индекса элемента.");
        return index;
    }

}
