package Tests;

import Core.BaseSeleniumTests;
import Pages.MainMenu;
import Pages.Widgets.AccordionPage;
import Pages.Widgets.AutoCompletePage;
import Pages.Widgets.WidgetsMenu;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends BaseSeleniumTests {
    private MainMenu mainPage;
    private WidgetsMenu widgetsMenu;
    private AccordionPage accordionPage;
    private AutoCompletePage autoCompletePage;

    @Test
    public void accordion() {
        accordionPage = new MainMenu().getWidgetsMenu().getAccordionPage();
        accordionPage.clickAccordionElement(2);
        accordionPage.clickAccordionElement(3);
        accordionPage.clickAccordionElement(4);
    }

    @Test
    public void autoComplete() {
        autoCompletePage = new MainMenu().getWidgetsMenu().getAutoCompletePage();
        autoCompletePage.setSearchInput("a");
        autoCompletePage.autoCompleteValue("andreas johnson");
    }
}
