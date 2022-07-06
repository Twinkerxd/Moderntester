package Tests;

import Core.BaseSeleniumTests;
import Pages.FormPage;
import Pages.IframePage;
import Pages.MainPage;
import Pages.TablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

public class AllTests extends BaseSeleniumTests {
    private MainPage mainPage;
    private IframePage iframePage;
    private TablePage tablePage;
    private FormPage formPage;

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
}
