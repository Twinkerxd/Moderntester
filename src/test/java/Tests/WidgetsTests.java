package Tests;

import Core.BaseSeleniumTests;
import Pages.MainMenu;
import Pages.Widgets.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.DataProvider;

import java.util.stream.Stream;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @ParameterizedTest(name = "Modal dialog {index}")
    @MethodSource("myDataProvider")
    public void modalDialog(String name, String email, String password, int id) {
        ModalDialogPage modalDialogPage = new MainMenu()
                .getWidgetsMenu()
                .getModalDialogPage();

        modalDialogPage.clickNewUserButton();
        modalDialogPage.addLine(name,email,password);
        modalDialogPage.clickCreateAccountButton();

        assertEquals(name,modalDialogPage.getName(id));
        assertEquals(email,modalDialogPage.getEmail(id));
        assertEquals(password,modalDialogPage.getPassword(id));
    }

    private static Stream<Arguments> myDataProvider() {
        return Stream.of(
                Arguments.of("Serega", "example@gmail.com", "qweqwe", 2),
                Arguments.of("AnotherName", "test@gmail.com", "wwwwwww", 2)
        );
    }
}
