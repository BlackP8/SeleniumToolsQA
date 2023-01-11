package steps;

import framework.utilities.alert_util.AlertUtility;
import framework.utilities.tab_util.TabUtility;
import page_objects.*;
import data_model.User;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class Steps {

    public static void clickAlertsMenuBtn(AlertsWindowsPage alertsWindowsPage) {
        alertsWindowsPage.clickAlertsMenuBtn();
    }
    public static void clickAlertsFrameWindowsBtn(MainPage mainPage) {
        mainPage.clickAlertsFramesWindowsBtn();
    }

    public static void clickSeeAlertBtn(AlertsPage alertsPage) {
        alertsPage.clickSeeAlertBtn();
    }

    public static void clickAlertOk() {
        AlertUtility.clickAlertOk();
    }

    public static void clickConfirmBoxBtn(AlertsPage alertsPage) {
        alertsPage.clickConfirmBtn();
    }

    public static void clickPromptBtn(AlertsPage alertsPage) {
        alertsPage.clickPromptBtn();
    }

    public static void enterRandomText(String generatedText) {
        AlertUtility.enterText(generatedText);
        clickAlertOk();
    }

    public static void clickNestedFramesBtn(AlertsWindowsPage alertsWindowsPage) {
        alertsWindowsPage.clickNestedFramesBtn();
    }

    public static void clickFramesBtn(NestedFramesPage nestedFramesPage) {
        nestedFramesPage.clickFramesMenuBtn();
    }

    public static void clickBrowserBtn(AlertsWindowsPage alertsWindowsPage) {
        alertsWindowsPage.clickBrowserWindowsBtn();
    }

    public static void clickNewTabBtn(BrowserWindowsPage windowsPage) {
        windowsPage.clickNewTabBtn();
    }

    public static void closeSamplePage() {
        TabUtility.closeTab();
        TabUtility.switchTab();
    }

    public static void clickLinksButton(BrowserWindowsPage windowsPage) {
        windowsPage.clickLinksBtn();
    }

    public static void goHomeLink(LinksPage linksPage) {
        linksPage.clickHomeBtn();
        TabUtility.changeTab();
    }

    public static void switchOnMainPage() {
        TabUtility.switchTab();
    }

    public static void clickWebElementsBtn(ElementsPage elementsPage) {
        elementsPage.clickWebElementsBtn();
    }

    public static void clickElementsBtn(MainPage mainPage) {
        mainPage.clickElementsBtn();
    }

    public static void clickAddBtn(WebTablesPage webTablesPage) {
        webTablesPage.clickAddBtn();
    }

    public static void enterUserData(User user, RegistrationForm registrationForm) {
        registrationForm.enterData(user);
        registrationForm.clickSubmitBtn();
    }

    public static void deleteUser(WebTablesPage webTablesPage) {
        webTablesPage.deleteData();
    }
}
