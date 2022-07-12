package Pages.Widgets;

import Core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ModalDialogPage extends BaseSeleniumPage {
    @FindBy(id = "create-user") private WebElement newUserButton;
    @FindBy(xpath = "//tbody/tr") private List<WebElement> users;
    @FindBy(xpath = "//button[text()='Create an account']") private WebElement createAccountButton;
    private WebElement name;
    private WebElement email;
    private WebElement password;

    public ModalDialogPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickNewUserButton() {
        newUserButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void addLine(String name, String email, String password) {
        this.name.clear();
        this.name.sendKeys(name);
        this.email.clear();
        this.email.sendKeys(email);
        this.password.clear();
        this.password.sendKeys(password);
    }

    public String getName(int number) {
        return users.get(number - 1).findElement(By.xpath("./td[1]")).getText();
    }

    public String getEmail(int number) {
        return users.get(number - 1).findElement(By.xpath("./td[2]")).getText();
    }

    public String getPassword(int number) {
        return users.get(number - 1).findElement(By.xpath("./td[3]")).getText();
    }
}
