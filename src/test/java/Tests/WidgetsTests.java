package Tests;

import Core.BaseSeleniumTests;
import Pages.MainPage;
import Pages.Widgets.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WidgetsTests extends BaseSeleniumTests {
    private AccordionPage accordionPage;
    private AutoCompletePage autoCompletePage;
    private DataPickerPage dataPickerPage;
    private ToolTipPage toolTipPage;

    @Test
    public void accordion() {
        accordionPage = new MainPage().openWidgetsMenu().getAccordionPage();
        accordionPage.clickAccordionElement(2);
        accordionPage.clickAccordionElement(3);
        accordionPage.clickAccordionElement(4);
    }

    @Test
    public void autoComplete() {
        autoCompletePage = new MainPage().openWidgetsMenu().getAutoCompletePage();
        autoCompletePage.setSearchInput("a");
        autoCompletePage.autoCompleteValue("andreas johnson");
    }

    @Test
    public void datePicker() throws InterruptedException {
        dataPickerPage = new MainPage().openWidgetsMenu().getDataPickerPage();
        dataPickerPage.setDataPickerDay("13");
        Thread.sleep(1000);
    }

    @Test
    public void toolTip() {
        toolTipPage = new MainPage().openWidgetsMenu().getToolTipPage();
        toolTipPage.getToolTipText();
        System.out.println(toolTipPage.getToolTipText());
    }

    @ParameterizedTest(name = "Modal dialog {index}")
    @MethodSource("myDataProvider")
    public void modalDialog(String name, String email, String password, int id) {
        ModalDialogPage modalDialogPage = new MainPage()
                .openWidgetsMenu()
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
