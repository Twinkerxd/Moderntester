package Tests;

import Core.BaseSeleniumTests;
import Pages.IframePage;
import Pages.MainPage;
import Pages.TablePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllTests extends BaseSeleniumTests {
    private MainPage mainPage;
    private IframePage iframePage;
    private TablePage tablePage;

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
    }
}
