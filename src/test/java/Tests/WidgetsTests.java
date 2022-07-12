package Tests;

import Core.BaseSeleniumTests;
import Pages.MainMenu;
import Pages.Widgets.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends BaseSeleniumTests {
    private AccordionPage accordionPage;
    private AutoCompletePage autoCompletePage;
    private DataPickerPage dataPickerPage;
    private ToolTipPage toolTipPage;

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

    @Test
    public void datePicker() throws InterruptedException {
        dataPickerPage = new MainMenu().getWidgetsMenu().getDataPickerPage();
        dataPickerPage.setDataPickerDay("13");
        Thread.sleep(1000);
    }

    @Test
    public void toolTip() {
        toolTipPage = new MainMenu().getWidgetsMenu().getToolTipPage();
        toolTipPage.getToolTipText();
        System.out.println(toolTipPage.getToolTipText());
    }

    @Test
    public void modalDialog() {
        String name = "Serega";
        String email = "example@gmail.com";
        String password = "qweqwe";

        ModalDialogPage modalDialogPage = new MainMenu()
                .getWidgetsMenu()
                .getModalDialogPage();

        modalDialogPage.clickNewUserButton();
        modalDialogPage.addLine(name,email,password);
        modalDialogPage.clickCreateAccountButton();

        Assertions.assertEquals(name,modalDialogPage.getName(2));
        Assertions.assertEquals(email,modalDialogPage.getEmail(2));
        Assertions.assertEquals(password,modalDialogPage.getPassword(2));
    }
}
