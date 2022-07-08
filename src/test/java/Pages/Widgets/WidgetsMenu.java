package Pages.Widgets;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsMenu extends BaseSeleniumPage {
    @FindBy(id = "accordion-item")
    private WebElement accordionItem;

    @FindBy(id = "autocomplete-item")
    private WebElement autocompleteItem;

    @FindBy(id = "datepicker-item")
    private WebElement datePickerItem;

    @FindBy(id = "menu-item")
    private WebElement menuItem;

    @FindBy(id = "modal-dialog-item")
    private WebElement modalDialogItem;

    @FindBy(id = "progressbar-item")
    private WebElement progressbarItem;

    @FindBy(id = "selectmenu-item")
    private WebElement selectMenuItem;

    @FindBy(id = "slider-item")
    private WebElement sliderItem;

    @FindBy(id = "spinner-item")
    private WebElement spinnerItem;

    @FindBy(id = "tabs-item")
    private WebElement tabsItem;

    @FindBy(id = "tooltip-item")
    private WebElement tooltipItem;

    public WidgetsMenu() {
        PageFactory.initElements(driver,this);
    }

    public AccordionPage getAccordionPage() {
        accordionItem.click();
        return new AccordionPage();
    }

    public AutoCompletePage getAutoCompletePage() {
        autocompleteItem.click();
        return new AutoCompletePage();
    }

    public DataPickerPage getDataPickerPage() {
        datePickerItem.click();
        return new DataPickerPage();
    }

    public ToolTipPage getToolTipPage() {
        tooltipItem.click();
        return new ToolTipPage();
    }
}
