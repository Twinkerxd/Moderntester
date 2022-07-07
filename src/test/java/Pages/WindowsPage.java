package Pages;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class WindowsPage extends BaseSeleniumPage {
    @FindBy(id = "newBrowserWindow")
    private WebElement windowButton;

    @FindBy(id = "newMessageWindow")
    private WebElement messageButton;

    @FindBy(id = "newBrowserTab")
    private WebElement tabButton;

    @FindBy(xpath = "//body")
    private WebElement body;


    public WindowsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickWindowButton() {
        windowButton.click();
    }

    public void clickMessageButton() {
        messageButton.click();
    }

    public void clickTabButton() {
        tabButton.click();
    }

    public void switchToNewWindowOrTab() {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getBody() {
        return body.getText();
    }
}
