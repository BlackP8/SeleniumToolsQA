package steps;

import framework.logger.Log;
import page_objects.*;

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

    public static void clickAlertsFrameWindowsBtn() {
        Log.logTestSteps("Нажимаем кнопку Alerts, Frame & Windows.");
        mainPage.clickAlertsBtn();
        Log.logTestSteps("Выбираем пункт меню Alerts.");
        alertsWindowsPage.clickAlertsMenuBtn();
    }

    public static void clickSeeAlertBtn() {
        Log.logTestSteps("Нажимаем кнопку \"Click Button to see alert\".");
        alertsPage.clickSeeAlertBtn();
    }

    public static void clickAlertOk() {
        Log.logTestSteps("Нажимаем кнопку Ok во всплывающем окне.");
        alertsPage.clickOk();
    }

    public static void clickConfirmBoxBtn() {
        Log.logTestSteps("Нажимаем кнопку \"On button click, confirm box will appear\".");
        alertsPage.clickConfirmBtn();
    }

    public static void clickPromptBtn() {
        Log.logTestSteps("Нажимаем кнопку \"On button click, prompt box will appear\".");
        alertsPage.clickPromptBtn();
    }

    public static void enterRandomText() {
        Log.logTestSteps("Вводим случайно сгенерированный текст.");
        alertsPage.enterRandomText();
        Log.logTestSteps("Нажимаем кнопку Ok во всплывающем окне.");
        clickAlertOk();
    }

    public static void clickNestedFramesBtn() {
        Log.logTestSteps("Выбираем пункт меню Nested Frames.");
        alertsWindowsPage.clickNestedFramesBtn();
    }

    public static void clickFramesBtn() {
        Log.logTestSteps("Выбираем пункт меню Frames.");
        nestedFramesPage.clickFramesMenuBtn();
    }

    public static void clickBrowserBtn() {
        Log.logTestSteps("Выбираем пункт меню Browser Windows.");
        alertsWindowsPage.clickBrowserWindowsBtn();
    }

    public static void clickNewTabBtn() {
        Log.logTestSteps("Нажимаем кнопку New Tab.");
        windowsPage.clickNewTabBtn();
    }

    public static void closeSamplePage() {
        Log.logTestSteps("Закрываем текущую вкладку.");
        windowsPage.closeTab();
    }

    public static void clickLinksButton() {
        Log.logTestSteps("Выбираем пункт меню Links.");
        windowsPage.clickLinksBtn();
    }

    public static void goHomeLink() {
        Log.logTestSteps("Переходим по ссылке Home.");
        linksPage.clickHomeBtn();
        Log.logTestSteps("Переключаемся на вкладку с главной страницей.");
        linksPage.changeTab();
    }

    public static void switchOnMainPage() {
        Log.logTestSteps("Переключаемся на вкладку с формой Links.");
        mainPage.changeTab();
    }
}
