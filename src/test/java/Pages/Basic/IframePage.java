package Pages.Basic;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IframePage extends BaseSeleniumPage {
    @FindBy(xpath = "//iframe[@name='iframe1']") private WebElement iframe1;
    @FindBy(xpath = "//iframe[@name='iframe2']") private WebElement iframe2;
    @FindBy(xpath = "//input[@id='inputFirstName3']") private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='inputSurname3']") private WebElement surnameInput;
    @FindBy(xpath = "//input[@id='inputLogin']") private WebElement loginInput;
    @FindBy(xpath = "//input[@id='inputPassword']") private WebElement passwordInput;
    @FindBy(xpath = "//select[@id='inlineFormCustomSelectPref']") private WebElement continentsSelector;
    @FindBy(xpath = "//select[@id='inlineFormCustomSelectPref']/option") private List<WebElement> continentsSelectorValues;
    @FindBy(xpath = "//input[@class='form-check-input']") private List<WebElement> yearOfExpCheck;

    public IframePage() {
        PageFactory.initElements(driver,this);
    }

    public IframePage switchFrameTo(Frames frameNumber) {
        if (frameNumber.equals(Frames.FIRST_FRAME)) {
            driver.switchTo().frame(iframe1);
        } else if (frameNumber.equals(Frames.SECOND_FRAME)){
            driver.switchTo().frame(iframe2);
        } else if (frameNumber.equals(Frames.DEFAULT)){
            driver.switchTo().defaultContent();
        }
        return this;
    }

    public enum Frames {
        DEFAULT, FIRST_FRAME, SECOND_FRAME
    }

    public IframePage setFirstNameInput(String text) {
        firstNameInput.sendKeys(text);
        return this;
    }

    public IframePage setSurnameInput(String text) {
        surnameInput.sendKeys(text);
        return this;
    }

    public IframePage setLoginInput(String text) {
        loginInput.sendKeys(text);
        return this;
    }

    public IframePage setPasswordInput(String text) {
        passwordInput.sendKeys(text);
        return this;
    }

    public IframePage setContinent(Continents continentName) {
        continentsSelector.click();

        for (int i = 0; i < continentsSelectorValues.size(); i++) {
            if ((continentName + "").equals(continentsSelectorValues.get(i).getText().toUpperCase())) {
                continentsSelectorValues.get(i).click();
            }
        }

        return this;
    }

    public enum Continents {
        ASIA, EUROPE, AFRICA, ANTARCTICA, NORTH_AMERICA, SOUTH_AMERICA, AUSTRALIA
    }

    public IframePage setYearOfExp() {
        for (WebElement webElement:yearOfExpCheck) {
            webElement.click();
        }
        return this;
    }
}
