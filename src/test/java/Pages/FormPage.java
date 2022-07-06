package Pages;

import Core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.security.Key;
import java.util.List;
import java.util.Random;

public class FormPage extends BaseSeleniumPage {
    @FindBy(id = "inputFirstName3")
    private WebElement firstName;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(id = "inputEmail3")
    private WebElement email;

    @FindBy(xpath = "//input[@name='gridRadiosSex']")
    private List<WebElement> sex;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(xpath = "//input[@name='gridRadiosExperience']")
    private List<WebElement> yearOfExperience;

    @FindBy(xpath = "//input[@name='gridCheckboxProfession']")
    private List<WebElement> professions;

    @FindBy(xpath = "//select[@id='selectContinents']/option")
    private List<WebElement> selectOptions;

    @FindBy(xpath = "//select[@id='selectSeleniumCommands']/option")
    private List<WebElement> seleniumCommandsSelector;

    @FindBy(id = "chooseFile")
    private WebElement chooseFile;

    @FindBy(id = "additionalInformations")
    private WebElement additionalInformations;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    public FormPage() {
        PageFactory.initElements(driver,this);
    }

    public void setFirstName(String text) {
        firstName.sendKeys(text);
    }

    public void setLastName(String text) {
        lastName.sendKeys(text);
    }

    public void setEmail(String text) {
        email.sendKeys(text);
    }

    public void setRandomSex() {
        scrollToElement(sex.get(0));
        Random ran = new Random();
        sex.get(ran.nextInt(3)).click();
    }

    public void setAge(String age) {
        scrollToElement(this.age);
        this.age.sendKeys(age);
    }

    public void setRandomYearOfExperience() {
        scrollToElement(yearOfExperience.get(0));
        Random ran = new Random();
        yearOfExperience.get(ran.nextInt(7)).click();
    }

    public void setRandomProfessions() {
        scrollToElement(professions.get(0));
        Random ran = new Random();
        professions.get(ran.nextInt(2) + 1).click();
    }

    public void setRandomContinentsSelect() {
        scrollToElement(selectOptions.get(0));
        Random ran = new Random();
        selectOptions.get(ran.nextInt(7) + 1).click();
    }

    public void setSeleniumCommandsSelector() {
        scrollToElement(seleniumCommandsSelector.get(0));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(seleniumCommandsSelector.get(2)).keyUp(Keys.SHIFT).perform();
        actions.keyDown(Keys.SHIFT).click(seleniumCommandsSelector.get(3)).keyUp(Keys.SHIFT).perform();
    }

    public void uploadFile(String path) {
        scrollToElement(chooseFile);
        File file = new File(path);
        chooseFile.sendKeys(file.getAbsolutePath());
    }

    public void setAdditionalInformations(String text) {
        scrollToElement(additionalInformations);
        additionalInformations.sendKeys(text);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getValidatorMessage() {
        return validatorMessage.getText();
    }
}
