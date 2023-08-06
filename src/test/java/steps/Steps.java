package steps;

import framework.utilities.tab_util.TabUtility;
import org.testng.Assert;
import page_objects.*;
import data_model.User;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class Steps {
    private static MainPage mainPage = new MainPage();
    private static AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
    private static AlertsPage alertsPage = new AlertsPage();
    private static NestedFramesPage nestedFramesPage = new NestedFramesPage();
    private static FramesPage framesPage = new FramesPage();

    public static void checkMainPage() {
        Assert.assertTrue(mainPage.isMainPageAppeared(), "Главная страница не открылась.");
    }

    public static void checkAlertForm() {
        Assert.assertTrue(alertsPage.isAlertsFormAppeared(), "Требуемая форма не открылась.");
    }

    public static void checkNestedFramesForm() {
        Assert.assertTrue(nestedFramesPage.isNestedFormAppeared(), "Требуемая форма не открылась.");
    }

    public static void checkFramesForm() {
        Assert.assertTrue(framesPage.isFramesFormAppeared(), "Требуемая форма не открылась.");
    }

    public static void compareFramesText() {
        Assert.assertTrue(framesPage.getBigFrameText().equals(framesPage.getSmallFrameText()),
                "Надпись из верхнего фрейма не соответствует надписи из нижнего.");
    }

    public static void checkParentChildFramesText(String expParentFrameText, String expChildFrameText) {
        Assert.assertTrue(nestedFramesPage.isFrameTextCorrect(expParentFrameText, expChildFrameText),
                "В центре страницы отсутствуют надписи" + expParentFrameText + " и " + expChildFrameText + ".");
    }

    public static void clickAlertsMenuBtn() {
        alertsWindowsPage.clickAlertsMenuBtn();
    }
    public static void clickAlertsFrameWindowsBtn() {
        mainPage.clickAlertsFramesWindowsBtn();
    }

    public static void clickSeeAlertBtn() {
        alertsPage.clickSeeAlertBtn();
    }

    public static void clickConfirmBoxBtn() {
        alertsPage.clickConfirmBtn();
    }

    public static void checkBtnText(String expectedText) {
        Assert.assertTrue(alertsPage.isConfirmBoxTextCorrect(expectedText),
                "Рядом с кнопкой не появилась надпись " + expectedText + ".");
    }

    public static void clickPromptBtn() {
        alertsPage.clickPromptBtn();
    }

    public static void compareAlertText(String generatedText) {
        Assert.assertTrue(alertsPage.isPromptBoxTextCorrect(generatedText), "Рядом с кнопкой не появилась надпись.");
    }

    public static void checkAlertText(boolean actualResult) {
        Assert.assertTrue(actualResult, "Алерт с текстом не открылся.");
    }

    public static void checkAlertClosed(boolean actualResult) {
        Assert.assertTrue(actualResult, "Alert не закрылся.");
    }

    public static void clickNestedFramesBtn() {
        alertsWindowsPage.clickNestedFramesBtn();
    }

    public static void clickFramesBtn() {
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

    public static void clickElementsBtn() {
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

    public static void clickWidgetsBtn() {
        mainPage.clickWidgetsBtn();
    }

    public static void clickSliderBtn(WidgetsPage widgetsPage) {
        widgetsPage.clickSliderBtn();
    }

    public static void setSlider(SliderPage sliderPage, String randomNumber) {
        sliderPage.moveSlider(randomNumber);
    }

    public static void goToProgressBar(SliderPage sliderPage) {
        sliderPage.clickProgressBarBtn();
    }

    public static void clickStart(ProgressBarPage progressBarPage) {
        progressBarPage.clickStartBtn();
    }
}
