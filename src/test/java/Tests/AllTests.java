package Tests;

import Core.BaseSeleniumTests;
import Pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllTests extends BaseSeleniumTests {
    private MainPage mainPage;
    private IframePage iframePage;
    private TablePage tablePage;
    private FormPage formPage;
    private AlertsPage alertsPage;

    @Test
    @DisplayName("iframes")
    public void iframe() {
        mainPage = new MainPage();
        iframePage = new MainPage().getIframePage();

        iframePage.switchToFrame(1);
        iframePage.setFirstNameInput("Michał");
        iframePage.setSurnameInput("Nowicki");

        iframePage.switchToFrame(0);
        iframePage.switchToFrame(2);
        iframePage.setLoginInput("Mike");
        iframePage.setPasswordInput("secretPassword");
        iframePage.continentsSelectorClick();
        iframePage.setContinent(2);
        iframePage.setYearOfExp();

        iframePage.switchToFrame(0);
        mainPage.basicItemClick();
    }

    @Test
    public void tables() {
        tablePage = new MainPage().getTablePage();
        tablePage.someMethod();
    }

    @Test
    public void form() throws InterruptedException {
        formPage = new MainPage().getFormPage();
        formPage.setFirstName("Serega");
        formPage.setLastName("Kekman");
        formPage.setEmail("GrayFaceNoSpace@gmail.com");
        formPage.setRandomSex();
        formPage.setAge("30");
        formPage.setRandomYearOfExperience();
        formPage.setRandomProfessions();
        formPage.setRandomContinentsSelect();
        formPage.setSeleniumCommandsSelector();
        formPage.uploadFile("src/Kappa.txt");
        formPage.setAdditionalInformations("You touch my tralala");
        formPage.clickSignInButton();
        Assertions.assertEquals("Form send with success",formPage.getValidatorMessage());
        Thread.sleep(2000);
    }

    @Test
    public void simpleAlertPopUp() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.clickSimpleAlertButton();
        alertsPage.waitForAlertToBeReady().accept();
        Assertions.assertEquals("OK button pressed", alertsPage.getSimpleAlertLabel());
    }

    @Test
    public void promptAlertBoxAccept() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.clickPromptAlertButton();
        alertsPage.waitForAlertToBeReady().sendKeys("Nothing");
        alertsPage.waitForAlertToBeReady().accept();
        Assertions.assertEquals("Hello Nothing! How are you today?",alertsPage.getPromptLabel());
    }

    @Test
    public void promptAlertBoxDismiss() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.clickPromptAlertButton();
        alertsPage.waitForAlertToBeReady().dismiss();
        Assertions.assertEquals("User cancelled the prompt.",alertsPage.getPromptLabel());
    }

    @Test
    public void confirmPopUpAccept() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.clickConfirmPopUpButton();
        alertsPage.waitForAlertToBeReady().accept();
        Assertions.assertEquals("You pressed OK!",alertsPage.getConfirmLabel());
    }

    @Test
    public void confirmPopUpDismiss() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.clickConfirmPopUpButton();
        alertsPage.waitForAlertToBeReady().dismiss();
        Assertions.assertEquals("You pressed Cancel!",alertsPage.getConfirmLabel());
    }

    @Test
    public void delayedAlert() {
        alertsPage = new MainPage().getAlertsPage();
        alertsPage.clickDelayedAlert();
        alertsPage.waitForAlertToBeReady().accept();
        Assertions.assertEquals("OK button pressed", alertsPage.getDelayedAlertLabel());
    }
}
