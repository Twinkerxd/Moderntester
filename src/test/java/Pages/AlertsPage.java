package Pages;

import Core.BaseSeleniumPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends BaseSeleniumPage {
    @FindBy(id = "simple-alert")
    private WebElement simpleAlertButton;

    @FindBy(id = "prompt-alert")
    private WebElement promptAlertButton;

    @FindBy(id = "confirm-alert")
    private WebElement confirmPopUp;

    @FindBy(id = "delayed-alert")
    private WebElement delayedAlert;

    @FindBy(id = "simple-alert-label")
    private WebElement simpleAlertLabel;

    @FindBy(id = "prompt-label")
    private WebElement promptLabel;

    @FindBy(id = "confirm-label")
    private WebElement confirmLabel;

    @FindBy(id = "delayed-alert-label")
    private WebElement delayedAlertLabel;

    public AlertsPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickSimpleAlertButton() {
        simpleAlertButton.click();
    }

    public void clickPromptAlertButton() {
        promptAlertButton.click();
    }

    public void clickConfirmPopUpButton() {
        confirmPopUp.click();
    }

    public void clickDelayedAlert() {
        delayedAlert.click();
    }

    public String getSimpleAlertLabel() {
        return simpleAlertLabel.getText();
    }

    public String getPromptLabel() {
        return promptLabel.getText();
    }

    public String getConfirmLabel() {
        return confirmLabel.getText();
    }

    public String getDelayedAlertLabel() {
        return delayedAlertLabel.getText();
    }

    public Alert waitForAlertToBeReady() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
