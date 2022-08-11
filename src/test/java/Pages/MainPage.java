package Pages;

import Core.BaseSeleniumPage;
import Pages.Basic.*;
import Pages.Widgets.WidgetsMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[contains(text(),'Basic')]") private WebElement basicItem;
    @FindBy(xpath = "//a[contains(text(),'Widgets')]") private WebElement widgetsItem;

    public MainPage() {
        PageFactory.initElements(driver,this);
    }

    public BasicMenu openBasicMenu() {
        mouseOver(basicItem);
        return new BasicMenu();
    }

    public WidgetsMenu openWidgetsMenu() {
        mouseOver(widgetsItem);
        return new WidgetsMenu();
    }
}
