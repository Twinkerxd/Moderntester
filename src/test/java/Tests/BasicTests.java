package Tests;

import Core.BaseSeleniumTests;
import Pages.*;
import Pages.Basic.AlertsPage;
import Pages.Basic.FormPage;
import Pages.Basic.TablePage;
import Pages.Basic.WindowsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Pages.Basic.IframePage.Continents.*;
import static Pages.Basic.IframePage.Frames.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTests extends BaseSeleniumTests {
    private TablePage tablePage = new TablePage();
    private FormPage formPage = new FormPage();
    private AlertsPage alertsPage = new AlertsPage();
    private WindowsPage windowsPage = new WindowsPage();

    @Test
    @DisplayName("iframes")
    public void iframe() {
        new MainPage()
                .openBasicMenu()
                .openIframePage()
                .switchFrameTo(FIRST_FRAME)
                .setFirstNameInput("Michał")
                .setSurnameInput("Nowicki")
                .switchFrameTo(DEFAULT)
                .switchFrameTo(SECOND_FRAME)
                .setLoginInput("Mike")
                .setPasswordInput("secretPassword123")
                .setContinent(AUSTRALIA)
                .setYearOfExp()
                .switchFrameTo(DEFAULT);
    }

    @Test
    public void tables() {
        tablePage = new MainPage().openBasicMenu().getTablePage();
        tablePage.someMethod();
    }

    @Test
    public void form() {
        String actualResult = new MainPage()
                .openBasicMenu()
                .openFormPage()
                .setFirstName("Serega")
                .setLastName("Kekman")
                .setEmail("GrayFaceNoSpace@gmail.com")
                .setRandomSex()
                .setAge(30)
                .setRandomYearOfExperience()
                .setRandomProfessions()
                .setRandomContinentsSelect()
                .setSeleniumCommandsSelector()
                .uploadFile("src/Kappa.txt")
                .setAdditionalInformations("You touch my tralala")
                .clickSignInButton()
                .getValidatorMessage();

        assertEquals("Form send with success", actualResult);

    }

    @Test
    public void simpleAlertPopUp() {
        String actualResult = new MainPage()
                .openBasicMenu()
                .openAlertsPage()
                .clickSimpleAlertButton()
                .clickAcceptOnAlert()
                .getSimpleAlertLabel();

        assertEquals("OK button pressed", actualResult);
    }

    @Test
    public void promptAlertBoxAccept() {
        alertsPage = new MainPage().openBasicMenu().openAlertsPage();
        alertsPage.clickPromptAlertButton();
        alertsPage.waitForAlertToBeReady().sendKeys("Nothing");
        alertsPage.waitForAlertToBeReady().accept();
        assertEquals("Hello Nothing! How are you today?",alertsPage.getPromptLabel());
    }

    @Test
    public void promptAlertBoxDismiss() {
        alertsPage = new MainPage().openBasicMenu().openAlertsPage();
        alertsPage.clickPromptAlertButton();
        alertsPage.waitForAlertToBeReady().dismiss();
        assertEquals("User cancelled the prompt.",alertsPage.getPromptLabel());
    }

    @Test
    public void confirmPopUpAccept() {
        alertsPage = new MainPage().openBasicMenu().openAlertsPage();
        alertsPage.clickConfirmPopUpButton();
        alertsPage.waitForAlertToBeReady().accept();
        assertEquals("You pressed OK!",alertsPage.getConfirmLabel());
    }

    @Test
    public void confirmPopUpDismiss() {
        alertsPage = new MainPage().openBasicMenu().openAlertsPage();
        alertsPage.clickConfirmPopUpButton();
        alertsPage.waitForAlertToBeReady().dismiss();
        assertEquals("You pressed Cancel!",alertsPage.getConfirmLabel());
    }

    @Test
    public void delayedAlert() {
        alertsPage = new MainPage().openBasicMenu().openAlertsPage();
        alertsPage.clickDelayedAlert();
        alertsPage.waitForAlertToBeReady().accept();
        assertEquals("OK button pressed", alertsPage.getDelayedAlertLabel());
    }

    @Test
    public void newWindow() {
        windowsPage = new MainPage().openBasicMenu().getWindowsPage();
        windowsPage.clickWindowButton();
        windowsPage.switchToNewWindowOrTab();
        assertEquals("http://automation-practice.emilos.pl/",windowsPage.getCurrentUrl());
    }

    @Test
    public void newMessageWindow() {
        windowsPage = new MainPage().openBasicMenu().getWindowsPage();
        windowsPage.clickMessageButton();
        windowsPage.switchToNewWindowOrTab();
        assertEquals("Knowledge increases by sharing but not by saving. Please share this website " +
                "with your friends and in your organization.",windowsPage.getBody());
        System.out.println(windowsPage.getBody());
    }

    @Test
    public void newTab() {
        windowsPage = new MainPage().openBasicMenu().getWindowsPage();
        windowsPage.clickTabButton();
        windowsPage.switchToNewWindowOrTab();
    }
}
