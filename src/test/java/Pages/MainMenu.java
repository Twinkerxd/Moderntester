package Pages;

import Core.BaseSeleniumPage;
import Pages.Basic.*;
import Pages.Widgets.WidgetsMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu extends BaseSeleniumPage {
    @FindBy(xpath = "//a[contains(text(),'Basic')]")
    private WebElement basicItem;

    @FindBy(xpath = "//a[contains(text(),'Widgets')]")
    private WebElement widgetsItem;

    public MainMenu() {
        PageFactory.initElements(driver,this);
    }

    public BasicMenu getBasicMenu() {
        mouseOver(basicItem);
        return new BasicMenu();
    }

    public WidgetsMenu getWidgetsMenu() {
        mouseOver(widgetsItem);
        return new WidgetsMenu();
    }
}
