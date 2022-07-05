package Pages;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IframePage extends BaseSeleniumPage {
    @FindBy(xpath = "//iframe[@name='iframe1']")
    private WebElement iframe1;

    @FindBy(xpath = "//iframe[@name='iframe2']")
    private WebElement iframe2;

    @FindBy(xpath = "//input[@id='inputFirstName3']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='inputSurname3']")
    private WebElement surnameInput;

    @FindBy(xpath = "//input[@id='inputLogin']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='inputPassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//select[@id='inlineFormCustomSelectPref']")
    private WebElement continentsSelector;

    @FindBy(xpath = "//select[@id='inlineFormCustomSelectPref']/option")
    private List<WebElement> continentsSelectorValues;

    @FindBy(xpath = "//div[@class='form-check']")
    private List<WebElement> yearOfExpCheck;

    public IframePage() {
        PageFactory.initElements(driver,this);
    }

    public void switchToFrame(int frameNumber) {
        if (frameNumber == 1) {
            driver.switchTo().frame(iframe1);
        } else if (frameNumber == 0){
            driver.switchTo().defaultContent();
        } else if (frameNumber == 2){
            driver.switchTo().frame(iframe2);
        }
    }

    public void setFirstNameInput(String text) {
        firstNameInput.sendKeys(text);
    }

    public void setSurnameInput(String text) {
        surnameInput.sendKeys(text);
    }

    public void setLoginInput(String text) {
        loginInput.sendKeys(text);
    }

    public void setPasswordInput(String text) {
        passwordInput.sendKeys(text);
    }

    public void continentsSelectorClick() {
        continentsSelector.click();
    }

    public void setContinent(int number) {
        continentsSelector.click();
        continentsSelectorValues.get(number).click();
    }

    public void setYearOfExp() {
        for (WebElement webElement:yearOfExpCheck) {
            webElement.click();
        }
    }
}
