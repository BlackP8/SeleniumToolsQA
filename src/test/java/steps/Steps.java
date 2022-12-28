package steps;

import page_objects.*;
import test_case3.User;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class Steps {
    private static MainPage mainPage = new MainPage();
    private static AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
    private static AlertsPage alertsPage = new AlertsPage();
    private static NestedFramesPage nestedFramesPage = new NestedFramesPage();
    private static BrowserWindowsPage windowsPage = new BrowserWindowsPage();
    private static LinksPage linksPage = new LinksPage();
    private static ElementsPage elementsPage = new ElementsPage();
    private static WebTablesPage webTablesPage = new WebTablesPage();

    public static void clickAlertsFrameWindowsBtn() {
        mainPage.clickAlertsBtn();
        alertsWindowsPage.clickAlertsMenuBtn();
    }

    public static void clickSeeAlertBtn() {
        alertsPage.clickSeeAlertBtn();
    }

    public static void clickAlertOk() {
        alertsPage.clickOk();
    }

    public static void clickConfirmBoxBtn() {
        alertsPage.clickConfirmBtn();
    }

    public static void clickPromptBtn() {
        alertsPage.clickPromptBtn();
    }

    public static void enterRandomText() {
        alertsPage.enterRandomText();
        clickAlertOk();
    }

    public static void clickNestedFramesBtn() {
        alertsWindowsPage.clickNestedFramesBtn();
    }

    public static void clickFramesBtn() {
        nestedFramesPage.clickFramesMenuBtn();
    }

    public static void clickBrowserBtn() {
        alertsWindowsPage.clickBrowserWindowsBtn();
    }

    public static void clickNewTabBtn() {
        windowsPage.clickNewTabBtn();
    }

    public static void closeSamplePage() {
        windowsPage.closeTab();
    }

    public static void clickLinksButton() {
        windowsPage.clickLinksBtn();
    }

    public static void goHomeLink() {
        linksPage.clickHomeBtn();
        linksPage.changeTab();
    }

    public static void switchOnMainPage() {
        mainPage.changeTab();
    }

    public static void clickElementsBtn() {
        mainPage.clickElementsBtn();
        elementsPage.clickWebElementsBtn();
    }

    public static void clickAddBtn() {
        webTablesPage.clickAddBtn();
    }

    public static void enterUserData(User user) {
        webTablesPage.enterData(user);
        webTablesPage.clickSubmitBtn();
    }

    public static void deleteUser() {
        webTablesPage.deleteData();
    }
}
