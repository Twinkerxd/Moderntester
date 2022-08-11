package Pages.Basic;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicMenu extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@id='iframes-item']") private WebElement iframesItem;
    @FindBy(xpath = "//a[@id='table-item']") private WebElement tableItem;
    @FindBy(xpath = "//a[@id='form-item']") private WebElement formItem;
    @FindBy(xpath = "//a[@id='alerts-item']") private WebElement alertsItem;
    @FindBy(xpath = "//a[@id='windows-tabs-item']") private WebElement windowsItem;

    public BasicMenu() {
        PageFactory.initElements(driver,this);
    }

    public IframePage openIframePage() {
        iframesItem.click();
        return new IframePage();
    }

    public TablePage openTablePage() {
        tableItem.click();
        return new TablePage();
    }

    public FormPage openFormPage() {
        formItem.click();
        return new FormPage();
    }

    public AlertsPage openAlertsPage() {
        alertsItem.click();
        return new AlertsPage();
    }

    public WindowsPage getWindowsPage() {
        windowsItem.click();
        return new WindowsPage();
    }
}
