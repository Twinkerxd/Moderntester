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
}
