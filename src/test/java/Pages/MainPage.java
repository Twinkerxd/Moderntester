package Pages;

import Core.BaseSeleniumPage;
import Core.BaseSeleniumTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[contains(text(),'Basic')]")
    private WebElement basicItem;

    @FindBy(xpath = "//a[@id='iframes-item']")
    private WebElement iframesItem;

    @FindBy(xpath = "//a[@id='table-item']")
    private WebElement tableItem;

    @FindBy(xpath = "//a[@id='form-item']")
    private WebElement formItem;

    @FindBy(xpath = "//a[@id='alerts-item']")
    private WebElement alertsItem;

    @FindBy(xpath = "//a[@id='windows-tabs-item']")
    private WebElement windowsItem;

    public MainPage() {
        PageFactory.initElements(driver,this);
    }

    public IframePage getIframePage() {
        mouseOver(basicItem);
        iframesItem.click();
        return new IframePage();
    }

    public void basicItemClick() {
        basicItem.click();
    }

    public TablePage getTablePage() {
        mouseOver(basicItem);
        tableItem.click();
        return new TablePage();
    }

    public FormPage getFormPage() {
        mouseOver(basicItem);
        formItem.click();
        return new FormPage();
    }

    public AlertsPage getAlertsPage() {
        mouseOver(basicItem);
        alertsItem.click();
        return new AlertsPage();
    }

    public WindowsPage getWindowsPage() {
        mouseOver(basicItem);
        windowsItem.click();
        return new WindowsPage();
    }
}
